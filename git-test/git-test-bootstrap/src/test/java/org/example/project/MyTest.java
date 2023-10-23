package org.example.project;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.project.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @author xiaochuan
 * @date 2023/10/23 1:45
 * @description MyTest
 */
@SpringBootTest
public class MyTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void testInsert() {
        testMapper.insert(new org.example.project.po.Test().setDescription("嘟嘟"));
    }

    @Test
    public void testUpdate() {
        testMapper.updateById(new org.example.project.po.Test().setId(1).setUpdateTime(new Date()));
    }

    @Test
    public void testSelect() {
        System.out.println(testMapper.selectList(null));
    }

    @Test
    public void testLambdaQueryWrapper() {
        LambdaQueryWrapper<org.example.project.po.Test> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(org.example.project.po.Test::getId, org.example.project.po.Test::getDescription)
                .in(org.example.project.po.Test::getId, List.of(1,2,5))
                .like(org.example.project.po.Test::getDescription,"b");
        testMapper.selectList(wrapper);
    }
}
