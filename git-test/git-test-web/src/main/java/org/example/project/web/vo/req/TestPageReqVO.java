package org.example.project.web.vo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TestPageReqVO extends PageReqVO {
    @Schema(description = "描述")
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "起始创建时间")
    private Date createTimeStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "结束创建时间")
    private Date createTimeEnd;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "起始更新时间")
    private Date updateTimeStart;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "结束更新时间")
    private Date updateTimeEnd;
}
