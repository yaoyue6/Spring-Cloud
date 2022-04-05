package com.yaoyue.cloud;

import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 * @author 王东旭
 * @createTime 2022/4/4 16:59
 * @description
 */
public class TestCurrentTime {

    public static void main(String[] args) {
        ZonedDateTime zone = ZonedDateTime.now();
        System.out.println(zone.toString());
    }
}
