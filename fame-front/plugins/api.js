import { get, post } from './http'

const api = {
  getCategories () {
    return get('/category')
  },
  getTags () {
    return get('/tag')
  },
  getDistance () {
    return get('/Distance')
  },
  getPage (title) {
    return get('/page/' + title)
  },
  getArchives () {
    return get('/archive')
  },
  getPeriod () {
    return get('/period')
  },
  getSoc () {
    return get('/soc')
  },
  getChrgDistance () {
    return get('/ChrgDistance')
  },
  getChrgDuration () {
    return get('/ChrgDuration')
  },
  getChrgStartTime () {
    return get('/ChrgStartTime')
  },
  getChrgEndTime () {
    return get('/ChrgEndTime')
  },
  getAcc () {
    return get('/accel')
  },
  getTrip () {
    return get('/trip')
  },
  getTripDuration () {
    return get('/TripDuration')
  },
  getAvgTripDuration () {
    return get('/avgTripDuration')
  },
  getAvgTripDistance () {
    return get('/avgTripDistance')
  },
  getDayDistance () {
    return get('/DayDistance')
  },
  getDayDuration () {
    return get('/DayDuration')
  },
  getAvgDayDuration () {
    return get('/avgDayDuration')
  },
  getAvgDayDistance () {
    return get('/avgDayDistance')
  },
  getComment (articleId, page, limit) {
    let params = {
      articleId: articleId,
      page: page,
      limit: limit || 5
    }
    return get('comment', params)
  },
  postComment (articleId, pid, content, name, email, website) {
    let params = {
      articleId: articleId,
      pid: pid,
      content: content,
      name: name,
      email: email,
      website: website
    }
    return post('/comment', params)
  },
  assessComment (commentId, assess) {
    let params = {
      assess: assess
    }
    return post('/comment/' + commentId + '/assess', params)
  }
}

export default api
