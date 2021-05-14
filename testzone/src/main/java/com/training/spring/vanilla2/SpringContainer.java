package com.training.spring.vanilla2;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

class SpringContainer {

    Map<String, Object> components = new LinkedHashMap<>();

    public void registerComponent(Object object) {
        components.put(object.getClass().getTypeName(), object);
    }

    public Map<String, Object> getComponents() {
        return components;
    }

    public void autowire(Object parentObject) throws IllegalAccessException {
        Field[] fields = parentObject.getClass().getDeclaredFields();

        for (Field field : fields) {
            String typeName = field.getType().getTypeName();

            if (components.containsKey(typeName)) {
                System.out.println("Hey I have this");

                field.set(parentObject, components.get(typeName));
            }
        }

    }
}
