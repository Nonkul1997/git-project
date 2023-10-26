package org.example.project.web;

import com.alibaba.fastjson2.TypeReference;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.project.service.dto.req.TestPageReqDTO;
import org.example.project.service.util.BeanUtil;
import org.example.project.web.vo.PageRespVO;
import org.example.project.web.vo.req.TestPageReqVO;
import org.example.project.web.vo.resp.TestRespVO;
import org.example.project.service.ITestService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    private final ITestService testService;

    public TestController(ITestService testService) {
        this.testService = testService;
    }

    @Operation(summary = "新增Test")
    @Parameters({
            @Parameter(name = "description", description = "描述"),
            @Parameter(name = "userId", description = "用户id")
    })
    @PostMapping("/saveTest")
    public void saveTest(@RequestParam("description") String description,
                         @RequestParam("userId") Integer userId) {
        testService.saveTest(description, userId);
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
    @PostMapping("/getTest")
    public TestRespVO getTest(@RequestParam("id") Integer id) {
        return BeanUtil.copy(testService.getTest(id), TestRespVO.class);
    }

    @Operation(summary = "根据条件查询Test列表")
    @PostMapping("/listTestByCondition")
    public PageRespVO<TestRespVO> listTestByCondition(@Validated @RequestBody TestPageReqVO reqVO) {
        return BeanUtil.copy(testService.listTestByCondition(BeanUtil.copy(reqVO, TestPageReqDTO.class)),
                new TypeReference<>() {
        });
    }
}
