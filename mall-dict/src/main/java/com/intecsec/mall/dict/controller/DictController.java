package com.intecsec.mall.dict.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.dict.dto.DictDTO;
import com.intecsec.mall.dict.dto.DictQueryVO;
import com.intecsec.mall.dict.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-04 23:19
 **/
@RestController
@RequestMapping("/dict")
@Slf4j
public class DictController {

    @Resource
    private DictService dictService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResponse<DictDTO> itemDetail(@PathVariable Long id) {
        DictDTO dictDTO = dictService.get(id);
        return new ApiResponse(dictDTO);
    }

    @RequestMapping(value = "/list/{page}/{pageSize}", method = RequestMethod.POST)
    public ApiResponse<PageData<DictDTO>> itemList(@PathVariable Integer page,
                                                   @PathVariable Integer pageSize,
                                                   @RequestBody(required = false) DictQueryVO queryVO) {
        PageData<DictDTO> pageData = dictService.pageList(page, pageSize, queryVO);
        return new ApiResponse(pageData);
    }

    @PostMapping(value = "/save")
    public ApiResponse<Integer> itemSave(@RequestBody DictDTO dictDTO) {
        log.info("dictDTO:{}", JsonUtils.toJson(dictDTO));
        int result;
        if(dictDTO.getId() != null && dictDTO.getId() > 0L) {
            result = dictService.update(dictDTO);
        } else {
            result = dictService.add(dictDTO);
        }
        return new ApiResponse(result);
    }

}
