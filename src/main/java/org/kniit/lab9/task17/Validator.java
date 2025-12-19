package org.kniit.lab9.task17;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //разрешает доступ к private переменным
            field.setAccessible(true);
            Object value = field.get(obj);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();

                if (value instanceof String) {
                    String strValue = (String) value;
                    if (strValue.length() > maxLength) {
                        System.out.println("Поле " + field.getName() +
                                " превышает максимальную длину " + maxLength + ".");
                    }
                }
            }

            // 3. Проверка @Min
            if (field.isAnnotationPresent(Min.class)) {
                int minVal = field.getAnnotation(Min.class).value();
                if (value instanceof Number) {
                    int intValue = ((Number) value).intValue();
                    if (intValue < minVal) {
                        System.out.println("Поле " + field.getName() +
                                " должно быть не меньше " + minVal + ".");
                    }
                }
            }
        }
    }
}
