package org.example.project.web;

import org.example.project.api.UserApi;
import org.example.project.api.vo.resp.UserApiRespVO;
import org.example.project.service.UserService;
import org.example.project.service.util.BeanUtil;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserApiController implements UserApi {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserApiRespVO> getUserListByIds(List<Integer> ids) {
        return BeanUtil.copyList(userService.getUserListByIds(ids), UserApiRespVO.class);
    }
}
