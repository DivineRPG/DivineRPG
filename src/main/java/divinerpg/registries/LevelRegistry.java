package divinerpg.registries;

import net.minecraft.resources.*;
import net.minecraft.world.level.Level;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.Registries.*;

public class LevelRegistry {
    public static final ResourceKey<Level>
        EDEN = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "eden")),
        WILDWOOD = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "wildwood")),
        APALACHIA = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "apalachia")),
        SKYTHERN = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "skythern")),
        MORTUM = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "mortum")),
        ICEIKA = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "iceika")),
        ARCANA = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "arcana")),
        VETHEA = ResourceKey.create(DIMENSION, ResourceLocation.fromNamespaceAndPath(MODID, "vethea"));
}