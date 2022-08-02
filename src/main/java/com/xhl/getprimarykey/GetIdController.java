//package com.xhl.getprimarykey;
//
//import com.sankuai.inf.leaf.common.Result;
//import com.sankuai.inf.leaf.common.Status;
//import com.sankuai.inf.leaf.service.SegmentService;
//import com.sankuai.inf.leaf.service.SnowflakeService;
//import com.xhl.getprimarykey.exception.NoKeyException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@RestController
//public class GetIdController {
//
//
//    @Autowired
//    private SegmentService segmentService;
//    @Autowired
//    private SnowflakeService snowflakeService;
//
//    @RequestMapping(value = "/api/segment/get/{key}")
//    public String getSegmentId(@PathVariable("key") String key) {
//        return get(key, segmentService.getId(key));
//    }
//
//    @RequestMapping(value = "/api/snowflake/get/{key}")
//    public String getSnowflakeId(@PathVariable("key") String key) {
//        return get(key, snowflakeService.getId(key));
//    }
//
//    private String get(@PathVariable("key") String key, Result id) {
//        Result result;
//        if (key == null || key.isEmpty()) {
//            throw new NoKeyException();
//        }
//        result = id;
//        if (result.getStatus().equals(Status.EXCEPTION)) {
//            return "获取segment id 异常，请检查key是否存在！";
//        }
//        return String.valueOf(result.getId());
//    }
//
//    /**
//     * the output is like this:
//     * {
//     *   "timestamp": "1567733700834(2019-09-06 09:35:00.834)",
//     *   "sequenceId": "3448",
//     *   "workerId": "39"
//     * }
//     */
//    @RequestMapping(value = "/api/snowflake/decodeSnowflakeId")
//    @ResponseBody
//    public Map<String, String> decodeSnowflakeId(@RequestParam("snowflakeId") String snowflakeIdStr) {
//        Map<String, String> map = new HashMap<>();
//        try {
//            long snowflakeId = Long.parseLong(snowflakeIdStr);
//
//            long originTimestamp = (snowflakeId >> 22) + 1288834974657L;
//            Date date = new Date(originTimestamp);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//            map.put("timestamp", String.valueOf(originTimestamp) + "(" + sdf.format(date) + ")");
//
//            long workerId = (snowflakeId >> 12) ^ (snowflakeId >> 22 << 10);
//            map.put("workerId", String.valueOf(workerId));
//
//            long sequence = snowflakeId ^ (snowflakeId >> 12 << 12);
//            map.put("sequenceId", String.valueOf(sequence));
//        } catch (NumberFormatException e) {
//            map.put("errorMsg", "snowflake Id反解析发生异常!");
//        }
//        return map;
//    }
//
//}
