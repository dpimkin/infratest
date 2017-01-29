package com.example.rs.v1;

import org.glassfish.jersey.client.proxy.WebResourceFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.Optional.ofNullable;
import static com.example.rs.v1.DemoClient.*;

public final class DemoClient implements DemoResource {
    private final String url;
    private final Client client;
    private final Lock lock = new ReentrantLock(false);
    private volatile HeartbeatResource heartbeat;
    private volatile InfoResource info;

    public static Builder builder() {
        return new Builder();
    }


    private DemoClient(String url, Client client) {
        this.url = url;
        this.client = client;
    }

    @Override
    public HeartbeatResource heartbeat() {
        if (heartbeat == null) {
            lock.lock();
            try {
                WebTarget target = client.target(url + '/' + HEALTHCHECK_RESOURCE);
                return heartbeat = WebResourceFactory.newResource(HeartbeatResource.class, target);
            } finally {
                lock.unlock();
            }
        }
        return heartbeat;
    }

    @Override
    public InfoResource info() {
        if (info == null) {
            lock.lock();
            try {
                WebTarget target = client.target(url + '/' + INFO_RESOURCE);
                return info = WebResourceFactory.newResource(InfoResource.class, target);
            } finally {
                lock.unlock();
            }
        }
        return info;
    }

    public static final class Builder  {
        private String url;
        private Client client;

        private Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public DemoClient build() {
            return new DemoClient(url, ofNullable(client).orElseGet(ClientBuilder::newClient));
        }

    }



}
