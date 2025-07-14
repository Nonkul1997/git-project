package org.example.project.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.project.service.UserService;
import org.example.project.service.dto.req.SaveUserReqDTO;
import org.example.project.service.dto.req.UpdateUserReqDTO;
import org.example.project.service.util.BeanUtil;
import org.example.project.web.vo.req.SaveUserReqVO;
import org.example.project.web.vo.req.UpdateUserReqVO;
import org.example.project.web.vo.resp.UserRespVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户控制层")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "新增用户")
    @PostMapping("/saveUser")
    public int saveUser(@RequestBody @Validated SaveUserReqVO reqVO){
        return userService.saveUser(BeanUtil.copy(reqVO, SaveUserReqDTO.class));
    }

    @Operation(summary = "更新用户")
    @PostMapping("/updateUser")
    public int updateUser(@RequestBody @Validated UpdateUserReqVO reqVO){
        return userService.updateUser(BeanUtil.copy(reqVO, UpdateUserReqDTO.class));
    }

    @Operation(summary = "删除用户")
    @PostMapping("/deleteUser")
    public int deleteUser(@RequestParam("id") Integer id) {
        return userService.deleteUser(id);
    }

    @Operation(summary = "查询用户")
    @GetMapping("/getUser")
    public UserRespVO getUser(@RequestParam("id") Integer id) {
        return BeanUtil.copy(userService.getUser(id), UserRespVO.class);
    }

}
