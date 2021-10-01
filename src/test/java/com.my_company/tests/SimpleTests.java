package com.my_company.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTests {
    @Test
    void trueTest() {
        assertTrue(true);
    }

    @Test
    @Disabled
    void falseTest() {
        assertTrue(false);
    }
 }
