package com.example.rs.v1;

import javax.ws.rs.GET;

public interface HeartbeatResource {

    @GET
    String get();
}
