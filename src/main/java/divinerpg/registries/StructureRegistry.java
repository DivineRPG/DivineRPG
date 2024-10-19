package divinerpg.registries;

import com.mojang.serialization.MapCodec;
import divinerpg.DivineRPG;
import divinerpg.world.structure.HighestCeilingType;
import divinerpg.world.structure.HighestGroundType;
import divinerpg.world.structure.LowestCeilingType;
import divinerpg.world.structure.LowestGroundType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StructureRegistry {
	public static final StructurePlaceSettings defaultSettings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setLiquidSettings(LiquidSettings.APPLY_WATERLOGGING);
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE = DeferredRegister.create(Registries.STRUCTURE_TYPE, DivineRPG.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<?>>
    	HIGHEST_GROUND = STRUCTURE_TYPE.register("highest_ground", () -> codecConv(HighestGroundType.CODEC)),
    	LOWEST_GROUND = STRUCTURE_TYPE.register("lowest_ground", () -> codecConv(LowestGroundType.CODEC)),
    	HIGHEST_CEILING = STRUCTURE_TYPE.register("highest_ceiling", () -> codecConv(HighestCeilingType.CODEC)),
    	LOWEST_CEILING = STRUCTURE_TYPE.register("lowest_ceiling", () -> codecConv(LowestCeilingType.CODEC));

	private static <S extends Structure> StructureType<S> codecConv(MapCodec<S> codec) {
        return () -> (MapCodec<S>) codec;
    }
    public static void placeStructure(StructureTemplate structure, WorldGenLevel level, RandomSource random, BlockPos pos) {
    	structure.placeInWorld(level, pos, pos, defaultSettings, random, 2);
	}
    public static void placeStructure(StructureTemplate structure, WorldGenLevel level, RandomSource random, BlockPos pos, Rotation rotation) {
    	structure.placeInWorld(level, pos, pos, defaultSettings.copy().setRotation(rotation), random, 2);
	}
}