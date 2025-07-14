package org.example.project.service.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TestRespDTO {
    private Integer id;
    private String description;
    private Date createTime;
    private Date updateTime;
    private Integer userId;
    private String username;
}
