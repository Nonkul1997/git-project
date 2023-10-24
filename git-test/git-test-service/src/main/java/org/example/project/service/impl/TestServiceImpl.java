package org.example.project.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.project.mapper.TestMapper;
import org.example.project.po.TestPO;
import org.example.project.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * TestServiceImpl
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/22 8:30
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public void saveTest(String description) {
        testMapper.insert(new TestPO().setDescription(description));
    }

    @Override
    public void updateTest(Integer id, String description) {
        testMapper.updateById(new TestPO().setId(id).setDescription(description).setUpdateTime(new Date()));
    }

    @Override
    public void deleteTest(Integer id) {
        testMapper.deleteById(id);
    }

    @Override
    public TestPO getTest(Integer id) {
        return testMapper.selectById(id);
    }

    @Override
    public List<TestPO> listTestByCondition(String description, Date createTime, Date updateTime) {
        return testMapper.selectList(
                new LambdaQueryWrapper<TestPO>()
                        .like(StringUtils.hasLength(description), TestPO::getDescription, description)
                        .ge(Objects.nonNull(createTime), TestPO::getCreateTime, Objects.nonNull(createTime) ?
                                DateUtil.beginOfDay(createTime) : null)
                        .le(Objects.nonNull(updateTime), TestPO::getUpdateTime, Objects.nonNull(updateTime) ?
                                DateUtil.endOfDay(updateTime) : null)
        );
    }
}
