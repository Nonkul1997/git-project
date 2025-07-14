package org.example.project.web.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageReqVO {
    @NotNull(message = "pageNum不能为空")
    @Schema(description = "当前页")
    private Integer pageNum;
    @NotNull(message = "pageSize不能为空")
    @Schema(description = "每页数量")
    private Integer pageSize;
}
