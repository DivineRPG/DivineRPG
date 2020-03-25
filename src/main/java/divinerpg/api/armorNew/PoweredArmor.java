package divinerpg.api.armorNew;

import divinerpg.api.armorNew.interfaces.IArmorSet;
import divinerpg.api.armorNew.interfaces.IEquipped;
import divinerpg.api.armorNew.interfaces.IPoweredArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class PoweredArmor extends IForgeRegistryEntry.Impl<IPoweredArmor> implements IPoweredArmor {
    protected final Map<Class, ForgeEventHandler<?>> abilities = new HashMap<>();
    private final IEquipped handler;
    private final IArmorSet set;

    public PoweredArmor(IArmorSet set, IEquipped handler) {
        Objects.requireNonNull(set);

        this.handler = handler;
        this.set = set;
    }


    public PoweredArmor(Item helmet, Item chestplate, Item legs, Item boots) {
        this(helmet, chestplate, legs, boots, null);
    }

    public PoweredArmor(Item helmet, Item chestplate, Item legs, Item boots, IEquipped handler) {
        this(new ArmorSet().withVariant(helmet, chestplate, legs, boots), handler);
    }

    @Override
    public Map<Class, ForgeEventHandler<?>> getAbilityMap() {
        return abilities;
    }

    @Override
    public <T extends Event, TRes extends IPoweredArmor> TRes addAbility(Class<T> clazz, Consumer<T> e) {
        if (!abilities.containsKey(clazz)) {
            abilities.put(clazz, new ForgeEventHandler<>(clazz, e));
        }

        return (TRes) this;
    }

    @Override
    public IArmorSet getArmorDescription() {
        return set;
    }

    @Override
    public void onEquppedChanged(EntityPlayer player, boolean isEquipped) {
        if (handler != null) {
            handler.onEquppedChanged(player, isEquipped);
        }
    }
}
