package com.wgs.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/24 0024.
 */
public class SingletonDemo5Test {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void singletonOperation() throws Exception {
        System.out.println(SingletonDemo5.INSTANCE == SingletonDemo5.INSTANCE);
    }

}