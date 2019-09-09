package divinerpg.api.registry;

import divinerpg.api.armorset.FullArmorHandler;

import java.lang.reflect.Field;

public class FullArmorRegistry implements IFullArmorRegistry {

    private static IFullArmorRegistry reference;

    static {
        String className = "divinerpg.registry.ModArmorEvents";

        try {
            Class<?> clazz = Class.forName(className);
            Field field = clazz.getField("instance");
            reference = (IFullArmorRegistry) field.get(null);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't load " + className);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't find instance field");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Do not have access to public static field");
        }
    }

    @Override
    public void addHandler(FullArmorHandler handler) {
        reference.addHandler(handler);
    }

    @Override
    public void removeHandler(FullArmorHandler handler) {
        reference.removeHandler(handler);
    }
}
