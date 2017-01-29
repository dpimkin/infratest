package com.example.rs.v1;

import javax.ws.rs.Path;

@Path("v1")
public interface DemoResource {
    String HEALTHCHECK_RESOURCE = "health-check";
    String INFO_RESOURCE = "info";

    @Path(HEALTHCHECK_RESOURCE)
    HeartbeatResource heartbeat();

    @Path(INFO_RESOURCE)
    InfoResource info();

}
