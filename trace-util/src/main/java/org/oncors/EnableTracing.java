package org.oncors;

import org.oncors.config.TraceConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({TraceConfig.class})
public @interface EnableTracing {
}
