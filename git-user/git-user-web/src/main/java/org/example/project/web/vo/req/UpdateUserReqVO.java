package org.example.project.web.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserReqVO {
    @Schema(description = "id")
    @NotNull
    private Integer id;
    @Schema(description = "密码")
    @NotBlank
    private String password;
    @Schema(description = "手机号")
    private String telephone;


}
