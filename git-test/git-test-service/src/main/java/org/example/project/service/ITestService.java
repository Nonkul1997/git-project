package org.example.project.service;

import org.example.project.po.TestPO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * ITestService
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/22 8:26
 */
public interface ITestService {
    void saveTest(String description);
    void updateTest(Integer id, String description);
    void deleteTest(Integer id);
    TestPO getTest(Integer id);
    List<TestPO> listTestByCondition(String description, Date createTime, Date updateTime);
}
