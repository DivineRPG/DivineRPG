package net.divinerpg.registries;

import net.divinerpg.DivineRPG;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

import java.util.ArrayList;
import java.util.List;

public class PaintingRegistry {
    public static final List<ResourceKey<PaintingVariant>> paintings = new ArrayList<>();

    public static final ResourceKey<PaintingVariant> FALL = register("fall");
    public static final ResourceKey<PaintingVariant> MOONLIGHT_RAVE = register("moonlight_rave");
    public static final ResourceKey<PaintingVariant> GRAZING = register("grazing");
    public static final ResourceKey<PaintingVariant> DISTURBED = register("disturbed");
    public static final ResourceKey<PaintingVariant> LEVELS = register("levels");
    public static final ResourceKey<PaintingVariant> ICE_AGE = register("ice_age");
    public static final ResourceKey<PaintingVariant> CRAWLING = register("crawling");
    public static final ResourceKey<PaintingVariant> HOWLING_AT_THE_MOON = register("howling_at_the_moon");
    public static final ResourceKey<PaintingVariant> LURKING_TERROR = register("lurking_terror");

    private static ResourceKey<PaintingVariant> register(String name) {
        ResourceKey<PaintingVariant> key = ResourceKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(DivineRPG.MODID, name));
        paintings.add(key);
        return key;
    }

    public static void load() {
    }
}