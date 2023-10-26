package org.example.project.web.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 * TestRespVO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/23 9:35
 */
@Getter
@Setter
@Schema(description = "Test基本出参")
public class TestRespVO {
    @Schema(description = "id")
    private Integer id;
    @Schema(description = "描述")
    private String description;
    @Schema(description = "创建时间")
    private Date createTime;
    @Schema(description = "更新时间")
    private Date updateTime;
    @Schema(description = "用户名")
    private String username;
}
