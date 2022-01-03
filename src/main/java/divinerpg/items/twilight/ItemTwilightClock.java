package divinerpg.items.twilight;

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

public class ItemTwilightClock extends ItemMod {
    private final Set<Block> possibleBlocks = new HashSet<Block>() {{
        add(BlockRegistry.divineRock);
        add(BlockRegistry.edenBlock);
        add(BlockRegistry.wildwoodBlock);
        add(BlockRegistry.apalachiaBlock);
        add(BlockRegistry.skythernBlock);
    }};

    public ItemTwilightClock(String name) {
        super(name, new Item.Properties().tab(DivineRPG.tabs.utilities).stacksTo(1));
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
                if(worldIn.getBlockState(framePos.below()) == BlockRegistry.divineRock.defaultBlockState()) {
                    ((BlockModPortal) BlockRegistry.edenPortal).makePortal(context.getLevel(), framePos);
                    return ActionResultType.CONSUME;
                }
                if(worldIn.getBlockState(framePos.below()) == BlockRegistry.edenBlock.defaultBlockState()) {
                    ((BlockModPortal) BlockRegistry.wildwoodPortal).makePortal(context.getLevel(), framePos);
                    return ActionResultType.CONSUME;
                }
                if(worldIn.getBlockState(framePos.below()) == BlockRegistry.wildwoodBlock.defaultBlockState()) {
                    ((BlockModPortal) BlockRegistry.apalachiaPortal).makePortal(context.getLevel(), framePos);
                    return ActionResultType.CONSUME;
                }
                if(worldIn.getBlockState(framePos.below()) == BlockRegistry.apalachiaBlock.defaultBlockState()) {
                    ((BlockModPortal) BlockRegistry.skythernPortal).makePortal(context.getLevel(), framePos);
                    return ActionResultType.CONSUME;
                }
                if(worldIn.getBlockState(framePos.below()) == BlockRegistry.skythernBlock.defaultBlockState()) {
                    ((BlockModPortal) BlockRegistry.mortumPortal).makePortal(context.getLevel(), framePos);
                    return ActionResultType.CONSUME;
                }
                else {
                    if(possibleBlocks.contains(worldIn.getBlockState(context.getClickedPos()).getBlock())){
                        worldIn.setBlock(context.getClickedPos().above(), BlockRegistry.blueFire.defaultBlockState(), 0);
                    }
                    return ActionResultType.FAIL;
                }
            }
        }
        return ActionResultType.FAIL;
    }

}
