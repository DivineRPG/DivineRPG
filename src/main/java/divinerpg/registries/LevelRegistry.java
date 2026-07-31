package divinerpg.registries;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.Registries.DIMENSION;

public class LevelRegistry {
    public static final ResourceKey<Level>
            EDEN = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "eden")),
            WILDWOOD = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "wildwood")),
            APALACHIA = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "apalachia")),
            SKYTHERN = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "skythern")),
            MORTUM = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "mortum")),
            ICEIKA = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "iceika")),
            ARCANA = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "arcana")),
            VETHEA = ResourceKey.create(DIMENSION, Identifier.fromNamespaceAndPath(MODID, "vethea"));
    public static void load() {}
}
