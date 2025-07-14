package org.example.project.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.project.api.UserApi;
import org.example.project.api.vo.resp.UserApiRespVO;
import org.example.project.mapper.TestMapper;
import org.example.project.po.TestPO;
import org.example.project.service.ITestService;
import org.example.project.service.dto.req.SaveTestReqDTO;
import org.example.project.service.dto.req.UpdateTestReqDTO;
import org.example.project.service.dto.resp.PageRespDTO;
import org.example.project.service.dto.req.TestPageReqDTO;
import org.example.project.service.dto.resp.TestRespDTO;
import org.example.project.service.util.BeanUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements ITestService {

    private final TestMapper testMapper;

    private final UserApi userApi;

    public TestServiceImpl(TestMapper testMapper, UserApi userApi) {
        this.testMapper = testMapper;
        this.userApi = userApi;
    }

    @Override
    public int saveTest(SaveTestReqDTO reqDTO) {
        return testMapper.insert(new TestPO().setDescription(reqDTO.getDescription()).setUserId(reqDTO.getUserId()));
    }

    @Override
    public int updateTest(UpdateTestReqDTO reqDTO) {
        return testMapper.updateById(new TestPO().setId(reqDTO.getId()).setDescription(reqDTO.getDescription()).setUpdateTime(new Date()));
    }

    @Override
    public int deleteTest(Integer id) {
        return testMapper.deleteById(id);
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
                .ge(Objects.nonNull(createTimeStart), TestPO::getCreateTime, createTimeStart)
                .le(Objects.nonNull(createTimeEnd), TestPO::getCreateTime, createTimeEnd)
                .ge(Objects.nonNull(updateTimeStart), TestPO::getUpdateTime, updateTimeStart)
                .le(Objects.nonNull(updateTimeEnd), TestPO::getUpdateTime, updateTimeEnd)
        );
        PageInfo<TestPO> pageInfo = new PageInfo<>(list);
        PageRespDTO<TestRespDTO> respDTO = new PageRespDTO<>();
        respDTO.setPageNum(pageInfo.getPageNum());
        respDTO.setPageSize(pageInfo.getPageSize());
        respDTO.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        respDTO.setPages(pageInfo.getPages());

        List<TestRespDTO> testList = BeanUtil.copyList(pageInfo.getList(), TestRespDTO.class);
        if (CollUtil.isNotEmpty(testList)) {
            List<UserApiRespVO> userList = userApi.getUserListByIds(testList.stream().map(TestRespDTO::getUserId).distinct().collect(Collectors.toList()));
            Map<Integer,UserApiRespVO> userMap = userList.stream()
                    .collect(Collectors.toMap(UserApiRespVO::getId,Function.identity(), (v1,v2) -> v1));
            testList.forEach(t -> {
                UserApiRespVO userApiRespVO = userMap.get(t.getUserId());
                if (null != userApiRespVO) {
                    t.setUsername(userApiRespVO.getUsername());
                }
            });
        }

        respDTO.setList(testList);
        return respDTO;
    }
}
