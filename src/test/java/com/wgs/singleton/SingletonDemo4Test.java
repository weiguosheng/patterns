package com.wgs.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/24 0024.
 */
public class SingletonDemo4Test {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getInstance() throws Exception {
        SingletonDemo4 instance1 = SingletonDemo4.getInstance();
        SingletonDemo4 instance2 = SingletonDemo4.getInstance();
        assertEquals(instance1, instance2);
    }

}