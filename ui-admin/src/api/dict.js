import request from '@/utils/request'

export default {

  getRootData() {
    return request({
      url: `/dict/getRootData`,
      method: 'get',
    })
  },

  getChildData(id) {
    return request({
      url: `/dict/getChildData/${id}`,
      method: 'get',
    })
  },

}
