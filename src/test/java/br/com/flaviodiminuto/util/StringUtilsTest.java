package br.com.flaviodiminuto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testCheckNull() {
        Long l = 0L;
        Integer i = 0;
        Double d = 14.5;
        Float f = 1.6f;
        Boolean b = false;

        Assertions.assertEquals("0",StringUtils.checkNull(l));
        Assertions.assertEquals("0",StringUtils.checkNull(i));
        Assertions.assertEquals("14.5",StringUtils.checkNull(d));
        Assertions.assertEquals("1.6",StringUtils.checkNull(f));
        Assertions.assertEquals("false",StringUtils.checkNull(b));

    }

    @Test
    void testCheckNull1() {

        Assertions.assertEquals("0",StringUtils.checkNull(0));
    }

    @Test
    void testCheckNull2() {
        Assertions.assertEquals("0",StringUtils.checkNull(0L));
    }

    @Test
    void testCheckNull3() {
        Assertions.assertEquals("14.5",StringUtils.checkNull(14.5));
    }

    @Test
    void testCheckNull4() {
        Assertions.assertEquals("1.6",StringUtils.checkNull(1.6f));
    }

    @Test
    void testCheckNull5() {
        Assertions.assertEquals("false",StringUtils.checkNull(false));
    }
}