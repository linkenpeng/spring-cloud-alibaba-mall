package com.intecsec.mall.dict.controller;

import com.intecsec.mall.common.response.ApiResponse;
import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.dict.dto.DictDTO;
import com.intecsec.mall.dict.dto.DictQueryVO;
import com.intecsec.mall.dict.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

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

    @GetMapping(value = "/{id}")
    public ApiResponse<DictDTO> getById(@PathVariable Long id) {
        DictDTO dictDTO = dictService.get(id);
        return new ApiResponse(dictDTO);
    }

    @GetMapping(value = "/exportData")
    public ApiResponse<String> exportData(HttpServletResponse response) {
        String result = dictService.exportData(response);
        return new ApiResponse(result);
    }

    @PostMapping(value = "/importData")
    public ApiResponse<String> importData(MultipartFile file) {
        String result = dictService.importData(file);
        return new ApiResponse(result);
    }

    @GetMapping(value = "/getChildData/{id}")
    public ApiResponse<List<DictDTO>> getChildData(@PathVariable Long id) {
        List<DictDTO> dictDTOList = dictService.getChildData(id);
        return new ApiResponse(dictDTOList);
    }

    @GetMapping(value = "/getRootData")
    public ApiResponse<List<DictDTO>> getRootData() {
        List<DictDTO> dictDTOList = dictService.getRootData();
        return new ApiResponse(dictDTOList);
    }

    @PostMapping(value = "/list/{page}/{pageSize}")
    public ApiResponse<PageData<DictDTO>> getPageList(@PathVariable Integer page,
                                                   @PathVariable Integer pageSize,
                                                   @RequestBody(required = false) DictQueryVO queryVO) {
        PageData<DictDTO> pageData = dictService.pageList(page, pageSize, queryVO);
        return new ApiResponse(pageData);
    }

    @PostMapping(value = "/save")
    public ApiResponse<Integer> save(@RequestBody DictDTO dictDTO) {
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
