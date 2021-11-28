package divinerpg.world.arcana;


import com.mojang.serialization.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.template.*;
import java.util.*;

public class ArcanaStructureBlockProcessor extends StructureProcessor {

    public static final ArcanaStructureBlockProcessor INSTANCE = new ArcanaStructureBlockProcessor();
    public static final Codec<ArcanaStructureBlockProcessor> CODEC = Codec.unit(ArcanaStructureBlockProcessor::new);

    @Override
    public Template.BlockInfo processBlock(IWorldReader worldView, BlockPos pos, BlockPos blockPos, Template.BlockInfo structureBlockInfoLocal, Template.BlockInfo structureBlockInfoWorld, PlacementSettings structurePlacementData) {
        BlockState blockState = structureBlockInfoWorld.state;
        BlockPos worldPos = structureBlockInfoWorld.pos;
        if (blockState.is(Blocks.STRUCTURE_BLOCK)) {
            String metadata = structureBlockInfoWorld.nbt.getString("metadata");
            Random random = structurePlacementData.getRandom(worldPos);
            switch (metadata) {
                case "BanquetHallLoot": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/arcana/banquet_hall_loot");
                    return new Template.BlockInfo(worldPos.below(), Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "UtilityHallwayLoot": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/arcana/utility_hallway_loot");
                    return new Template.BlockInfo(worldPos.below(), Blocks.CHEST.defaultBlockState(), nbt);
                }
            }

        }
        return structureBlockInfoWorld;
    }

    @Override
    protected IStructureProcessorType<?> getType() {
        return KeyRegistry.CHEST_PROCESSOR;
    }
}
