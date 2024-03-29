package org.commonstudy.streams;

import org.commonstudy.inits.Tools;
import org.commonstudy.streams.service.StreamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 铠甲勇士
 * @Description:
 * @Date: create in 2024/3/22 22:28
 */
@RestController
@RequestMapping("/stream")
public class StreamController {

    private final StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
        System.out.println("NODE");
    }

    public String testHandler() {
        Tools.testIsPrepare();
        return "ok";
    }
}
