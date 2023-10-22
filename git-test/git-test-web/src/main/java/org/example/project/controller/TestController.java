package org.example.project.controller;

import org.example.project.mapper.TestMapper;
import org.example.project.po.Test;
import org.example.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaochuan
 * @date 2023/10/6 16:36
 * @description TestController
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/queryList")
    public List<Test> queryList() {
        return testService.queryList();
    }
}
