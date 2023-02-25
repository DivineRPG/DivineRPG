package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.items.base.*;
import net.minecraft.core.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;

public class ItemAquamarine extends ItemMod {

    private final Fluid containedBlock = Fluids.FLOWING_WATER;

    public ItemAquamarine() {
        super(new Item.Properties().tab(DivineRPG.tabs.utilities).durability(10));
    }

    protected static BlockHitResult rayTrace(Level worldIn, Player player, ClipContext.Fluid fluidMode) {
        float f = player.yRot;
        float f1 = player.xRot;
        Vec3 vector3d = player.getEyePosition(1.0F);
        float f2 = Mth.cos(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f3 = Mth.sin(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f4 = -Mth.cos(-f * ((float) Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float) Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).getValue();
        Vec3 vector3d1 = vector3d.add((double) f6 * d0, (double) f5 * d0, (double) f7 * d0);
        return worldIn.clip(new ClipContext(vector3d, vector3d1, ClipContext.Block.OUTLINE, fluidMode, player));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player playerIn = context.getPlayer();
        Level worldIn = context.getLevel();
        HitResult raytraceresult = rayTrace(worldIn, playerIn, this.containedBlock == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
        BlockPos pos = new BlockPos(raytraceresult.getLocation());
        Direction facing = null;
        int i = pos.getX(), j = pos.getY(), k = pos.getZ();
        Block block = worldIn.getBlockState(new BlockPos(i, j, k)).getBlock();

        if (block == Blocks.SNOW)
            facing = Direction.DOWN;

        else {
            if (facing == Direction.UP)
                --j;
            else if (facing == Direction.DOWN)
                ++j;
            else if (facing == Direction.EAST)
                --k;
            else if (facing == Direction.WEST)
                ++k;
            else if (facing == Direction.NORTH)
                --i;
            else if (facing == Direction.SOUTH)
                ++i;
        }
        ItemStack stack = new ItemStack(this);
        if (!playerIn.mayUseItemAt(new BlockPos(i, j, k), facing, stack) || stack.getCount() == 0)
            return InteractionResult.FAIL;

        if (!worldIn.isClientSide)
            worldIn.setBlock(new BlockPos(i, j, k), Fluids.WATER.defaultFluidState().createLegacyBlock(), 3);
        if (!playerIn.isCreative())
            stack.setDamageValue(getDamage(stack) - 1);
        return InteractionResult.FAIL;

    }
}