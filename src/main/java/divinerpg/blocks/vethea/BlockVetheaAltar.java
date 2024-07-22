package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockModUnbreakable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

public abstract class BlockVetheaAltar extends BlockModUnbreakable {

    protected BlockVetheaAltar(MapColor color) {
        super(color);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!world.isClientSide && stack != null && stack.getItem() == acceptedItem()) {
            if (!player.isCreative()) stack.shrink(1);
            spawnBoss(world, pos);
        }
        else onFailure();
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public void spawnBoss(Level worldIn, BlockPos pos) {
        if(!worldIn.isClientSide)
        getBoss(worldIn).getType().spawn((ServerLevel) worldIn, ItemStack.EMPTY, null, pos, MobSpawnType.MOB_SUMMONED, false, false);
    }

    protected abstract Item acceptedItem();
    protected abstract LivingEntity getBoss(Level world);
    protected abstract void onFailure();
}
