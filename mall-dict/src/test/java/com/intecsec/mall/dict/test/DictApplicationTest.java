package com.intecsec.mall.dict.test;

import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.dict.dto.DictDTO;
import com.intecsec.mall.dict.mapper.DictMapper;
import com.intecsec.mall.dict.service.DictService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: peter.peng
 * @create: 2023-03-09 22:15
 **/
@SpringBootTest
public class DictApplicationTest {

    @Resource
    private DictMapper dictMapper;

    @Resource
    private DictService dictService;

    @Test
    public void updateHashChildren() {
        int pageSize = 100;
        int page = 1;
        int thread = 1;
        long start = System.currentTimeMillis();
        updateAllHashChildren(page, pageSize, thread);
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));
    }

    private void updateAllHashChildren(int page, int pageSize, int thread) {
        System.out.println("page:" + page + ", pageSize:" + pageSize);
        PageData<DictDTO> dictDTOPageData = dictService.pageList(page, pageSize, null);
        if (dictDTOPageData != null && dictDTOPageData.getList().size() > 0) {

            Map<Integer, List<DictDTO>> group = new HashMap<>();
            if(thread > 0) {
                int j = 0;
                for(DictDTO dictDTO : dictDTOPageData.getList()) {
                    for(int i = 0; i < thread; i++) {
                        if(thread % j == i) {
                            if(!group.containsKey(i)) {
                                List<DictDTO> list = new ArrayList<>();
                                group.put(i, list);
                            }
                            group.get(i).add(dictDTO);
                        }
                    }
                    j++;
                }
            }

            System.out.println(JsonUtils.toJson(group));
            System.exit(0);


            ExecutorService executorService = new ThreadPoolExecutor(thread, thread, 1000L,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(pageSize));

            for(Map.Entry<Integer, List<DictDTO>> entry : group.entrySet()) {
                System.out.println("current thread:" + entry.getKey());
                executorService.submit(() -> {
                    long start = System.currentTimeMillis();
                    for (DictDTO dictDTO : entry.getValue()) {
                        dictService.updateHasChildren(dictDTO.getId());
                    }
                    long end = System.currentTimeMillis();
                    System.out.println(entry.getKey() + " thread time:" + (end - start));
                });
            }

            if(dictDTOPageData.getList().size() >= pageSize) {
                updateAllHashChildren(page + 1, pageSize, thread);
            }
        }
    }

}
