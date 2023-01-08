import request from '@/utils/request'

export default {

  getItemList(page, pageSize, searchObj) {
    return request({
      url: `/item/list/${page}/${pageSize}`,
      method: 'post',
      data: searchObj
    })
  },

  saveItem(itemData) {
    return request({
      url: `/item/save`,
      method: 'post',
      data: itemData
    })
  },

  getItemById(id) {
    return request({
      url: `/item/${id}`,
      method: 'get'
    })
  },

  updateItem(itemData) {
    return request({
      url: `/item/save`,
      method: 'post',
      data: itemData
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
  },

  getAllCategory() {
    return request({
      url: `/item/category/getAllCategory`,
      method: 'get'
    })
  }

}
