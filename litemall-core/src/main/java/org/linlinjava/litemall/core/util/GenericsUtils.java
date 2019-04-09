package org.linlinjava.litemall.core.util;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GenericsUtils {
    /**
     * 获取currentClass在定义时规定的targetClass的泛型数组列表
     *
     * @param currentClass
     *            必须是类或者接口
     * @param targetClass
     *            必须是类或者接口，并且currentClass直接或者间接 继承或者实现了targetClass
     * @param <T>
     *            为规定参数而设置的泛型
     * @return 按照targetClass泛型规定的顺序排列的的泛型class列表。如果currentClass是一个有未定义泛型的类，那会将未定义的泛型设置为null
     */
    public static <T> Class[] obtainTargetClassGenericTypes(Class<T> currentClass, Class<? super T> targetClass) {
        if (!currentClass.isInterface() && !currentClass.isLocalClass() && !currentClass.isMemberClass()
                && !currentClass.isAnonymousClass() && !Modifier.isAbstract(currentClass.getModifiers())) {
            throw new RuntimeException("currentClass 必须是类或者接口");
        }
        if (currentClass == targetClass) {
            return null;
        }

        List<Class> lastTypes = null;
        Class tempCurrentClass = currentClass;

        do {
            // 获取当前类的泛型列表
            final TypeVariable[] thisTypeArguments = tempCurrentClass.getTypeParameters();
            // 获取当前类继承父类时规定父类的泛型列表
            Type[] superTypeArguments = null;
            final Type genericSuper = obtainSpecifySuperClassByTargetClass(tempCurrentClass, targetClass);
            if (genericSuper instanceof ParameterizedType) {
                superTypeArguments = ((ParameterizedType) genericSuper).getActualTypeArguments();
            }
            final List<Type> types = new ArrayList<>();
            if (superTypeArguments != null) {
                for (final Type type : superTypeArguments) {
                    if (type instanceof Class) {
                        types.add(type);
                        continue;
                    }
                    // 匹配lastTypes
                    if (lastTypes != null) {
                        final String typeName = type.getTypeName();
                        for (int j = 0; j < thisTypeArguments.length; j++) {
                            final TypeVariable thisTypeArgument = thisTypeArguments[j];
                            if (Objects.equals(thisTypeArgument.getName(), typeName)) {
                                types.add(lastTypes.get(j));
                            }
                        }
                    } else {
                        types.add(null);
                    }
                }
            }
            lastTypes = types.stream().map(type -> type instanceof Class ? (Class) type : null)
                    .collect(Collectors.toList());
            tempCurrentClass = obtainParentByTargetClass(tempCurrentClass, targetClass);

        } while (tempCurrentClass != null && tempCurrentClass != targetClass);
        return lastTypes.toArray(new Class[0]);
    }

    /**
     * 获取当前类的父类
     * <p>
     * 作用：不是单纯的使用{@link Class#getSuperclass()}。因为targetClass不一定是类，可能是接口
     *
     * @param currentClass
     *            当前类
     * @param targetClass
     *            目标父...父类
     * @return currentClass的父类，并且是targetClass的子类
     */
    public static <T> Class obtainParentByTargetClass(Class<T> currentClass, Class<? super T> targetClass) {
        if (currentClass == targetClass) {
            return null;
        }
        if (currentClass.getSuperclass() != null && targetClass.isAssignableFrom(currentClass.getSuperclass())) {
            return currentClass.getSuperclass();
        } else {
            for (Class<?> anInterface : currentClass.getInterfaces()) {
                if (targetClass.isAssignableFrom(anInterface)) {
                    return anInterface;
                }
            }
        }
        return null;
    }

    /**
     * 根据targetClass获取currentClass 定义的父类获取接口的type
     *
     * @param currentClass
     *            当前类
     * @param targetClass
     *            父...父类
     * @return 当前类的定义好的父类的type
     */
    public static <T> Type obtainSpecifySuperClassByTargetClass(Class<T> currentClass, Class<? super T> targetClass) {
        if (currentClass == targetClass) {
            return null;
        }
        if (currentClass.getSuperclass() != null && targetClass.isAssignableFrom(currentClass.getSuperclass())) {
            return currentClass.getGenericSuperclass();
        } else {
            final Class<?>[] interfaces = currentClass.getInterfaces();
            int index = -1;
            for (int i = 0; i < interfaces.length; i++) {
                Class anInterface = interfaces[i];
                if (targetClass.isAssignableFrom(anInterface)) {
                    return currentClass.getGenericInterfaces()[i];
                }
            }
        }
        return null;
    }
}