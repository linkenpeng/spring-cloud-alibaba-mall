package com.intecsec.mall.dict.test;

import com.intecsec.mall.common.response.PageData;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.dict.dto.DictDTO;
import com.intecsec.mall.dict.mapper.DictMapper;
import com.intecsec.mall.dict.service.DictService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
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
        int pageSize = 1000;
        int page = 1;
        int thread = 5;
        // 10 个 thread time : 664
        // 1 个 thread time : 730
        // 5 个 thread time : 547
        long start = System.currentTimeMillis();
        updateAllHashChildren(page, pageSize, thread);
        long end = System.currentTimeMillis();
        System.out.println("total time:" + (end - start));
    }

    private void updateAllHashChildren(int page, int pageSize, int thread) {
        System.out.println("page:" + page + ", pageSize:" + pageSize);
        long start = System.currentTimeMillis();

        PageData<DictDTO> dictDTOPageData = dictService.pageList(page, pageSize, null);
        if (dictDTOPageData != null && dictDTOPageData.getList().size() > 0) {

            Map<Long, List<DictDTO>> group = new HashMap<>();
            if(thread > 0) {
                group = dictDTOPageData.getList().stream()
                        .collect(Collectors.groupingBy(d -> d.getId() % thread));
            }
            ExecutorService executorService = new ThreadPoolExecutor(thread, thread, 1000L,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(pageSize));

            for(Map.Entry<Long, List<DictDTO>> entry : group.entrySet()) {
                executorService.execute(() -> {
                    for (DictDTO dictDTO : entry.getValue()) {
                        dictService.updateHasChildren(dictDTO.getId());
                    }
                });
            }

            executorService.shutdown();

            if(dictDTOPageData.getList().size() >= pageSize) {
                long end = System.currentTimeMillis();
                System.out.println(thread +" 个 thread time : " + (end - start));
                updateAllHashChildren(page + 1, pageSize, thread);
            }
        }
    }

}
