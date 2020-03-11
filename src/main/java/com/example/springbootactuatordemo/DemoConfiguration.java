package com.example.springbootactuatordemo;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DemoConfiguration {
    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new HttpTraceRepository() {
            private List<HttpTrace> traceList = new ArrayList<>();

            @Override
            public List<HttpTrace> findAll() {
                return traceList;
            }

            @Override
            public void add(HttpTrace trace) {
                traceList.add(trace);
            }
        };
    }

}
