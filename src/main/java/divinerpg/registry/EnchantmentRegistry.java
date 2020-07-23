package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.enchant.DoubleDealDamageEnchant;
import divinerpg.enchant.WorldBreakEnchant;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
@GameRegistry.ObjectHolder(DivineRPG.MODID)
public class EnchantmentRegistry {
    @GameRegistry.ObjectHolder("rive")
    public static final Enchantment RIVE = null;
    @GameRegistry.ObjectHolder("aftershock")
    public static final Enchantment AFTERSHOCK = null;

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> e) {
        IForgeRegistry<Enchantment> registry = e.getRegistry();

        registry.register(new WorldBreakEnchant().setRegistryName(DivineRPG.MODID, "rive"));
        registry.register(new DoubleDealDamageEnchant().setRegistryName(DivineRPG.MODID, "aftershock"));
    }
}
