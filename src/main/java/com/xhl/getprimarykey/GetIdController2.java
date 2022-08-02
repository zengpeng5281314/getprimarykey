package com.xhl.getprimarykey;

import com.alibaba.fastjson.JSONObject;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.service.SegmentService;
import com.sankuai.inf.leaf.service.SnowflakeService;
import com.xhl.feignserviceapi.feignapi.PrimaryKeyService;
import com.xhl.feignserviceapi.feigndto.Result;
import com.xhl.feignserviceapi.feigndto.ResultUtil;
import com.xhl.getprimarykey.exception.NoKeyException;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;


@Slf4j
@RestController
public class GetIdController2 implements PrimaryKeyService {

    @Autowired
    private SegmentService segmentService;
    @Autowired
    private SnowflakeService snowflakeService;

    @Override
    public Result getSegmentPrimaryKey(String key) {
        String primaryKey =  get(key, segmentService.getId(key));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("primaryKey",primaryKey);
        return ResultUtil.success(jsonObject);
    }

    @Override
    public Result getSegmentPrimaryKeys(String key, int size) {
        List<String> list = new ArrayList<>(size);
        for (int i =0;i<size;i++){
            list.add(get(key, segmentService.getId(key)));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("primaryKeyList",list);
        return ResultUtil.success(jsonObject);
    }

    @Override
    public Result getSnowflakePrimaryKey(String key) {
        String primaryKey =  get(key, snowflakeService.getId(key));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("primaryKey",primaryKey);
        return ResultUtil.success(jsonObject);
    }

    @Override
    public Result getSnowflakePrimaryKeys(String key, int size) {
        List<String> list = new ArrayList<>(size);
        for (int i =0;i<size;i++){
            list.add(get(key, snowflakeService.getId(key)));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("primaryKeyList",list);
        return ResultUtil.success(jsonObject);
    }



    @Override
    public Result decodeSnowflakeId(String snowflakeIdStr) {
        return getResult(snowflakeIdStr);
    }

    static Result getResult(String snowflakeIdStr) {
        JSONObject jsonObject = new JSONObject();
        try {
            long snowflakeId = Long.parseLong(snowflakeIdStr);

            long originTimestamp = (snowflakeId >> 22) + 1288834974657L;
            Date date = new Date(originTimestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            jsonObject.put("timestamp", String.valueOf(originTimestamp) + "(" + sdf.format(date) + ")");

            long workerId = (snowflakeId >> 12) ^ (snowflakeId >> 22 << 10);
            jsonObject.put("workerId", String.valueOf(workerId));

            long sequence = snowflakeId ^ (snowflakeId >> 12 << 12);
            jsonObject.put("sequenceId", String.valueOf(sequence));
        } catch (NumberFormatException e) {
            return ResultUtil.error("-1","snowflake Id反解析发生异常!");
        }
        return ResultUtil.success(jsonObject);
    }

    private String get(@PathVariable("key") String key, com.sankuai.inf.leaf.common.Result id) {
        com.sankuai.inf.leaf.common.Result result;
        if (key == null || key.isEmpty()) {
            throw new NoKeyException();
        }
        result = id;
        if (result.getStatus().equals(Status.EXCEPTION)) {
            return "获取segment id 异常，请检查key是否存在！";
        }
        return String.valueOf(result.getId());
    }

}
