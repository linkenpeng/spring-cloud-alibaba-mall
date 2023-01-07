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
  },

  deleteByIdList(idList) {
    return request({
      url: `/item/deleteBatch`,
      method: 'delete',
      data: idList
    })
  },

  changeStatus(id, status) {
    return request({
      url: `/item/changeStatus/${id}/${status}`,
      method: 'put'
    })
  }

}
