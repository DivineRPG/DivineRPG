package divinerpg.utils.attributes;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReflectionHelper implements IReflectionHelper {
    private final Map<Class<?>, Map<String, Field>> mappedFields = new LinkedHashMap<>();
    private final Map<Class<?>, Map<String, Method>> mappedMethods = new LinkedHashMap<>();

    @Nullable
    @Override
    public Field findField(Class<?> holderClass, String name) {
        if (holderClass != null && name != null) {
            // try to find from
            Map<String, Field> classFields = mappedFields.computeIfAbsent(holderClass, aClass -> new LinkedHashMap<>());
            // find exactly what we want
            if (classFields.containsKey(name))
                return classFields.get(name);

            // Find obfuscating names
            String[] fieldNames = ObfuscationReflectionHelper.remapFieldNames(holderClass.getName(), name);

            try {
                // trying to find field
                Field field = net.minecraftforge.fml.relauncher.ReflectionHelper.findField(holderClass, fieldNames);
                if (field != null) {
                    classFields.put(name, setAccessible(field));

                    return classFields.get(name);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Nullable
    @Override
    public Method findMethod(@Nonnull Class<?> holderClass, @Nonnull String name, Class... params) {
        Map<String, Method> map = mappedMethods.computeIfAbsent(holderClass, x -> new LinkedHashMap<>());

        Method method = map.get(name);

        if (method != null) {
            Class<?>[] currentParams = method.getParameterTypes();

            if (Arrays.equals(currentParams, params))
                return method;
        }

        // Find obfuscating names
        String[] fieldNames = ObfuscationReflectionHelper.remapFieldNames(holderClass.getName(), name);

        try {
            for (String fieldName : fieldNames) {
                Method findedMethod = net.minecraftforge.fml.relauncher.ReflectionHelper.findMethod(holderClass, name, fieldName, params);
                if (findedMethod != null) {
                    map.put(name, findedMethod);

                    return findedMethod;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}