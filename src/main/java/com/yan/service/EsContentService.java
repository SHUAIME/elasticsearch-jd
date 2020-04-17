package com.yan.service;

import com.yan.entity.ESContent;

import java.util.List;
import java.util.Map;

/**
 * @Author: yan
 * @Date: 2020/4/17 19:29
 * @Description: com.yan.service
 * @version: 1.0
 */
public interface EsContentService {

    public Boolean parseContent(String keywords) throws Exception;

    public List<Map<String,Object>> searchRequest(String keywords, Integer pageNo, Integer pageSize) throws Exception;
}
