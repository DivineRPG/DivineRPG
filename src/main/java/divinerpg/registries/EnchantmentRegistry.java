package divinerpg.registries;

import divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentRegistry {
    public static final ResourceKey<Enchantment>
    	RIVE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "rive")),
    	AFTERSHOCK = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "aftershock")),
    	BRAIN_FREEZE = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "brain_freeze")),
    	INSULATION = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "insulation"));
}