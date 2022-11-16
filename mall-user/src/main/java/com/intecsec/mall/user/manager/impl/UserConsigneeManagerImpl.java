package com.intecsec.mall.user.manager.impl;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.entity.UserConsignee;
import com.intecsec.mall.user.manager.UserConsigneeManager;
import com.intecsec.mall.user.mapper.UserConsigneeMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
@Repository
public class UserConsigneeManagerImpl implements UserConsigneeManager {

    @Resource
    private UserConsigneeMapper userConsigneeMapper;

    @Override
    public UserConsigneeDTO getOne(Long id) {
        UserConsignee userConsignee = userConsigneeMapper.selectById(id);
        return DOUtils.copy(userConsignee, UserConsigneeDTO.class);
    }

    @Override
    public List<UserConsigneeDTO> getList(int page, int pageSize) {
        return null;
    }

    @Override
    public int update(Long id, UserConsigneeDTO consigneeDTO) {
        UserConsignee userConsignee = DOUtils.copy(consigneeDTO, UserConsignee.class);
        return userConsigneeMapper.updateById(userConsignee);
    }

    @Override
    public int delete(Long id) {
        return userConsigneeMapper.deleteById(id);
    }
}
