package org.example.project.web.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @author xiaochuan
 * @date 2023/10/23 9:35
 * @description TestQueryListRespVO
 */
@Data
@Schema(description = "查询Test列表出参")
public class TestRespVO {
    @Schema(description = "id")
    private Integer id;
    @Schema(description = "描述")
    private String description;
    @Schema(description = "创建时间")
    private Date createTime;
    @Schema(description = "更新时间")
    private Date updateTime;
}
