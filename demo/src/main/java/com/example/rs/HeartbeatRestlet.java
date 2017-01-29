package com.example.rs;

import com.example.rs.v1.HeartbeatResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HeartbeatRestlet implements HeartbeatResource {

    @Override
    public String get() {
        return "ping";
    }
}
