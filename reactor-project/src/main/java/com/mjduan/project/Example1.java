package com.mjduan.project;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

/**
 * Hans 2017-08-17 23:59
 */
public class Example1 {

    @Test
    public void test_flux(){
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);
    }

    @Test
    public void test_mono(){
        Mono<Object> noData = Mono.empty();
        Mono<String> data = Mono.just("foo");
        Flux<Integer> range = Flux.range(5, 3);
    }

    @Test
    public void test_generate(){
        Flux.generate(()->0, (Integer state, SynchronousSink<Object> sink) ->{
            sink.next("3 x "+state+" = "+state*3);
            if (state==10) sink.complete();
            return state+1;
        });
    }

}
