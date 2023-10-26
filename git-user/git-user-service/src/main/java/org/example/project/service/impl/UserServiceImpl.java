package org.example.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.example.project.mapper.UserMapper;
import org.example.project.po.UserPO;
import org.example.project.service.IUserService;
import org.example.project.service.dto.resp.UserRespDTO;
import org.example.project.service.util.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * UserServiceImpl
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/26 12:20
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(String username, String password, String telephone) {
        //当前用户名存在则抛出异常
        if (userMapper.selectCount(new LambdaQueryWrapper<UserPO>()
                .eq(UserPO::getUsername, username)) > 0) {
            throw new RuntimeException("用户名已存在！！！");
        }
        //不存在执行插入操作
        userMapper.insert(new UserPO().setUsername(username).setPassword(password).setTelephone(telephone));
    }

    @Override
    public void updateUser(Integer id, String password, String telephone) {
        LambdaUpdateWrapper<UserPO> wrapper = new LambdaUpdateWrapper<UserPO>().eq(UserPO::getId, id);
        if (StringUtils.hasLength(password)) {
            wrapper.set(UserPO::getPassword, password);
        } else if (StringUtils.hasLength(telephone)) {
            wrapper.set(UserPO::getTelephone, telephone);
        } else {
            throw new RuntimeException("密码和手机号不能同时为空");
        }
        userMapper.update(null, wrapper);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
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
