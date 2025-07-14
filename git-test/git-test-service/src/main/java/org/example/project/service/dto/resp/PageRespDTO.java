package org.example.project.service.dto.resp;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 * PageRespDTO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/25 3:12
 */
@Getter
@Setter
public class PageRespDTO<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private Integer pages;
    private List<T> list;
}
