package divinerpg.registries;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.Registries.DIMENSION;
import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

public class LevelRegistry {
    public static final ResourceKey<Level>
        ICEIKA = register("iceika"),
        ARCANA = register("arcana"),
        EDEN = register("eden"),
        WILDWOOD = register("wildwood"),
        APALACHIA = register("apalachia"),
        SKYTHERN = register("skythern"),
        MORTUM = register("mortum"),
        VETHEA = register("vethea");

    private static ResourceKey<Level> register(String name) {
        return ResourceKey.create(DIMENSION, fromNamespaceAndPath(MODID, name));
    }
}