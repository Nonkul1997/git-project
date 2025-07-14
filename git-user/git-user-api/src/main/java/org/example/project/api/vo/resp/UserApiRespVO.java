package org.example.project.api.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * UserApiRespVO
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/26 14:29
 */
@Getter
@Setter
@Schema(description = "用户api基本出参")
public class UserApiRespVO {
    @Schema(description = "id")
    private Integer id;
    @Schema(description = "用户名")
    private String username;
}
