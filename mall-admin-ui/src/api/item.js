import request from '@/utils/request'

export default {

  getItemList(page, pageSize, searchObj) {
    return request({
      url: `/item/list/${page}/${pageSize}`,
      method: 'post',
      data: searchObj
    })
  },

  deleteById(id) {
    return request({
      url: `/item/${id}`,
      method: 'delete'
    })
  }

}
