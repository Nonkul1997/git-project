package org.example.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.project.po.Test;

import java.util.List;

/**
 * @author xiaochuan
 * @date 2023/10/22 6:51
 * @description TestMapper
 */
@Mapper
public interface TestMapper {
    List<Test> queryList();
}
