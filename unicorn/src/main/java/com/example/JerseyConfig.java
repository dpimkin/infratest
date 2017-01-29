package com.example;

import com.example.rs.v1.DemoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import static org.slf4j.LoggerFactory.getLogger;

@Component
@ApplicationPath("/api")
public final class JerseyConfig extends ResourceConfig {
    private static final Logger LOG = getLogger(JerseyConfig.class);

    @Inject
    public JerseyConfig(DemoResource demo) {
        register(demo);
    }
}
