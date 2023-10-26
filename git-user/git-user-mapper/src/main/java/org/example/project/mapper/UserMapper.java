package org.example.project.mapper;

import org.example.project.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xiaochuan
 * @since 2023-10-26 12:00
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
