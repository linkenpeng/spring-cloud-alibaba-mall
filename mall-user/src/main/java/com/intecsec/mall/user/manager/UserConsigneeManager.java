package com.intecsec.mall.user.manager;

import com.intecsec.mall.user.dto.UserConsigneeDTO;

import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
public interface UserConsigneeManager {

    UserConsigneeDTO getOne(Long id);

    List<UserConsigneeDTO> getList(int page, int pageSize);

    int update(Long id, UserConsigneeDTO consigneeDTO);

    int delete(Long id);
}
