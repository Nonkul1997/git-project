package org.example.project.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.project.mapper.TestMapper;
import org.example.project.po.TestPO;
import org.example.project.service.ITestService;
import org.example.project.service.dto.PageRespDTO;
import org.example.project.service.dto.req.TestPageReqDTO;
import org.example.project.service.dto.resp.TestRespDTO;
import org.example.project.service.util.BeanUtil;
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
    public TestRespDTO getTest(Integer id) {
        return BeanUtil.copy(testMapper.selectById(id),TestRespDTO.class);
    }

    @Override
    public PageRespDTO<TestRespDTO> listTestByCondition(TestPageReqDTO reqDTO) {
        String description = reqDTO.getDescription();
        Date createTimeStart = reqDTO.getCreateTimeStart();
        Date createTimeEnd = reqDTO.getCreateTimeEnd();
        Date updateTimeStart = reqDTO.getUpdateTimeStart();
        Date updateTimeEnd = reqDTO.getUpdateTimeEnd();
        PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
        List<TestPO> list = testMapper.selectList(new LambdaQueryWrapper<TestPO>()
                .like(StringUtils.hasLength(description), TestPO::getDescription, description)
                .ge(Objects.nonNull(createTimeStart), TestPO::getCreateTime, Objects.nonNull(createTimeStart) ?
                        DateUtil.beginOfDay(createTimeStart) : null)
                .le(Objects.nonNull(createTimeEnd), TestPO::getCreateTime, Objects.nonNull(createTimeEnd) ?
                        DateUtil.endOfDay(createTimeEnd) : null)
                .ge(Objects.nonNull(updateTimeStart), TestPO::getUpdateTime, Objects.nonNull(updateTimeStart) ?
                        DateUtil.beginOfDay(updateTimeStart) : null)
                .le(Objects.nonNull(updateTimeEnd), TestPO::getUpdateTime, Objects.nonNull(updateTimeEnd) ?
                        DateUtil.endOfDay(updateTimeEnd) : null)
        );
        PageInfo<TestPO> pageInfo = new PageInfo<>(list);

        PageRespDTO<TestRespDTO> respDTO = new PageRespDTO<>();
        respDTO.setPageNum(pageInfo.getPageNum());
        respDTO.setPageSize(pageInfo.getPageSize());
        respDTO.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        respDTO.setPages(pageInfo.getPages());
        respDTO.setList(BeanUtil.copyList(pageInfo.getList(), TestRespDTO.class));
        return respDTO;
    }
}
