import request from '@/utils/request'

export function getItemList(page, pageSize, searchObj) {
  return request({
    url: `/item/list/${page}/${pageSize}`,
    method: 'post',
    data: searchObj
  })
}

