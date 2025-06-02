package divinerpg.blocks.vanilla;

import divinerpg.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SoftMinerBlock extends MinerBlock {
    @Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
        if(level instanceof ServerLevel s) {
            boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above()), triggered = state.getValue(BlockStateProperties.TRIGGERED);
            if(triggered && !hasSignal) level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, false), UPDATE_NONE);
            else if(hasSignal && !triggered) {
                level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, true), 4);
                p = pos.relative(state.getValue(BlockStateProperties.FACING));
                BlockState blockState = level.getBlockState(p);
                if(!s.getBlockState(p).is(BlockTags.WITHER_IMMUNE)) {
                    ItemStack tool = ItemRegistry.divine_shickaxe.toStack();
                    tool.enchant(s.holderLookup(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), 1);
                    List<ItemStack> drops = blockState.getDrops(new LootParams.Builder(s).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withParameter(LootContextParams.TOOL, tool));
                    level.destroyBlock(p, false);
                    for(ItemStack drop : drops) if(!drop.isEmpty()) {
                        ItemEntity itemEntity = new ItemEntity(s, p.getX() + .5, p.getY() + .5, p.getZ() + .5, drop);
                        itemEntity.setDeltaMovement(0, 0.1, 0);
                        s.addFreshEntity(itemEntity);
                    }
                }
            }
        }
    }
}