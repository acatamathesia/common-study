package org.commonstudy.longconnect;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.*;

/**
 * @Author: 铠甲勇士
 * @Description:
 * @Date: create in 2024/2/28 17:55
 */
@RestController()
public class LongConnectController {

    private final Map<String, List<DeferredResult<String>>> watchMaps =
            Collections.synchronizedMap(new HashMap<>());
    private final long TIME_OUT = 300000;

    /**
     * 保持连接的通知访问
     * @param hsr
     * @param id
     * @return
     */
    @GetMapping("/watch/{id}")
    public DeferredResult<String> watch(HttpServletRequest hsr, @PathVariable String id) {
        String remoteHost = hsr.getRemoteHost();
        DeferredResult<String> result = new DeferredResult<>(TIME_OUT);
        result.onCompletion(() -> {
            System.out.println(remoteHost + "已完成， 移除监听");
            watchMaps.get(id).remove(result);
        });
        System.out.println(remoteHost + "轮询开始，进入监听");
        List<DeferredResult<String>> dataList = watchMaps.getOrDefault(id, new ArrayList<>());
        dataList.add(result);
        watchMaps.put(id, dataList);
        return result;
    }

    @GetMapping("/pub/{id}")
    public String publish(@PathVariable String id) {
        if (watchMaps.containsKey(id)) {
            watchMaps.get(id).forEach(c -> {
                c.setResult("通知完成");
            });
        }
        return "发布成功";
    }

}
