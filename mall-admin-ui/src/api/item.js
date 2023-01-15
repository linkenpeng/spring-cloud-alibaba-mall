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

  saveSku(skuData) {
    return request({
      url: `/item/sku/save`,
      method: 'post',
      data: skuData
    })
  },

  getItemById(id) {
    return request({
      url: `/item/${id}`,
      method: 'get'
    })
  },

  getSkuById(id) {
    return request({
      url: `/item/sku/${id}`,
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

  updateSku(skuData) {
    return request({
      url: `/item/sku/save`,
      method: 'post',
      data: skuData
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
