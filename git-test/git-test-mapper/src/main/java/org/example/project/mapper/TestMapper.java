package org.example.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.project.po.TestPO;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/24 18:41
 */
@Mapper
public interface TestMapper extends BaseMapper<TestPO> {

}
