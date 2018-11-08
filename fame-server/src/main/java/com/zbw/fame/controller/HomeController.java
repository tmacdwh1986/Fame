package com.zbw.fame.controller;

import com.github.pagehelper.Page;
import com.zbw.fame.dto.Archives;
import com.zbw.fame.dto.CommentDto;
import com.zbw.fame.dto.MetaDto;
import com.zbw.fame.dto.Pagination;
import com.zbw.fame.model.Articles;
import com.zbw.fame.model.Comments;
import com.zbw.fame.service.ArticlesService;
import com.zbw.fame.service.CommentsService;
import com.zbw.fame.service.EmailService;
import com.zbw.fame.service.MetasService;
import com.zbw.fame.util.FameConsts;
import com.zbw.fame.util.FameUtil;
import com.zbw.fame.util.RestResponse;
import com.zbw.fame.util.Types;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.zbw.fame.dto.VehicleDistance;
import com.zbw.fame.service.DayDistanceService;
import com.zbw.fame.util.RestResponse;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 博客前台 Controller
 *
 * @author zbw
 * @since 2017/7/15 18:29
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class HomeController extends BaseController {

    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private MetasService metasService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private DayDistanceService dayDistanceService;

    /**
     * 文章列表
     *
     * @param page  第几页
     * @param limit 每页数量
     * @return {@see Pagination<Articles>}
     */
    @GetMapping("article")
    public RestResponse home(@RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = FameConsts.PAGE_SIZE) Integer limit) {
        Page<Articles> articles = articlesService.getContents(page, limit);
        for (Articles a : articles) {
            this.transformPreView(a);
        }
        return RestResponse.ok(new Pagination<Articles>(articles));
    }

    /**
     * 文章内容页
     *
     * @param id 文章id
     * @return {@see Articles}
     */
    @GetMapping("article/{id}")
    public RestResponse content(@PathVariable Integer id) {
        Articles article = articlesService.get(id);
        if (null == article || Types.DRAFT.equals(article.getStatus())) {
            return this.error404();
        }
        this.transformContent(article);
        this.updateHits(article.getId(), article.getHits());
        return RestResponse.ok(article);
    }

    /**
     * 点击量添加
     *
     * @param articleId 文章id
     * @param hits      当前点击量
     */
    private void updateHits(Integer articleId, Integer hits) {
        Integer cHits = cache.get(FameConsts.CACHE_ARTICLE_HITS, articleId.toString());
        cHits = null == cHits ? 1 : cHits + 1;
        if (cHits >= FameConsts.CACHE_ARTICLE_HITS_SAVE) {
            Articles temp = new Articles();
            temp.setId(articleId);
            temp.setHits(hits + cHits);
            articlesService.updateArticle(temp);
            cache.put(FameConsts.CACHE_ARTICLE_HITS, articleId.toString(), 0);
        } else {
            cache.put(FameConsts.CACHE_ARTICLE_HITS, articleId.toString(), cHits);
        }
    }


    /**
     * 标签页
     *
     * @return {@see List<MetaDto>}
     */
    @GetMapping("tag")
    public RestResponse tag() {
        List<MetaDto> metaDtos = metasService.getMetaDtos(Types.TAG);
        return RestResponse.ok(metaDtos);
    }

    /**
     * 分类页
     *
     * @return {@see List<MetaDto>}
     */
    @GetMapping("/category")
    public RestResponse category() {
        List<MetaDto> metaDtos = metasService.getMetaDtos(Types.CATEGORY);
        return RestResponse.ok(metaDtos);
    }

    /**
     * 归档页
     *
     * @return {@see List<Archives>}
     */
    @GetMapping("archive")
    public RestResponse archive() {
        Integer maxLimit = 9999;
        List<Articles> articles = articlesService.getContents(1, maxLimit);
        List<Archives> archives = new ArrayList<>();
        String current = "";
        for (Articles article : articles) {
            // 清空文章内容
            article.setContent("");
            Calendar cal = Calendar.getInstance();
            cal.setTime(article.getCreated());
            String dateStr = cal.get(Calendar.YEAR) + "";
            if (dateStr.equals(current)) {
                Archives arc = archives.get(archives.size() - 1);
                arc.getArticles().add(article);
                arc.setCount(arc.getArticles().size());
            } else {
                current = dateStr;
                Archives arc = new Archives();
                arc.setDateStr(dateStr);
                arc.setCount(1);
                List<Articles> arts = new ArrayList<>();
                arts.add(article);
                arc.setArticles(arts);
                archives.add(arc);
            }
        }
        return RestResponse.ok(archives);
    }

    /**
     * 自定义页面
     *
     * @param title 页面标题
     * @return {@see Articles}
     */
    @GetMapping("page/{title}")
    public RestResponse page(@PathVariable String title) {
        Articles page = articlesService.getPage(title);
        if (null == page) {
            return error404();
        }
        transformContent(page);
        return RestResponse.ok(page);
    }

    /**
     * 获取文章的评论
     *
     * @param articleId 文章id
     * @param page      第几页
     * @param limit     每页数量
     * @return {@see Pagination<Comments>}
     */
    @GetMapping("comment")
    public RestResponse getArticleComment(@RequestParam Integer articleId, @RequestParam(required = false, defaultValue = "1") Integer page,
                                          @RequestParam(required = false, defaultValue = FameConsts.PAGE_SIZE) Integer limit) {
        Page<Comments> comments = commentsService.getCommentsByArticleId(articleId, page, limit);
        for (Comments comment : comments) {
            comment.setContent(FameUtil.mdToHtml(comment.getContent()));
        }
        return RestResponse.ok(new Pagination<Comments>(comments));
    }


    /**
     * 发表评论
     *
     * @param articleId 文章id
     * @param pId       父评论id
     * @param content   评论内容
     * @param name      评论用户名
     * @param email     评论用户email
     * @param website   评论用户网址
     * @return {@see RestResponse.ok()}
     */
    @PostMapping("comment")
    public RestResponse postComment(@RequestParam Integer articleId, @RequestParam(required = false) Integer pId,
                                    @RequestParam String content, @RequestParam String name,
                                    @RequestParam(required = false) String email, @RequestParam(required = false) String website) {
        Comments comments = new Comments();
        comments.setArticleId(articleId);
        comments.setPId(pId);
        comments.setContent(content);
        comments.setName(name);
        comments.setEmail(email);
        comments.setWebsite(website);
        comments.setIp(FameUtil.getIp());
        comments.setAgent(FameUtil.getAgent());
        commentsService.save(comments);

        //发送邮件提醒
        CommentDto commentDetail = commentsService.getCommentDetail(comments.getId());
        emailService.sendEmailToAdmin(commentDetail);
        if (null != commentDetail.getPComment() && !StringUtils.isEmpty(commentDetail.getPComment().getEmail())) {
            emailService.sendEmailToUser(commentDetail, commentDetail.getPComment().getEmail());
        }
        return RestResponse.ok();
    }

    /**
     * 顶或踩评论
     *
     * @param commentId 评论id
     * @param assess    {@link Types#AGREE},{@link Types#DISAGREE}
     * @return {@see RestResponse.ok()}
     */
    @PostMapping("comment/{commentId}/assess")
    public RestResponse assessComment(@PathVariable Integer commentId, @RequestParam String assess) {
        commentsService.assessComment(commentId, assess);
        return RestResponse.ok();
    }


    /**
     * 文章内容转为html
     *
     * @param article 文章实体类
     */
    private void transformContent(Articles article) {
        String html = FameUtil.mdToHtml(article.getContent());
        article.setContent(html);
    }

    /**
     * 文章内容转为预览html
     *
     * @param article 文章实体类
     */
    private void transformPreView(Articles article) {
        String html = FameUtil.mdToHtml(FameUtil.getPreView(article.getContent()));
        article.setContent(html);
    }


	@GetMapping("/Distance")
	public RestResponse statDayDistance(HttpServletRequest request, HttpServletResponse response) {

		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		// String flag = request.getParameter("flag");
		// String city = request.getParameter("city");
		String flag = "1";
		String city = "ShangHai";
		String[] isWorkArr = new String[] { "1", "2", "0" };
		List<VehicleDistance> list = new ArrayList<VehicleDistance>();
        log.info("[DEBUG]distance entry point");
		for (int i = 0; i < isWorkArr.length; i++) {
			Map<String, Object> ret = new HashMap<String, Object>();
			list = dayDistanceService.statDayDistance(isWorkArr[i], city);

			String[] xAxis = new String[] {};
			String[] xAxisAccu = new String[] {};
			int[] countArr = new int[] {};
			if (flag.equals("0")) {
				xAxis = new String[] { "0=<distance<1km", "1=<distance<10km", "10=<distance<20km", "20=<distance<30km",
						"30=<distance<40km", "40=<distance<50km", "50=<distance<60km", "60=<distance<70km",
						"70=<distance<80km", "80=<distance<90km", "90=<distance<100km", "100=<distance<120km",
						"120=<distance<150km", "150=<distance<200km", "distance>=200km" };
				countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			} else if (flag.equals("1")) {
				list.remove(0);
				xAxis = new String[] { "1=<distance<10km", "10=<distance<20km", "20=<distance<30km",
						"30=<distance<40km", "40=<distance<50km", "50=<distance<60km", "60=<distance<70km",
						"70=<distance<80km", "80=<distance<90km", "90=<distance<100km", "100=<distance<120km",
						"120=<distance<150km", "150=<distance<200km", "distance>=200km" };
				countArr = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			}
			xAxisAccu = new String[xAxis.length];

			int total = 0;
			for (int j = 0; j < xAxis.length; j++) {
				String xValue = xAxis[j];
				for (int k = 0; k < list.size(); k++) {
					VehicleDistance data = list.get(k);
					String distanceRange = data.getDistance_range().substring(3, data.getDistance_range().length());
					if (xValue.equals(distanceRange)) {
						int counts = data.getCounts();
						countArr[j] = counts;
						total = total + counts;
						break;
					}
				}
				if (xValue.indexOf("=<") != -1) {
					if (flag.equals("0")) {
						xAxisAccu[j] = "0=<" + xValue.substring(xValue.indexOf("=<") + 2, xValue.length());
					} else if (flag.equals("1")) {
						xAxisAccu[j] = "1=<" + xValue.substring(xValue.indexOf("=<") + 2, xValue.length());
					}
				} else {
					xAxisAccu[j] = xValue;
				}
			}
			float[] yAxis = new float[countArr.length];
			for (int j = 0; j < countArr.length; j++) {
				yAxis[j] = (float) countArr[j] * 100 / total;
			}
			ret.put("xAxis", xAxis);
            log.info("xAxis", Arrays.toString(xAxis));
			ret.put("yAxis", yAxis);
            log.info("yAxis",Arrays.toString(yAxis));
			ret.put("xAxisAccu", xAxisAccu);
            log.info("xAxisAccu",Arrays.toString(xAxisAccu));
			float[] yAxisAccu = new float[countArr.length];
			for (int k = 0; k < countArr.length; k++) {
				if (k == 0 || k == countArr.length - 1) {
					yAxisAccu[k] = (float) countArr[k] * 100 / total;
				} else {
					int accu = 0;
					for (int j = k; j >= 0; j--) {
						accu = accu + countArr[j];
					}
					yAxisAccu[k] = (float) accu * 100 / total;
				}

			}
			ret.put("yAxisAccu", yAxisAccu);
			log.info("yAxisAccu",Arrays.toString(yAxisAccu));
            log.info("[DEBUG]distance return value: {}", ret);

			retList.add(ret);
		}

		return RestResponse.ok(retList);
	}
}
