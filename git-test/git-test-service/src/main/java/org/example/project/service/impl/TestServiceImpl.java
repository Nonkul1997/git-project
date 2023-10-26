package org.example.project.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.project.api.UserApi;
import org.example.project.api.vo.resp.UserApiRespVO;
import org.example.project.mapper.TestMapper;
import org.example.project.po.TestPO;
import org.example.project.service.ITestService;
import org.example.project.service.dto.PageRespDTO;
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

    private final TestMapper testMapper;

    private final UserApi userApi;

    public TestServiceImpl(TestMapper testMapper, UserApi userApi) {
        this.testMapper = testMapper;
        this.userApi = userApi;
    }

    @Override
    public void saveTest(String description, Integer userId) {
        testMapper.insert(new TestPO().setDescription(description).setUserId(userId));
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

        List<TestRespDTO> testList = BeanUtil.copyList(pageInfo.getList(), TestRespDTO.class);
        List<UserApiRespVO> userList = userApi.getUserListByIds(testList.stream().map(TestRespDTO::getUserId).distinct().collect(Collectors.toList()));
        Map<Integer,UserApiRespVO> userMap = userList.stream().collect(Collectors.toMap(UserApiRespVO::getId,
                Function.identity(), (v1,v2) -> v1));
        testList.forEach(t -> {
            UserApiRespVO userApiRespVO = userMap.get(t.getUserId());
            t.setUsername(Objects.isNull(userApiRespVO) ? null : userApiRespVO.getUsername());
        });

        respDTO.setList(testList);
        return respDTO;
    }
}
