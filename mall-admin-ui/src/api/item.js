import request from '@/utils/request'

export function getItemList(page, pageSize) {
  return request({
    url: '/item/list',
    method: 'get',
    params: { 'page': page, 'papageSizege': pageSize }
  })
}

