package com.example.demo.utils;

import java.util.function.Supplier;

public class Util {
    static Supplier<String> userNotFound(String msg) {
        return () -> {
//            log.error(msg + " not found");
            return msg + " not found";
        };
    }
}
