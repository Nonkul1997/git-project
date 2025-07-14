package org.example.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.project.mapper.UserMapper;
import org.example.project.po.UserPO;
import org.example.project.service.UserService;
import org.example.project.service.dto.req.SaveUserReqDTO;
import org.example.project.service.dto.req.UpdateUserReqDTO;
import org.example.project.service.dto.resp.UserRespDTO;
import org.example.project.service.util.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int saveUser(SaveUserReqDTO reqDTO) {
        //当前用户名存在则抛出异常
        if (userMapper.selectCount(new LambdaQueryWrapper<UserPO>().eq(UserPO::getUsername, reqDTO.getUsername())) > 0) {
            throw new RuntimeException("用户名已存在！！！");
        }
        //不存在执行插入操作
        return userMapper.insert(new UserPO().setUsername(reqDTO.getUsername()).setPassword(reqDTO.getPassword()).setTelephone(reqDTO.getTelephone()));
    }

    @Override
    public int updateUser(UpdateUserReqDTO reqDTO) {
        return userMapper.updateById(new UserPO().setId(reqDTO.getId())
                .setPassword(reqDTO.getPassword()).setTelephone(reqDTO.getTelephone()).setUpdateTime(new Date()));
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public UserRespDTO getUser(Integer id) {
        return BeanUtil.copy(userMapper.selectById(id), UserRespDTO.class);
    }

    @Override
    public List<UserRespDTO> getUserListByIds(List<Integer> ids) {
        return BeanUtil.copyList(userMapper.selectBatchIds(ids), UserRespDTO.class);
    }
}
