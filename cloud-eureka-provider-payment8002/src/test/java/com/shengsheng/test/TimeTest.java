package com.shengsheng.test;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * description:
 *
 * @author shengshenglalala
 * @date 2021/6/4 15:12
 */
public class TimeTest {
    @Test
    public void testTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
