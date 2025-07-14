package org.example.project.web.refresh;

import lombok.Getter;
import lombok.Setter;
import org.example.project.web.vo.resp.TestRespVO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * ConfigurationPropertiesValue
 * 经测试，ConfigurationProperties注解的属性在配置文件中删除之后值不会改变，
 * 而RefreshScope注解的属性在配置文件中删除之后值会变为空
 * </p>
 *
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "test.configuration")
public class ConfigurationPropertiesValue {

    private List<TestRespVO> customTests;

    private String description;
}
