package net.divinerpg.registries;

import net.divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentRegistry {
    public static final ResourceKey<Enchantment> RIVE = createKey("rive");
    public static final ResourceKey<Enchantment> AFTERSHOCK = createKey("aftershock");
    public static final ResourceKey<Enchantment> BRAIN_FREEZE = createKey("brain_freeze");
    public static final ResourceKey<Enchantment> INSULATION = createKey("insulation");

    private static ResourceKey<Enchantment> createKey(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name));
    }
    public static void load() {}
}
