package divinerpg.blocks.vanilla;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static divinerpg.registries.ItemRegistry.rupee_shickaxe;
import static divinerpg.registries.TagRegistry.MINEABLE_WITH_SHICKAXE;
import static net.minecraft.ChatFormatting.LIGHT_PURPLE;
import static net.minecraft.core.registries.Registries.ENCHANTMENT;
import static net.minecraft.tags.BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
import static net.minecraft.world.item.enchantment.Enchantments.SILK_TOUCH;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class SoftMinerBlock extends MinerBlock {
    @Override public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos p, boolean b) {
        if(level instanceof ServerLevel s) {
            boolean hasSignal = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above()), triggered = state.getValue(BlockStateProperties.TRIGGERED);
            if(triggered && !hasSignal) level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, false), UPDATE_NONE);
            else if(hasSignal && !triggered) {
                level.setBlock(pos, state.setValue(BlockStateProperties.TRIGGERED, true), 4);
                p = pos.relative(state.getValue(BlockStateProperties.FACING));
                BlockState blockState = level.getBlockState(p);
                if(!s.getBlockState(p).is(INCORRECT_FOR_DIAMOND_TOOL) && s.getBlockState(p).is(MINEABLE_WITH_SHICKAXE)) {
                    ItemStack tool = rupee_shickaxe.toStack();
                    tool.enchant(s.holderLookup(ENCHANTMENT).getOrThrow(SILK_TOUCH), 1);
                    List<ItemStack> drops = blockState.getDrops(new LootParams.Builder(s).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos)).withParameter(LootContextParams.TOOL, tool));
                    level.destroyBlock(p, false);
                    for(ItemStack drop : drops) if(!drop.isEmpty()) {
                        ItemEntity itemEntity = new ItemEntity(s, p.getX() + .5, p.getY() + .5, p.getZ() + .5, drop);
                        itemEntity.setDeltaMovement(0, .1, 0);
                        s.addFreshEntity(itemEntity);
                    }
                }
            }
        }
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, context, tooltip, flagIn);
        tooltip.add(Component.translatable("enchantment.minecraft.silk_touch").withStyle(LIGHT_PURPLE));
    }
}