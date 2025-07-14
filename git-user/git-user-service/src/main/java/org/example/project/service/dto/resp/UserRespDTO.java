package org.example.project.service.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserRespDTO {
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private Date createTime;
    private Date updateTime;
}
