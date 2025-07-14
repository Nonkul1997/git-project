package org.example.project.web.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveTestReqVO {
    @Schema(description = "描述")
    @NotBlank
    private String description;
    @Schema(description = "用户id")
    @NotNull
    private Integer userId;
}
