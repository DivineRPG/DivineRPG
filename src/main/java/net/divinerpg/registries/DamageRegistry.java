package net.divinerpg.registries;

import net.divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import java.util.ArrayList;
import java.util.List;

public class DamageRegistry {
    public static final List<ResourceKey<DamageType>> DAMAGE_TYPES = new ArrayList<>();

    public static final ResourceKey<DamageType> ACID = register("acid");
    public static final ResourceKey<DamageType> ARCANA = register("arcana");
    public static final ResourceKey<DamageType> HAIL = register("hail");
    public static final ResourceKey<DamageType> SPIKE = register("spike");
    public static final ResourceKey<DamageType> TAR = register("tar");
    public static final ResourceKey<DamageType> TURTLE = register("turtle");

    private static ResourceKey<DamageType> register(String name) {
        ResourceKey<DamageType> key = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name));
        DAMAGE_TYPES.add(key);
        return key;
    }

    public static void load() {
    }
}