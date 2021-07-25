package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public abstract class BlockVetheaAltar extends BlockModUnbreakable {

    protected BlockVetheaAltar(String name) {
        super(name);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
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

        return super.use(state, world, pos, player, hand, result);
    }

    private void spawnBoss(World worldIn, BlockPos pos) {
        LivingEntity boss = this.getBoss(worldIn);
        boss.moveTo(pos.getX(), pos.getY(), pos.getZ());
        worldIn.addFreshEntity(boss);
    }

    protected abstract Item acceptedItem();
    protected abstract LivingEntity getBoss(World world);
    protected abstract void onFailure();
}
