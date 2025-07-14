package org.example.project.service.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveUserReqDTO {
    private String username;
    private String password;
    private String telephone;
}
