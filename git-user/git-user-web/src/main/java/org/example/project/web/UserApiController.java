package org.example.project.web;

import org.example.project.api.UserApi;
import org.example.project.api.vo.resp.UserApiRespVO;
import org.example.project.service.IUserService;
import org.example.project.service.util.BeanUtil;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * UserApiController
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/26 14:30
 */
@RestController
public class UserApiController implements UserApi {

    private final IUserService userService;

    public UserApiController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserApiRespVO> getUserListByIds(List<Integer> ids) {
        return BeanUtil.copyList(userService.getUserListByIds(ids), UserApiRespVO.class);
    }
}
