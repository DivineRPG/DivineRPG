package divinerpg.registries;

import divinerpg.enchant.AftershockEnchant;
import divinerpg.enchant.BrainFreezeEnchant;
import divinerpg.enchant.InsulationEnchant;
import divinerpg.enchant.RiveEnchant;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;

public class EnchantmentRegistry {
	public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(Registries.ENCHANTMENT, MODID);
    public static final DeferredHolder<Enchantment, Enchantment>
    	RIVE = registerEnchantment("rive", RiveEnchant::new),
    	AFTERSHOCK = registerEnchantment("aftershock", AftershockEnchant::new),
    	BRAIN_FREEZE = registerEnchantment("brain_freeze", BrainFreezeEnchant::new),
    	INSULATION = registerEnchantment("insulation", InsulationEnchant::new);
    private static DeferredHolder<Enchantment, Enchantment> registerEnchantment(String id, Supplier<Enchantment> enchantment) {return ENCHANTMENTS.register(id, enchantment);}
}