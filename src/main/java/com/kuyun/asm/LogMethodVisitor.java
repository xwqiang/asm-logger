package com.kuyun.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by xuwuqiang on 2019/2/20.
 */
public class LogMethodVisitor extends MethodVisitor {

    public LogMethodVisitor(MethodVisitor mv) {
        super(Opcodes.ASM5, mv);
    }

    public void visitCode() {
        /**
         * 方法执行之前植入代码
         */
        super.visitMethodInsn(Opcodes.INVOKESTATIC, "com/kuyun/asm/Log", "startLog", "()V", false);
        super.visitCode();
    }

    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN) {
            /**
             * 方法return之前，植入代码
             */
            super.visitMethodInsn(Opcodes.INVOKESTATIC, "com/kuyun/asm/Log", "endLog", "()V", false);
        }
        super.visitInsn(opcode);
    }
}
