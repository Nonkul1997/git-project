package org.example.project.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.project.service.IUserService;
import org.example.project.service.util.BeanUtil;
import org.example.project.web.vo.resp.UserRespVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * UserController
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/26 12:26
 */
@Tag(name = "用户控制层")
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "新增用户")
    @Parameters({
            @Parameter(name = "username", description = "用户名"),
            @Parameter(name = "password", description = "密码"),
            @Parameter(name = "telephone", description = "手机号")
    })
    @PostMapping("/saveUser")
    public void saveUser(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam(value = "telephone", required = false) String telephone){
        userService.saveUser(username, password, telephone);
    }

    @Operation(summary = "更新用户")
    @Parameters({
            @Parameter(name = "id", description = "id"),
            @Parameter(name = "password", description = "密码"),
            @Parameter(name = "telephone", description = "手机号")
    })
    @PostMapping("/updateUser")
    public void updateUser(@RequestParam("id") Integer id,
                           @RequestParam(value = "password", required = false) String password,
                           @RequestParam(value = "telephone", required = false) String telephone){
        userService.updateUser(id, password, telephone);
    }

    @Operation(summary = "删除用户")
    @Parameters({
            @Parameter(name = "id", description = "id")
    })
    @PostMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
    }

    @Operation(summary = "查询用户")
    @Parameters({
            @Parameter(name = "id", description = "id")
    })
    @PostMapping("/getUser")
    public UserRespVO getUser(@RequestParam("id") Integer id) {
        return BeanUtil.copy(userService.getUser(id), UserRespVO.class);
    }

}
