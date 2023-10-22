package org.example.project.po;

import lombok.Data;

import java.util.Date;

/**
 * @author xiaochuan
 * @date 2023/10/22 6:46
 * @description Test
 */
@Data
public class Test {
    private Integer id;
    private String description;
    private Date create_time;
    private Date update_time;
}
