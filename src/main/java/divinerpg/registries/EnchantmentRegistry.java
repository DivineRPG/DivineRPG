package divinerpg.registries;

import divinerpg.*;
import divinerpg.enchant.*;
import net.minecraft.enchantment.*;
import net.minecraftforge.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.registries.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(DivineRPG.MODID)
public class EnchantmentRegistry {
    @ObjectHolder("rive")
    public static final Enchantment RIVE = null;
    @ObjectHolder("aftershock")
    public static final Enchantment AFTERSHOCK = null;

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> e) {
        DivineRPG.LOGGER.info("[DivineRPG] Registered enchantments");
        IForgeRegistry<Enchantment> registry = e.getRegistry();

        registry.register(new RiveEnchant());
        registry.register(new AftershockEnchant());
    }

}
