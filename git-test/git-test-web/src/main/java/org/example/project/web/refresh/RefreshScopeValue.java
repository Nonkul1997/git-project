package org.example.project.web.refresh;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * <p>
 * TestRefreshValue
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/27 10:57
 */
@Getter
@Setter
@Component
@RefreshScope
public class RefreshScopeValue {

    @Value("${test.refresh.description:}")
    private String description;
}
