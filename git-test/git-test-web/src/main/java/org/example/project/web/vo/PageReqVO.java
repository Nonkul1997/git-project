package org.example.project.web.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * PageReqVO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/25 3:12
 */
@Getter
@Setter
@Schema(description = "分页入参")
public class PageReqVO {
    @NotNull(message = "pageNum不能为空")
    @Schema(description = "当前页")
    private Integer pageNum;
    @NotNull(message = "pageSize不能为空")
    @Schema(description = "每页数量")
    private Integer pageSize;
}
