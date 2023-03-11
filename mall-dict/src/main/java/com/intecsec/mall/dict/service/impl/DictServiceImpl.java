package com.intecsec.mall.dict.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.dict.dto.DictDTO;
import com.intecsec.mall.dict.dto.DictQueryVO;
import com.intecsec.mall.dict.entity.Dict;
import com.intecsec.mall.dict.mapper.DictMapper;
import com.intecsec.mall.dict.service.DictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-04 23:18
 **/
@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictMapper dictMapper;


    @Override
    public int add(DictDTO dictDTO) {
        Dict dict = DOUtils.copy(dictDTO, Dict.class);
        int result = dictMapper.insert(dict);
        updateHasChildren(dict.getId());
        return result;
    }

    @Override
    public int update(DictDTO dictDTO) {
        Dict dict = DOUtils.copy(dictDTO, Dict.class);
        int result = dictMapper.updateById(dict);
        updateHasChildren(dict.getId());
        return result;
    }

    @Override
    public int delete(long id) {
        int result = dictMapper.deleteById(id);
        updateHasChildren(id);
        return result;
    }

    @Override
    public DictDTO get(long id) {
        Dict dict = dictMapper.selectById(id);
        return DOUtils.copy(dict, DictDTO.class);
    }

    @Override
    public List<DictDTO> getChildData(long id) {
        QueryWrapper<Dict> queryWrapper = getChildWrapper(id);
        List<Dict> list = dictMapper.selectList(queryWrapper);
        return DOUtils.copyList(list, DictDTO.class);
    }

    private QueryWrapper<Dict> getChildWrapper(long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", id);
        return queryWrapper;
    }

    @Override
    public List<DictDTO> getRootData() {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        List<Dict> list = dictMapper.selectList(queryWrapper);
        return DOUtils.copyList(list, DictDTO.class);
    }

    public int updateHasChildren(long id) {
        QueryWrapper<Dict> queryWrapper = getChildWrapper(id);
        Long count = dictMapper.selectCount(queryWrapper);
        Dict dict = dictMapper.selectById(id);
        if(count > 0) {
            dict.setHasChildren(true);
        } else {
            dict.setHasChildren(false);
        }
        return dictMapper.updateById(dict);
    }

    @Override
    public PageData<DictDTO> pageList(int page, int pageSize, DictQueryVO dictQueryVO) {
        QueryWrapper<Dict> queryWrapper = getQueryWrapper(dictQueryVO);

        Page<Dict> dictPage = new Page<>(page, pageSize);
        Page<Dict> pageResult = dictMapper.selectPage(dictPage, queryWrapper);
        List<Dict> dictList = pageResult.getRecords();
        List<DictDTO> dictDTOS = DOUtils.copyList(dictList, DictDTO.class);

        PageData<DictDTO> pageData = new PageData<>();
        pageData.setList(dictDTOS);
        pageData.setTotal(pageResult.getTotal());
        pageData.setSize(pageResult.getSize());
        pageData.setCurrent(pageResult.getCurrent());

        return pageData;
    }

    private QueryWrapper<Dict> getQueryWrapper(DictQueryVO dictQueryVO) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        if(Objects.nonNull(dictQueryVO)) {
            if(dictQueryVO.getId() != null && dictQueryVO.getId() > 0L) {
                queryWrapper.eq("id", dictQueryVO.getId());
            }
            if(StringUtils.isNotEmpty(dictQueryVO.getName())) {
                queryWrapper.eq("name", dictQueryVO.getName());
            }
            if(StringUtils.isNotEmpty(dictQueryVO.getValue())) {
                queryWrapper.eq("value", dictQueryVO.getValue());
            }
            if(StringUtils.isNotEmpty(dictQueryVO.getDictCode())) {
                queryWrapper.eq("dict_code", dictQueryVO.getDictCode());
            }
        }
        queryWrapper.orderByAsc("id");
        return queryWrapper;
    }
}
