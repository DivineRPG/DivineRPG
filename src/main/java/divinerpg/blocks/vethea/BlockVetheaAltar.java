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
import net.minecraft.world.phys.BlockHitResult;

public abstract class BlockVetheaAltar extends BlockModUnbreakable {

    protected BlockVetheaAltar() {
        super();
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        ItemStack heldItemStack = player.getItemInHand(hand);

        if(!world.isClientSide && heldItemStack != null && heldItemStack.getItem() == acceptedItem()) {
            if (!player.isCreative()) {
                heldItemStack.shrink(1);
            }
            spawnBoss(world, pos);
        }
        else {
            onFailure();
        }

        return InteractionResult.PASS;
    }

    public void spawnBoss(Level worldIn, BlockPos pos) {
        getBoss(worldIn).getType().spawn((ServerLevel) worldIn, null, null, pos, MobSpawnType.MOB_SUMMONED, false, false);
    }

    protected abstract Item acceptedItem();
    protected abstract LivingEntity getBoss(Level world);
    protected abstract void onFailure();
}
