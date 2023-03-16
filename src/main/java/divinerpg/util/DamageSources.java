package divinerpg.util;

import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.*;
import net.minecraft.world.damagesource.*;

public class DamageSources {
    private final Registry<DamageType> damageTypes;
    public static DamageSource trap = null;
    public static DamageSource spike = null;
    public static DamageSource acid = null;
    public static DamageSource arcana = null;
    public static DamageSource turtle = null;

    public DamageSources(RegistryAccess p_270740_) {
        this.damageTypes = p_270740_.registryOrThrow(Registries.DAMAGE_TYPE);
        this.trap = this.source(TRAP);
        this.spike = this.source(SPIKE);
        this.acid = this.source(ACID);
        this.arcana = this.source(ARCANA);
        this.turtle = this.source(TURTLE);
    }

    private DamageSource source(ResourceKey<DamageType> p_270957_) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(p_270957_));
    }

    ResourceKey<DamageType> TRAP = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "trap"));
    ResourceKey<DamageType> SPIKE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "spike"));
    ResourceKey<DamageType> ACID = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "acid"));
    ResourceKey<DamageType> ARCANA = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "arcana"));
    ResourceKey<DamageType> TURTLE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(DivineRPG.MODID, "turtle"));
}
