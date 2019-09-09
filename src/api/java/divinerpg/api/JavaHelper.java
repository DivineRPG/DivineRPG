package divinerpg.api;

import java.lang.reflect.Field;

public class JavaHelper {

    /**
     * Tryies to get public static field
     *
     * @param className - class name like java.util.Clazz
     * @param fieldName - name of field
     * @param <T>       - returning type
     * @return - value of public static field
     */
    public static <T> T getPublicStaticField(String className, String fieldName) {

        try {
            Class<?> clazz = Class.forName(className);
            Field field = clazz.getField(fieldName);
            return (T) field.get(null);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't load " + className);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't find " + fieldName + " field");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Do not have access to public static field");
        }
    }
}
