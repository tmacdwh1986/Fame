import api from '~/plugins/api'

export const actions = {
  // 分类列表
  async getCategories ({ commit }) {
    let { data } = await api.getCategories()
    commit('category/SET_DATA', data)
  },
  async getDistance ({ commit }) {
    let { data } = await api.getDistance()
    commit('distance/SET_DATA', data)
  },
  // 归档
  async getArchive ({ commit }) {
    let { data } = await api.getArchives()
    commit('archive/SET_DATA', data)
  },
  async getTrip ({ commit }) {
    let { data } = await api.getTrip()
    commit('trip/SET_DATA', data)
  },
  async getPeriod ({ commit }) {
    let { data } = await api.getPeriod()
    commit('period/SET_DATA', data)
  },
  async getChrgDistance ({ commit }) {
    let { data } = await api.getChrgDistance()
    commit('chrgdistance/SET_DATA', data)
  },
  async getChrgDuration ({ commit }) {
    let { data } = await api.getChrgDuration()
    commit('chrgduration/SET_DATA', data)
  },
  async getChrgStartTime ({ commit }) {
    let { data } = await api.getChrgStartTime()
    commit('chrgstarttime/SET_DATA', data)
  },
  async getChrgEndTime ({ commit }) {
    let { data } = await api.getChrgEndTime()
    commit('chrgendtime/SET_DATA', data)
  },
  async getAcc ({ commit }) {
    let { data } = await api.getAcc()
    commit('accel/SET_DATA', data)
  },
  async getTripDuration ({ commit }) {
    let { data } = await api.getTripDuration()
    commit('tripduration/SET_DATA', data)
  },
  async getAvgTripDuration ({ commit }) {
    let { data } = await api.getAvgTripDuration()
    commit('avgtirpduration/SET_DATA', data)
  },
  async getAvgTripDistance ({ commit }) {
    let { data } = await api.getAvgTripDistance()
    commit('avgtirpdistance/SET_DATA', data)
  },
  async getDayDistance ({ commit }) {
    let { data } = await api.getDayDistance()
    commit('daydistance/SET_DATA', data)
  },
  async getDayDuration ({ commit }) {
    let { data } = await api.getDayDuration()
    commit('dayduration/SET_DATA', data)
  },
  async getAvgDayDuration ({ commit }) {
    let { data } = await api.getAvgDayDuration()
    commit('avgdayduration/SET_DATA', data)
  },
  async getAvgDayDistance ({ commit }) {
    let { data } = await api.getAvgDayDistance()
    commit('avgdaydistance/SET_DATA', data)
  },
  async getSoc ({ commit }) {
    let { data } = await api.getSoc()
    commit('soc/SET_DATA', data)
  },
  async getChrgStartSOC ({ commit }) {
    let { data } = await api.getChrgStartSOC()
    commit('chrgstartsoc/SET_DATA', data)
  },
  async getChrgEndSOC ({ commit }) {
    let { data } = await api.getChrgEndSOC()
    commit('chrgendsoc/SET_DATA', data)
  },
  async getChrgDeltaSOC ({ commit }) {
    let { data } = await api.getChrgDeltaSOC()
    commit('chrgdeltasoc/SET_DATA', data)
  },
  // 自定义页面
  async getPage ({ commit }, title) {
    let { data } = await api.getPage(title)
    commit('article/SET_PAGE', data)
  },
  // 评论列表
  async getComments ({ commit }, params) {
    let { data } = await api.getComment(params.articleId, params.page, params.limit)
    let pagination = {
      list: data.list,
      total: data.total
    }
    commit('comment/SET_LIST', pagination)
    return pagination
  },
  // 提交评论
  async submitComment ({ commit }, params) {
    return api.postComment(params.articleId, params.replyCommentId, params.content,
      params.name, params.email, params.website)
  },
  // 赞同评论
  async agreeComment ({ commit }, commentId) {
    const res = await api.assessComment(commentId, 'agree')
    if (res && res.success) {
      commit('comment/AGREE_COMMENT', commentId)
    }
    return res
  },
  // 反对评论
  async disagreeComment ({ commit }, commentId) {
    const res = await api.assessComment(commentId, 'disagree')
    if (res && res.success) {
      commit('comment/DISAGREE_COMMENT', commentId)
    }
    return res
  }
}
