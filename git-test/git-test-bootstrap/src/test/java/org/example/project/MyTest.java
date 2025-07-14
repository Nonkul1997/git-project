package org.example.project;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.project.mapper.TestMapper;
import org.example.project.po.TestPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * MyTest
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/23 1:45
 */
@SpringBootTest
public class MyTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void testInsert() {
        testMapper.insert(new TestPO().setDescription("嘟嘟"));
    }

    @Test
    public void testUpdate() {
        testMapper.updateById(new TestPO().setId(1).setUpdateTime(new Date()));
    }

    @Test
    public void testSelect() {
        System.out.println(testMapper.selectList(null));
    }

    @Test
    public void testLambdaQueryWrapper() {
        testMapper.selectList(new LambdaQueryWrapper<TestPO>()
                .in(TestPO::getId, List.of(1,2,5))
                .like(TestPO::getDescription,"b")
        );
    }

    @Test
    public void testPageHelper(){
        PageHelper.startPage(1,3);
        PageInfo<TestPO> pageInfo = new PageInfo<>(testMapper.selectList(null));
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页的数量：" + pageInfo.getPageSize());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("结果集：" + pageInfo.getList());
    }
}
