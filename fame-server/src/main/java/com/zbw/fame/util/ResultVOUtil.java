package com.zbw.fame.util;

import com.zbw.fame.VO.ResultVO;

/**
 * Created by 廖师兄 2017-05-15 00:22
 */
public class ResultVOUtil {

	public static ResultVO success(Object object) {
		ResultVO resultVO = new ResultVO();
		resultVO.setData(object);
		resultVO.setCode(0);
		resultVO.setMsg("success");
		return resultVO;
	}

	public static ResultVO success() {
		return success(null);
	}

	public static ResultVO error(Integer code, String msg) {
		ResultVO resultVO = new ResultVO();
		resultVO.setCode(code);
		resultVO.setMsg(msg);
		return resultVO;
	}
}
