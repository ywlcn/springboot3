package com.sample.common.filter.internal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static String generate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        int i = atomicInteger.incrementAndGet();
        String str = "0000000" + i;
        str = str.substring(str.length() - 3);
        return sdf.format(new Date()) + "-" + str;
    }

}
