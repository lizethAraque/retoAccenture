package com.co.reto.model;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class categoryModelTest {
    CategoryModel categoryTest;

    @Before
    public void init() {
        categoryTest = new CategoryModel();
        categoryTest.setProductname("1");
    }

    @Test
    public void checkIsNotNull() {

        Assert.notNull(categoryTest);
    }

    @Test
    public void checkOneField() {
        assertEquals(categoryTest.getProductname(),"1");
    }
}


