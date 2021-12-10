package divinerpg.world.arcana;


import com.mojang.serialization.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.template.*;
import java.util.*;

public class DivineStructureBlockProcessor extends StructureProcessor {

    public static final DivineStructureBlockProcessor INSTANCE = new DivineStructureBlockProcessor();
    public static final Codec<DivineStructureBlockProcessor> CODEC = Codec.unit(DivineStructureBlockProcessor::new);

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
                case "Crypt": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/crypt_loot");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "Temple1": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/temple_loot_bottom");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "Temple2": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/temple_loot_middle");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "Temple3": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/temple_loot_top");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "Karos": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/karos_madhouse_loot");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "Quad": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/quadrotic_post_loot");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "Wreck": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/wreck_hall_loot");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
                }
                case "Raglok": {
                    CompoundNBT nbt = new CompoundNBT();
                    nbt.putString("LootTable", "divinerpg:chests/vethea/raglok_chamber_loot");
                    return new Template.BlockInfo(worldPos, Blocks.CHEST.defaultBlockState(), nbt);
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
