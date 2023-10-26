package org.example.project.service;

import org.example.project.service.dto.PageRespDTO;
import org.example.project.service.dto.req.TestPageReqDTO;
import org.example.project.service.dto.resp.TestRespDTO;

/**
 * <p>
 * ITestService
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/22 8:26
 */
public interface ITestService {
    void saveTest(String description, Integer userId);
    void updateTest(Integer id, String description);
    void deleteTest(Integer id);
    TestRespDTO getTest(Integer id);
    PageRespDTO<TestRespDTO> listTestByCondition(TestPageReqDTO reqDTO);
}
