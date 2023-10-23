package org.example.project.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xiaochuan
 * @date 2023/10/22 6:46
 * @description Test
 */
@TableName("t_test")
@Data
@Accessors(chain = true)
public class Test {
    @TableId
    private Integer id;
    @TableField("description")
    private String description;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
}
