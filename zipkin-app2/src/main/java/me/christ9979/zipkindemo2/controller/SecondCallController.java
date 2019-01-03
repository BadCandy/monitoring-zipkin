//package me.christ9979.zipkindemo2.controller;
//
//import brave.Span;
//import brave.Tracer;
//import me.christ9979.zipkindemo2.domain.SecondDomain;
//import me.christ9979.zipkindemo2.persistance.SecondCallRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class SecondCallController {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private SecondCallRepository secondCallRepository;
//
//    @Autowired
//    private Tracer tracer;
//
//    @PostMapping("/call")
//    public String call() {
//
//        SecondDomain secondDomain = new SecondDomain();
//        secondDomain.setDescription("first des");
//
//        tracer.currentSpan().tag("a", "b");
//        Span newSpan = tracer.nextSpan().name("postgres db");
//        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
//            secondCallRepository.save(secondDomain);
//        } finally {
//            newSpan.finish();
//        }
//
//        return "OK";
//    }
//
//    @PostMapping("/exception")
//    public String callException() {
//
//        SecondDomain secondDomain = new SecondDomain();
//        secondDomain.setDescription("first des");
//
//        tracer.currentSpan().tag("a", "b");
//        Span newSpan = tracer.nextSpan().name("postgres db");
//        try (Tracer.SpanInScope ws = tracer.withSpanInScope(newSpan.start())) {
//            secondCallRepository.save(secondDomain);
//        } finally {
//            newSpan.finish();
//        }
//
//        throw new RuntimeException();
//    }
//}


package me.christ9979.zipkindemo2.controller;

import me.christ9979.zipkindemo2.domain.SecondDomain;
import me.christ9979.zipkindemo2.persistance.SecondCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondCallController {

    @Autowired
    private SecondCallRepository secondCallRepository;

    @PostMapping("/call")
    public String call() {

        SecondDomain secondDomain = new SecondDomain();
        secondDomain.setDescription("first des");
        secondCallRepository.save(secondDomain);

        return "OK";
    }

    @PostMapping("/exception")
    public String callException() {

        SecondDomain secondDomain = new SecondDomain();
        secondDomain.setDescription("first des");

        secondCallRepository.save(secondDomain);

        throw new RuntimeException();
    }
}
