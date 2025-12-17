package divinerpg.registries;

import net.minecraft.resources.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.registries.DeferredRegister;

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

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(BIOME, MODID);
    static {
        BIOMES.addAlias(ResourceLocation.fromNamespaceAndPath(MODID, "eden"), ResourceLocation.fromNamespaceAndPath(MODID, "eden/plains"));
    }
}