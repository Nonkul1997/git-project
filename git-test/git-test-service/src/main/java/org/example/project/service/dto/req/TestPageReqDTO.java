package org.example.project.service.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 * TestPageReqDTO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/25 3:12
 */
@Getter
@Setter
public class TestPageReqDTO extends PageReqDTO {
    private String description;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date updateTimeStart;
    private Date updateTimeEnd;
}
