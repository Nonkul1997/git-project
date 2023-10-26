package org.example.project.service.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import java.util.List;

/**
 * <p>
 * BeanUtil
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/25 5:26
 */
public class BeanUtil {

    public static <T> T copy(Object object, Class<T> clazz){
        return JSON.parseObject(JSON.toJSONString(object), clazz);
    }

    public static <T> T copy(Object object, TypeReference<T> typeReference){
        return JSON.parseObject(JSON.toJSONString(object), typeReference);
    }

    public static <T> List<T> copyList(Object object, Class<T> clazz){
        return JSON.parseArray(JSON.toJSONString(object), clazz);
    }
}
