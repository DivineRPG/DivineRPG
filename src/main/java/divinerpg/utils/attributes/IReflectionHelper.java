package divinerpg.utils.attributes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Supplier;

public interface IReflectionHelper {

    /**
     * Finds field from name of static class. Caching result
     *
     * @param instance - instance of object containing that field
     * @param name     - name of field
     * @return
     */
    @Nullable
    default Field findField(@Nonnull Object instance, String name) {
        return findField(instance.getClass(), name);
    }

    /**
     * Trying to set private field value of static class
     *
     * @param holderClass - type of class where field is located
     * @param name        - name of field
     * @param newValue    - new value
     * @return
     */
    default boolean trySetPrivateStaticValue(Class<?> holderClass, String name, Object newValue) {
        return trySetPrivateValue(holderClass, null, name, newValue);
    }

    /**
     * Trying to set private field value
     *
     * @param instance - instance of object
     * @param name     - name of field
     * @param newValue - new value
     * @return
     */
    default boolean trySetPrivateValue(@Nonnull Object instance, String name, Object newValue) {
        return trySetPrivateValue(instance.getClass(), instance, name, newValue);
    }

    /**
     * Trying to set private field value
     *
     * @param holderClass - type of class where field is located
     * @param instance    - instance of object. Pass null for static
     * @param name        - name of field
     * @param newValue    - new value
     * @return
     */
    default boolean trySetPrivateValue(Class<?> holderClass, @Nullable Object instance, String name, Object newValue) {
        Field field = findField(holderClass, name);
        if (field != null) {
            try {
                field.set(instance, newValue);
                return true;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * remove modifiers from current field
     *
     * @param field - current field
     * @return
     */
    default Field setAccessible(@Nonnull Field field) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }

        // need to remove final modifier
        if ((field.getModifiers() & Modifier.FINAL) != 0) {
            try {
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return field;
    }

    /**
     * Finds field from name. Caching result
     *
     * @param holderClass - type of class where contains field
     * @param name        - name of field
     * @return
     */
    @Nullable
    Field findField(@Nonnull Class<?> holderClass, @Nonnull String name);

    /**
     * Finds methods
     *
     * @param holderClass
     * @param name
     * @param params
     * @return
     */
    @Nullable
    Method findMethod(@Nonnull Class<?> holderClass, @Nonnull String name, Class... params);

    default Object callMethod(@Nonnull Object instance, @Nonnull String name, Supplier<Object[]> func, Class... params) {
        return callMethod(instance.getClass(), instance, name, func, params);
    }

    default Object callMethod(Class<?> classToFind, @Nullable Object instance, @Nonnull String name, Supplier<Object[]> func, Class... params) {
        Method method = findMethod(classToFind, name, params);
        try {
            if (method != null) {
                return method.invoke(instance, func.get());
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return false;
    }
}
