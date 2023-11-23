package com.sample.util;

import io.grpc.ServerInterceptor;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.StringMemberValue;
import org.lognet.springboot.grpc.GRpcService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DynamicAnnotationUtils {

    private static final String ANNOTATIONS = "annotations";
    private static final String ANNOTATION_DATA = "annotationData";

    /**
     * 特定のクラスのアノテーションを、別のアノテーションに置き換えます。
     *
     * @param targetClazz 置換対象のアノテーションを設定しているクラスです。
     * @param originalName 置換元のアノテーションです。
     * @param newOne      置換先のアノテーションです。置換元のアノテーションをextednsしたクラスのインスタンスになる事が多いでしょう。
     * @since
     */
    public static void annotationReplacedBy(Class<?> targetClazz, String originalName, Annotation newOne) {
        try {
            @SuppressWarnings("all")
            Method method = Class.class.getDeclaredMethod(ANNOTATION_DATA, null);
            method.setAccessible(true);

            Object annotationData = method.invoke(targetClazz);

            Field annotations = annotationData.getClass().getDeclaredField(ANNOTATIONS);
            annotations.setAccessible(true);

            @SuppressWarnings("unchecked")
            Map<Class<? extends Annotation>, Annotation> map =
                    (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);

            Annotation original = map.entrySet().stream().filter(e -> {
                return e.getKey().getSimpleName().equals(originalName);
            }).findFirst().get().getValue();

            if (original == null) {
                throw new IllegalArgumentException(
                        String.format("Class(%s) has not %s annotaion.",
                                targetClazz.getCanonicalName(), originalName));
            }

            map.put(original.getClass(), newOne);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public static void annotationAdd(Class<?> targetClazz, Annotation newOne) {
        try {
            @SuppressWarnings("all")
            Method method = Class.class.getDeclaredMethod(ANNOTATION_DATA, null);
            method.setAccessible(true);

            Object annotationData = method.invoke(targetClazz);

            Field annotations = annotationData.getClass().getDeclaredField(ANNOTATIONS);
            annotations.setAccessible(true);



            @SuppressWarnings("unchecked")
            Map<Class<? extends Annotation>, Annotation> map =
                    (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);

            map.put(newOne.getClass(), newOne);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }


    public static void annotationAdd(String className,String annotation) throws Exception{

        //pool creation
        ClassPool pool = ClassPool.getDefault();

        //extracting the class
        CtClass cc = pool.getCtClass(className);

//        //looking for the method to apply the annotation on
//        CtMethod sayHelloMethodDescriptor = cc.getDeclaredMethod(methodName);
        // create the annotation
//        ClassFile ccFile = cc.getClassFile();
//        ConstPool constpool = ccFile.getConstPool();
//        AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);

        ConstPool constpool = cc.getClassFile().getConstPool();

        //アノテーションの追加
//        ClassPool constpool = cc.getClassFile().getConstPool();
        AnnotationsAttribute attr = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);

        javassist.bytecode.annotation.Annotation annot = new javassist.bytecode.annotation.Annotation(annotation, constpool);

        // annot.addMemberValue("value", new StringMemberValue("http://www.w3.org/2003/05/soap/bindings/HTTP/", constpool));
        attr.addAnnotation(annot);
//        method.getMethodInfo().addAttribute(attr);




    }
    public static class ReplacedData implements GRpcService {

        @Override
        public Class<? extends ServerInterceptor>[] interceptors() {
            return new Class[0];
        }

        @Override
        public boolean applyGlobalInterceptors() {
            return false;
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return null;
        }
    }

}