package com.vsofo.cspcommon.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.type.CollectionType;

/**
 * json 转换辅助类
 */
public class JsonConvert {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 全局 objectMapper 配置
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        //
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        //
        objectMapper.registerModule(simpleModule);
    }

    /**
     * json -> obj
     */
    public static <T> T jsonToObject(String src, Class<T> clazz) throws JsonProcessingException, JsonMappingException {
        if (src == null || src.equals("") || clazz == null) {
            return null;
        }
        return clazz.equals(String.class) ? (T) src : objectMapper.readValue(src, clazz);
    }

    /**
     * json -> ArrayList<T>
     */
    public static <T> List<T> jsonToArratList(String src, Class<T> itemT)
            throws JsonProcessingException, JsonMappingException {
        if (src == null || src.equals("") || itemT == null) {
            return null;
        }
        ObjectMapper localobjectMapper = new ObjectMapper();
        localobjectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        localobjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        localobjectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        //
        SimpleModule localsimpleModule = new SimpleModule();
        localsimpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        localsimpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        //
        localobjectMapper.registerModule(localsimpleModule);
        CollectionType listType = localobjectMapper.getTypeFactory().constructCollectionType(ArrayList.class, itemT);
        return localobjectMapper.readValue(src, listType);
    }

    /*
     * obj -> json
     */
    public static <T> String objectToJson(T obj) throws JsonProcessingException {
        if (obj == null) {
            return null;
        }
        return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
    }

}
