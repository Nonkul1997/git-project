package org.example.project.web;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.project.web.vo.resp.TestRespVO;
import org.example.project.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaochuan
 * @date 2023/10/6 16:36
 * @description TestController
 */
@Tag(name = "Test控制层")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @Operation(summary = "查询Test列表")
    @GetMapping("/queryList")
    public List<TestRespVO> queryList() {
        return BeanUtil.copyToList(testService.queryList(), TestRespVO.class);
    }
}
