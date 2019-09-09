package divinerpg.api.registry;

import divinerpg.api.JavaHelper;
import divinerpg.api.armorset.FullArmorHandler;

/**
 * Registration of Full armor handlers.
 */
public class FullArmorRegistry implements IFullArmorRegistry {

    private static IFullArmorRegistry reference;

    private static IFullArmorRegistry getReference() {
        if (reference == null) {
            reference = JavaHelper.getPublicStaticField("divinerpg.registry.ModArmorEvents", "instance");
        }

        return reference;
    }

    @Override
    public void addHandler(FullArmorHandler handler) {
        getReference().addHandler(handler);
    }

    @Override
    public void removeHandler(FullArmorHandler handler) {
        getReference().removeHandler(handler);
    }
}
