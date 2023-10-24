package org.example.project.service;

import org.example.project.po.TestPO;
import org.example.project.service.dto.PageRespDTO;
import org.example.project.service.dto.req.TestPageReqDTO;
import org.example.project.service.dto.resp.TestRespDTO;

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
    TestRespDTO getTest(Integer id);
    PageRespDTO<TestRespDTO> listTestByCondition(TestPageReqDTO reqDTO);
}
