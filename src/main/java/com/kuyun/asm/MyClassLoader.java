package com.kuyun.asm;

/**
 * Created by xuwuqiang on 2019/2/20.
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }
}
