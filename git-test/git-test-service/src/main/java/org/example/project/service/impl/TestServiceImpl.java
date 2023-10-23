package org.example.project.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.project.mapper.TestMapper;
import org.example.project.po.Test;
import org.example.project.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiaochuan
 * @date 2023/10/22 8:30
 * @description TestServiceImpl
 */
@Service
@Slf4j
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> queryList() {
        List<Test> list = testMapper.selectList(null);
        log.info("result:{}, time:{}", list, new Date());
        return list;
    }
}
