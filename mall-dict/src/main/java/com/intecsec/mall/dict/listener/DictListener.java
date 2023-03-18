package com.intecsec.mall.dict.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.dict.entity.Dict;
import com.intecsec.mall.dict.mapper.DictMapper;
import com.intecsec.mall.dict.vo.DictVO;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-18 22:01
 **/
public class DictListener extends AnalysisEventListener<DictVO> {

    private DictMapper dictMapper;

    public DictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    @Override
    public void invoke(DictVO dictVO, AnalysisContext analysisContext) {
        Dict dict = DOUtils.copy(dictVO, Dict.class);
        dictMapper.insert(dict);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
