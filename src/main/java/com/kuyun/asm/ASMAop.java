package com.kuyun.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

/**
 * Created by xuwuqiang on 2019/2/20.
 */
public class ASMAop {

    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader("com.kuyun.asm.Operation");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cr.accept(new LogClassVisitor(cw), ClassReader.SKIP_DEBUG);

        Class<?> clazz = new MyClassLoader().defineClassForName("com.kuyun.asm.Operation", cw.toByteArray());

        clazz.getMethods()[0].invoke(clazz.newInstance());
    }

}
