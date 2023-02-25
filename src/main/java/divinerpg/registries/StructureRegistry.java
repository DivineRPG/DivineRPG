package divinerpg.registries;

import com.mojang.serialization.Codec;
import divinerpg.DivineRPG;
import divinerpg.world.structure.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraftforge.registries.*;

public class StructureRegistry {
	public static final StructurePlaceSettings defaultSettings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setKeepLiquids(true);
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, DivineRPG.MODID);

    public static final RegistryObject<StructureType<?>>
    	HIGHEST_GROUND = STRUCTURE_TYPE.register("highest_ground", () -> codecConv(HighestGroundType.CODEC)),
    	LOWEST_GROUND = STRUCTURE_TYPE.register("lowest_ground", () -> codecConv(LowestGroundType.CODEC)),
    	HIGHEST_CEILING = STRUCTURE_TYPE.register("highest_ceiling", () -> codecConv(HighestCeilingType.CODEC)),
    	LOWEST_CEILING = STRUCTURE_TYPE.register("lowest_ceiling", () -> codecConv(LowestCeilingType.CODEC));

    private static <S extends Structure> StructureType<S> codecConv(Codec<S> codec) {
        return () -> codec;
    }
    public static void placeStructure(StructureTemplate structure, WorldGenLevel level, RandomSource random, BlockPos pos) {
    	structure.placeInWorld(level, pos, pos, defaultSettings, random, 2);
	}
    public static void placeStructure(StructureTemplate structure, WorldGenLevel level, RandomSource random, BlockPos pos, Rotation rotation) {
    	structure.placeInWorld(level, pos, pos, defaultSettings.copy().setRotation(rotation), random, 2);
	}
}