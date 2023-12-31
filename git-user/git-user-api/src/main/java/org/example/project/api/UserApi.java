package org.example.project.api;

import org.example.project.api.vo.resp.UserApiRespVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * UserApi
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/26 14:12
 */
@FeignClient(name = "git-user", path = "/git-user")
public interface UserApi {
    @GetMapping("/user/getUserListByIds")
    List<UserApiRespVO> getUserListByIds(@RequestParam("ids") List<Integer> ids);
}
