package org.example.project.web;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.project.web.vo.resp.TestRespVO;
import org.example.project.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * TestController
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/6 16:36
 */
@Tag(name = "Test控制层")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @Operation(summary = "新增Test")
    @Parameters({
            @Parameter(name = "description", description = "描述")
    })
    @PostMapping("/saveTest")
    public void saveTest(@RequestParam("description") String description) {
        testService.saveTest(description);
    }

    @Operation(summary = "更新Test")
    @Parameters({
            @Parameter(name = "id", description = "id"),
            @Parameter(name = "description", description = "描述")
    })
    @PostMapping("/updateTest")
    public void updateTest(@RequestParam("id") Integer id,
                           @RequestParam("description") String description) {
        testService.updateTest(id,description);
    }

    @Operation(summary = "删除Test")
    @Parameters({
            @Parameter(name = "id", description = "id")
    })
    @PostMapping("/deleteTest")
    public void deleteTest(@RequestParam("id") Integer id) {
        testService.deleteTest(id);
    }

    @Operation(summary = "查询Test")
    @Parameters({
            @Parameter(name = "id", description = "id")
    })
    @GetMapping("/getTest")
    public TestRespVO getTest(@RequestParam("id") Integer id) {
        return BeanUtil.copyProperties(testService.getTest(id), TestRespVO.class);
    }

    @Operation(summary = "根据条件查询Test列表")
    @Parameters({
            @Parameter(name = "description", description = "描述"),
            @Parameter(name = "createTime", description = "创建时间"),
            @Parameter(name = "updateTime", description = "更新时间")
    })
    @GetMapping("/listTestByCondition")
    public List<TestRespVO> listTestByCondition(@RequestParam(value = "description", required = false) String description,
                                                @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value =
                                                        "createTime", required = false) Date createTime,
                                                @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(value =
                                                        "updateTime", required = false) Date updateTime) {
        return BeanUtil.copyToList(testService.listTestByCondition(description, createTime, updateTime), TestRespVO.class);
    }
}
