package org.example.project.service;

import org.example.project.service.dto.req.SaveTestReqDTO;
import org.example.project.service.dto.req.UpdateTestReqDTO;
import org.example.project.service.dto.resp.PageRespDTO;
import org.example.project.service.dto.req.TestPageReqDTO;
import org.example.project.service.dto.resp.TestRespDTO;

public interface ITestService {
    int saveTest(SaveTestReqDTO reqDTO);
    int updateTest(UpdateTestReqDTO reqDTO);
    int deleteTest(Integer id);
    TestRespDTO getTest(Integer id);
    PageRespDTO<TestRespDTO> listTestByCondition(TestPageReqDTO reqDTO);
}
