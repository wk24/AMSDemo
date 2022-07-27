package com.wuk.amsplugin

import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter

/**
 * @author: bincao2
 * @date: 2022/1/27 16:43
 * @desc: 方法前后各加一个打印
 * @updateUser: 更新者
 * @updateDate: 2022/1/27 16:43
 * @updateRemark: 更新说明
 */
class CustomizeMethodVisitor(
    api: Int,
    methodVisitor: MethodVisitor,
    className: String?,
    access: Int,
    name: String?,
    descriptor: String?
) : AdviceAdapter(api, methodVisitor, access, name, descriptor) {

    private var mClassName: String? = className

    private val TAG = "${this.javaClass.simpleName}: "


    /**
     * 在方法调用之前插入
     */
//    override fun onMethodEnter() {
//        println("$TAG onMethodEnter")
//        super.onMethodEnter()
//        //this-方法接收的参数－方法内定义的局部变量
//        //下面代码不需要自己写 有工具可以生成
//        mv.visitLdcInsn("Test.class ")
//        mv.visitLdcInsn("aaabbb start: " +name)
//        mv.visitMethodInsn(
//            INVOKESTATIC, "android/util/Log", "d",
//            "(Ljava/lang/String;Ljava/lang/String;)I", false)
//        mv.visitInsn(POP)
//    }
    /**
     * 在方法调用之后插入，注意在 super.onMethodExit(opcode) 之前
     */
//    override fun onMethodExit(opcode: Int) {
//        mv.visitLdcInsn("Test.class ")
//        mv.visitLdcInsn("aaabbb end")
//        mv.visitMethodInsn(
//            INVOKESTATIC, "android/util/Log", "d",
//            "(Ljava/lang/String;Ljava/lang/String;)I", false)
//        mv.visitInsn(POP)
//        println("$TAG onMethodExit")
//        super.onMethodExit(opcode)
//    }

//    override fun visitInsn(opcode: Int) {
//        if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN)
//            || opcode == Opcodes.ATHROW) {
//            mv.visitVarInsn(Opcodes.ALOAD, 0);
//            mv.visitTypeInsn(Opcodes.NEW, "com/wuk/amsdemo/DoubleTapCheck");
//            mv.visitInsn(Opcodes.DUP);
//            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "com/wuk/amsdemo/DoubleTapCheck",
//                "<init>", "()V", false);
//            mv.visitFieldInsn(Opcodes.PUTFIELD, mClassName, "doubleTap",
//                "Lcom/wuk/amsdemo/DoubleTapCheck;");
//        }
//        super.visitInsn(opcode);
//    }

    override fun visitCode() {
        if (name.equals("onClick")){
//            mv.visitVarInsn(Opcodes.ALOAD, 0);
//
//            mv.visitFieldInsn(Opcodes.GETFIELD, mClassName, "doubleTap",
//                "Lcom/wuk/amsdemo/DoubleTapCheck;");
//            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "Lcom/wuk/amsdemo/DoubleTapCheck",
//                "isNotDoubleTap", "()Z", false);
//            val label = Label();
//            mv.visitJumpInsn(Opcodes.IFNE, label);
//            mv.visitInsn(Opcodes.RETURN);
//            mv.visitLabel(label);

            mv.visitVarInsn(ALOAD, 0)
            mv.visitMethodInsn(
                INVOKESTATIC, "com/wuk/amsdemo/NoDoubleClickUtils", "isDoubleClick",
                "()Z", false
            )
            val label = Label()
            mv.visitJumpInsn(IFNE, label)
            mv.visitInsn(RETURN)
            mv.visitLabel(label)
        }

        super.visitCode();
    }
}