package com.wgs.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.*;

/**
 * 反射和反序列化破解单例模式
 */
public class SingletonDemo6Test {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getInstance() throws Exception {
        SingletonDemo6 s1 = SingletonDemo6.getInstance();
        SingletonDemo6 s2 = SingletonDemo6.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        //通过反射的方式直接调用私有构造器
//		Class<SingletonDemo6> clazz = (Class<SingletonDemo6>) Class.forName("com.bjsxt.singleton.SingletonDemo6");
//		Constructor<SingletonDemo6> c = clazz.getDeclaredConstructor(null);
//		c.setAccessible(true);
//		SingletonDemo6  s3 = c.newInstance();
//		SingletonDemo6  s4 = c.newInstance();
//		System.out.println(s3);
//		System.out.println(s4);

        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingletonDemo6 s3 = (SingletonDemo6) ois.readObject();
        System.out.println(s3);
    }

}