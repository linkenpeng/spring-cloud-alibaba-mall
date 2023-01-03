import request from '@/utils/request'

export function getItemList(page, pageSize, searchObj) {
  return request({
    url: `/item/list?page=${page}&pageSize=${pageSize}`,
    method: 'get',
    params: searchObj
  })
}

