package divinerpg.registries;

import divinerpg.enchant.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.registries.*;

import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;

public class EnchantmentRegistry {
    public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(BuiltInRegistries.ENCHANTMENT, MODID);
    public static final DeferredHolder<Enchantment, Enchantment>
    	RIVE = registerEnchantment("rive", RiveEnchant::new),
    	AFTERSHOCK = registerEnchantment("aftershock", AftershockEnchant::new),
    	BRAIN_FREEZE = registerEnchantment("brain_freeze", BrainFreezeEnchant::new),
    	INSULATION = registerEnchantment("insulation", InsulationEnchant::new);

    private static DeferredHolder<Enchantment, Enchantment> registerEnchantment(String id, Supplier<Enchantment> enchantment) {
        return ENCHANTS.register(id, enchantment);
    }

}
