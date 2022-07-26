package com.wuk.amsplugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * @author: bincao2
 * @date: 2022/1/26 16:51
 * @desc: 描述
 * @updateUser: 更新者
 * @updateDate: 2022/1/26 16:51
 * @updateRemark: 更新说明
 */
class TestClassVisitor(classVisitor: ClassVisitor) : ClassVisitor(Opcodes.ASM7, classVisitor) {

    private val TAG = "PluginAmsTag: "

    private var className: String? = null


    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        className = name


    }

    override fun visitMethod(
        methodAccess: Int,
        methodName: String?,
        methodDescriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val methodVisitor = super.visitMethod(methodAccess, methodName, methodDescriptor, signature, exceptions)

        println("$TAG method = $methodName")
        println("$TAG className = $className")

        if (className == "com/wuk/amsdemo/Test" && methodName == "test") {
            return CustomizeMethodVisitor(api, methodVisitor, className, methodAccess, methodName, methodDescriptor)
        }

        return methodVisitor
    }
}