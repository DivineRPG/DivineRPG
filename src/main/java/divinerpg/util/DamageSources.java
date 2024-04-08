package divinerpg.util;

import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.level.Level;

public class DamageSources {
    public static final ResourceKey<DamageType>
        ACID = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "acid")),
        ARCANA = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "arcana")),
        SPIKE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "spike")),
        TAR = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "tar")),
        TRAP = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "trap")),
    	TURTLE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "turtle"));
    public static DamageSource source(Level level, ResourceKey<DamageType> id) {
        final Registry<DamageType> registry = level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
        final Holder.Reference<DamageType> damage = registry.getHolderOrThrow(id);
        return new DamageSource(damage);
    }
}