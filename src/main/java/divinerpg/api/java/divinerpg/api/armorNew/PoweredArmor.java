package divinerpg.api.java.divinerpg.api.armorNew;

import divinerpg.api.java.divinerpg.api.armor14.IEquipped;
import divinerpg.api.java.divinerpg.api.armor14.IPowerAbility;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IArmorSet;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PoweredArmor extends IForgeRegistryEntry.Impl<IPoweredArmor> implements IPoweredArmor {
    private final Map<Class, IPowerAbility<?>> abilities = new HashMap<>();
    private final IEquipped handler;
    private final IArmorSet set;

    public PoweredArmor(IEquipped handler, IArmorSet set) {
        this.handler = handler;
        this.set = set;
    }


    @Override
    public <T extends Event> void addAbility(Class<T> clazz, IPowerAbility<?> e) {

    }

    @Nullable
    @Override
    public IEquipped getEquippedHandler() {
        return handler;
    }

    @Override
    public IArmorSet getArmorDescription() {
        return null;
    }
}
