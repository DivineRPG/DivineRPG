package divinerpg.items.iceika;

import divinerpg.*;
import divinerpg.blocks.base.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe() {
        super("snow_globe", new Properties().tab(DivineRPG.tabs.utilities).stacksTo(1));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        ItemStack itemstack = player.getItemInHand(hand);
        World worldIn = context.getLevel();
        Random random = context.getLevel().random;

        if (!player.mayUseItemAt(pos, facing, itemstack)) {
            return ActionResultType.FAIL;
        }

        if(facing != Direction.UP) {
            return ActionResultType.FAIL;
        }

        if (!worldIn.isClientSide) {
            worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                    random.nextFloat() * 0.4F + 0.8F);

            for(Direction direction : Direction.Plane.VERTICAL) {
                BlockPos framePos = context.getClickedPos().relative(direction);
                if(worldIn.getBlockState(framePos.below()) == Blocks.SNOW_BLOCK.defaultBlockState()) {
                    if (((BlockModPortal) BlockRegistry.iceikaPortal).makePortal(context.getLevel(), framePos)) {
                        return ActionResultType.CONSUME;
                    }
                }
                else {
                    if(worldIn.getBlockState(context.getClickedPos()).getBlock() == Blocks.SNOW_BLOCK){
                        worldIn.setBlock(context.getClickedPos().above(), BlockRegistry.iceikaFire.defaultBlockState(), 0);
                    }
                    return ActionResultType.FAIL;
                }
            }
        }
        return ActionResultType.FAIL;
    }

}
