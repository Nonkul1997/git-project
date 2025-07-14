package org.example.project.service.dto.req;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * PageReqDTO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/25 3:12
 */
@Getter
@Setter
public class PageReqDTO {
    private Integer pageNum;
    private Integer pageSize;
}
