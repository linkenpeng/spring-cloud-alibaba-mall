import request from '@/utils/request'

export default {

  getChildData(id) {
    return request({
      url: `/dic/getChildData/${id}`,
      method: 'get',
    })
  },

}
