package divinerpg.blocks.base;

import divinerpg.block_entities.DivineSignHanging;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;

import static net.minecraft.world.level.block.Blocks.OAK_SIGN;

public class DivineSignHangingCeiling extends CeilingHangingSignBlock {
    public DivineSignHangingCeiling(DeferredBlock<Block> base, WoodType type) {super(type, Properties.ofFullCopy(OAK_SIGN).mapColor(base.get().defaultMapColor()));}
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new DivineSignHanging(pos, state);}
}