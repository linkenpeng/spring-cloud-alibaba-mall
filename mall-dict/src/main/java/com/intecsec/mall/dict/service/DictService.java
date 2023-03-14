package com.intecsec.mall.dict.service;

import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.dict.dto.DictDTO;
import com.intecsec.mall.dict.dto.DictQueryVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-04 23:18
 **/
public interface DictService {

    int add(DictDTO dictDTO);

    int update(DictDTO dictDTO);

    int updateHasChildren(long id);

    int delete(long id);

    DictDTO get(long id);

    List<DictDTO> getChildData(long id);

    List<DictDTO> getRootData();

    String exportData(HttpServletResponse response);

    PageData<DictDTO> pageList(int page, int pageSize, DictQueryVO dictQueryVO);

}
