package divinerpg.api.java.divinerpg.api.armorNew;

import divinerpg.api.java.divinerpg.api.armor14.IEquipped;
import divinerpg.api.java.divinerpg.api.armor14.IPowerAbility;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IArmorSet;
import divinerpg.api.java.divinerpg.api.armorNew.interfaces.IPoweredArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.Map;

public class PoweredArmor extends IForgeRegistryEntry.Impl<IPoweredArmor> implements IPoweredArmor {
    protected final Map<Class, IPowerAbility<? extends net.minecraftforge.fml.common.eventhandler.Event>> abilities = new HashMap<>();
    private final IEquipped handler;
    private final IArmorSet set;

    public PoweredArmor(IEquipped handler, IArmorSet set) {
        this.handler = handler;
        this.set = set;
    }

    @Override
    public Map<Class, IPowerAbility<?>> getAbilityMap() {
        return abilities;
    }

    @Override
    public <T extends Event> void addAbility(Class<T> clazz, IPowerAbility<T> e) {
        if (!abilities.containsKey(clazz)) {
            abilities.put(clazz, e);
        }
    }

    @Override
    public IArmorSet getArmorDescription() {
        return null;
    }

    @Override
    public void onEquppedChanged(EntityPlayer player, boolean isEquipped) {
        if (handler != null) {
            handler.onEquppedChanged(player, isEquipped);
        }
    }
}
