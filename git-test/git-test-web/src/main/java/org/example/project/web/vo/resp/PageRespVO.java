package org.example.project.web.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 * PageRespVO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/25 3:12
 */
@Getter
@Setter
@Schema(description = "分页出参")
public class PageRespVO<T> {
    @Schema(description = "当前页")
    private Integer pageNum;
    @Schema(description = "每页数量")
    private Integer pageSize;
    @Schema(description = "总记录数")
    private Integer total;
    @Schema(description = "总页数")
    private Integer pages;
    @Schema(description = "结果集")
    private List<T> list;
}
