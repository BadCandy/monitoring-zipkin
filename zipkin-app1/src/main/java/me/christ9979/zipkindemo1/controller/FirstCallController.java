package me.christ9979.zipkindemo1.controller;

import brave.Span;
import brave.Tracer;
import me.christ9979.zipkindemo1.domain.FirstDomain;
import me.christ9979.zipkindemo1.persistance.FirstCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FirstCallController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FirstCallRepository firstCallRepository;

    @Autowired
    private Tracer tracer;

    @PostMapping("/self")
    public String callSelf() {

        FirstDomain firstDomain = new FirstDomain();
        firstDomain.setDescription("first des");

        tracer.currentSpan().tag("a", "b");
        Span newSpan = tracer.nextSpan().name("postgres db");
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {

            firstCallRepository.save(firstDomain);
        } finally {
            newSpan.finish();
        }

        newSpan = tracer.nextSpan().name("망할 슈어엠");
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            firstCallRepository.save(firstDomain);
        } finally {
            newSpan.finish();
        }


        return "OK";
    }

    @PostMapping("/transfer")
    public String callTransfer() {

        FirstDomain firstDomain = new FirstDomain();
        firstDomain.setDescription("first des");

        tracer.currentSpan().tag("a", "b");
        Span newSpan = tracer.nextSpan().name("postgres db");
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            firstCallRepository.save(firstDomain);
        } finally {
            newSpan.finish();
        }

        newSpan = tracer.nextSpan().name("망할 슈어엠");
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            firstCallRepository.save(firstDomain);
        } finally {
            newSpan.finish();
        }
        return restTemplate.postForObject("http://localhost:8082/call", null, String.class);
    }

    @PostMapping("/transfer/exception")
    public String callTransferException() {

        FirstDomain firstDomain = new FirstDomain();
        firstDomain.setDescription("first des");

        tracer.currentSpan().tag("a", "b");
        Span newSpan = tracer.nextSpan().name("postgres db");
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            firstCallRepository.save(firstDomain);
        } finally {
            newSpan.finish();
        }

        newSpan = tracer.nextSpan().name("망할 슈어엠");
        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
            firstCallRepository.save(firstDomain);
        } finally {
            newSpan.finish();
        }
        return restTemplate.postForObject("http://localhost:8082/exception", null, String.class);
    }
}
