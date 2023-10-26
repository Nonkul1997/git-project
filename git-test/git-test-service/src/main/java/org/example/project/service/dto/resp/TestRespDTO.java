package org.example.project.service.dto.resp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 * TestRespDTO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/25 3:12
 */
@Getter
@Setter
public class TestRespDTO {
    private Integer id;
    private String description;
    private Date createTime;
    private Date updateTime;
    private Integer userId;
    private String username;
}
