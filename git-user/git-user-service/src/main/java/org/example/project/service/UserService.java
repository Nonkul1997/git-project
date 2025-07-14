package org.example.project.service;

import org.example.project.po.UserPO;
import org.example.project.service.dto.req.SaveUserReqDTO;
import org.example.project.service.dto.req.UpdateUserReqDTO;
import org.example.project.service.dto.resp.UserRespDTO;

import java.util.List;

public interface UserService {
    int saveUser(SaveUserReqDTO reqDTO);
    int updateUser(UpdateUserReqDTO reqDTO);
    int deleteUser(Integer id);
    UserRespDTO getUser(Integer id);
    List<UserRespDTO> getUserListByIds(List<Integer> ids);
}
