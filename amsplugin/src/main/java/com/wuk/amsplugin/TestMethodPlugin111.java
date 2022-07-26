package com.wuk.amsplugin;

import com.android.build.api.transform.DirectoryInput;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform;
import com.android.build.api.transform.TransformException;
import com.android.build.api.transform.TransformInput;
import com.android.build.api.transform.TransformInvocation;
import com.android.build.gradle.internal.pipeline.TransformManager;
import com.android.utils.FileUtils;
import com.google.common.collect.FluentIterable;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

/**
 * @author wuk
 * @date 2022/7/25
 */
//public class TestMethodPlugin111 extends Transform {
//    @Override
//    public String getName() {
//        return "TestMethodPlugin";
//    }
//
//    @Override
//    public Set<QualifiedContent.ContentType> getInputTypes() {
//        return TransformManager.CONTENT_CLASS;
//    }
//
//    @Override
//    public Set<? super QualifiedContent.Scope> getScopes() {
//        return TransformManager.SCOPE_FULL_PROJECT;
//    }
//
//    @Override
//    public boolean isIncremental() {
//        return false;
//    }
//
//    @Override
//    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
////        super.transform(transformInvocation);
//        Collection<TransformInput> inputs = transformInvocation.getInputs();
//
//        for (TransformInput transformInput: inputs) {
//            Collection<DirectoryInput> directoryInputs = transformInput.getDirectoryInputs();
//
//            for (DirectoryInput directoryInput: directoryInputs) {
//                if (directoryInput.getFile().isDirectory()){
//                    FluentIterable<File> allFiles = FileUtils.getAllFiles(directoryInput.getFile());
//
//                    for (File file: allFiles) {
//                        String name = file.getName();
//                        if (name.endsWith(".class") && name != "R.class"  && name != "BuildConfig.class") { //&& !name.startsWith("R\$")
//                            System.out.println("aaaaaa"+name);
//                        }
//                    }
//
//                }
//            }
//
//        }
//    }
//}
