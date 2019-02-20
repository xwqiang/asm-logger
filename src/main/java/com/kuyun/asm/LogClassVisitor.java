package com.kuyun.asm;

import static org.objectweb.asm.Opcodes.ASM5;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;


/**
 * Created by xuwuqiang on 2019/2/20.
 */
public class LogClassVisitor extends ClassVisitor {

    public LogClassVisitor(ClassVisitor cv) {
        super(ASM5, cv);
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if ("oper".equals(name)) {
            return new LogMethodVisitor(super.visitMethod(access, name, desc, signature, exceptions));
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
