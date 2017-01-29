package com.example.rs;

import com.example.rs.v1.InfoResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class InfoRestlet implements InfoResource {


    @Override
    public String get() {
        return "info";
    }
}
