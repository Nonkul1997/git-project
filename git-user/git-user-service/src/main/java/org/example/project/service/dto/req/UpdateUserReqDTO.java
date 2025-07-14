package org.example.project.service.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserReqDTO {
    private Integer id;
    private String password;
    private String telephone;
}
