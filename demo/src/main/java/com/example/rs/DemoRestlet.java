package com.example.rs;

import com.example.rs.v1.DemoResource;
import com.example.rs.v1.HeartbeatResource;
import com.example.rs.v1.InfoResource;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public final class DemoRestlet implements DemoResource {

    private final HeartbeatResource heartbeat;
    private final InfoResource info;


    @Inject
    public DemoRestlet(HeartbeatResource heartbeat, InfoResource info) {
        this.heartbeat = heartbeat;
        this.info = info;
    }

    @Override
    public HeartbeatResource heartbeat() {
        return heartbeat;
    }

    @Override
    public InfoResource info() {
        return info;
    }
}
