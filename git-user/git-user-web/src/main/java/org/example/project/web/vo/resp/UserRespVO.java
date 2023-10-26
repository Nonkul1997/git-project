package org.example.project.web.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 * UserRespVO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/26 12:51
 */
@Getter
@Setter
@Schema(description = "用户基本出参")
public class UserRespVO {
    @Schema(description = "id")
    private Integer id;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "手机号")
    private String telephone;
    @Schema(description = "创建时间")
    private Date createTime;
    @Schema(description = "修改时间")
    private Date updateTime;
}
