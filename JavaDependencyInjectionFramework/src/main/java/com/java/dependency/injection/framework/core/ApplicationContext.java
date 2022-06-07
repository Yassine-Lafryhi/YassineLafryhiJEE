package com.java.dependency.injection.framework.core;

import com.java.dependency.injection.framework.core.annotations.ComponentScan;
import com.java.dependency.injection.framework.core.annotations.Configuration;
import com.java.dependency.injection.framework.core.annotations.MyOwnComponent;
import com.java.dependency.injection.framework.core.annotations.MyOwnAutoWired;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationContext {
    Map<Class<?>, Object> elements = new HashMap<>();

    public ApplicationContext(Class<?> aClass) {
        initialize(aClass);
    }

    public <T> T getInstance(Class<T> aClass) throws Exception {
        T object = (T) elements.get(aClass);
        Field[] fields = aClass.getDeclaredFields();
        inject(object, fields);
        return object;
    }

    private <T> void inject(T object, Field[] fields) throws Exception {
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(MyOwnAutoWired.class)) {
                Class<?> type = field.getType();
                Object inner = elements.get(type);
                field.set(object, inner);
                inject(inner, type.getDeclaredFields());
            }
        }
    }

    private void initialize(Class<?> aClass) {
        if (!aClass.isAnnotationPresent(Configuration.class)) {
            throw new RuntimeException("The configuration file is missing !");
        } else {
            ComponentScan scan = aClass.getAnnotation(ComponentScan.class);
            String packageValue = scan.value();
            Set<Class<?>> classes = findClasses(packageValue);
            if (classes != null) {
                for (Class<?> theClass : classes) {
                    try {
                        if (theClass.isAnnotationPresent(MyOwnComponent.class)) {
                            Constructor<?> constructor = theClass.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            Object instance = constructor.newInstance();
                            elements.put(theClass, instance);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Set<Class<?>> findClasses(String thePackage) {
        InputStream inputStream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(thePackage.replaceAll("[.]", "/"));
        BufferedReader bufferedReader = null;
        if (inputStream != null) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }
        if (bufferedReader != null) {
            return bufferedReader.lines()
                    .filter(line -> line.endsWith(".class"))
                    .map(line -> getClass(line, thePackage))
                    .collect(Collectors.toSet());
        }
        return null;
    }

    private Class<?> getClass(String name, String thePackage) {
        try {
            return Class.forName(thePackage.concat(".").concat(name.substring(0, name.lastIndexOf('.'))));
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
