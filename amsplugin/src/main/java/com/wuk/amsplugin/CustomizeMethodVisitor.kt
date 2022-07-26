package com.wuk.amsplugin

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
    override fun onMethodEnter() {
        println("$TAG onMethodEnter")
        super.onMethodEnter()
        //this-方法接收的参数－方法内定义的局部变量
        //下面代码不需要自己写 有工具可以生成
        mv.visitLdcInsn("Test.class ")
        mv.visitLdcInsn("aaabbb start")
        mv.visitMethodInsn(
            INVOKESTATIC, "android/util/Log", "d",
            "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)
    }
    /**
     * 在方法调用之后插入，注意在 super.onMethodExit(opcode) 之前
     */
    override fun onMethodExit(opcode: Int) {
        mv.visitLdcInsn("Test.class ")
        mv.visitLdcInsn("aaabbb end")
        mv.visitMethodInsn(
            INVOKESTATIC, "android/util/Log", "d",
            "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)
        println("$TAG onMethodExit")
        super.onMethodExit(opcode)
    }
}