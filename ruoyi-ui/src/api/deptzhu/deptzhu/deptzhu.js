import request from '@/utils/request'

// 查询成型方式分组列表
export function listDeptzhu(query) {
  return request({
    url: '/deptzhu/deptzhu/list',
    method: 'get',
    params: query
  })
}

// 查询成型方式分组详细
export function getDeptzhu(id) {
  return request({
    url: '/deptzhu/deptzhu/' + id,
    method: 'get'
  })
}

// 新增成型方式分组
export function addDeptzhu(data) {
  return request({
    url: '/deptzhu/deptzhu',
    method: 'post',
    data: data
  })
}

// 修改成型方式分组
export function updateDeptzhu(data) {
  return request({
    url: '/deptzhu/deptzhu',
    method: 'put',
    data: data
  })
}

// 删除成型方式分组
export function delDeptzhu(id) {
  return request({
    url: '/deptzhu/deptzhu/' + id,
    method: 'delete'
  })
}
