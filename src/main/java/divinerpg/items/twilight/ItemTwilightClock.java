package divinerpg.items.twilight;

import divinerpg.*;
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
        super(name, new Item.Properties().group(DivineRPG.tabs.utilities).maxStackSize(1));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        BlockPos pos = context.getPos();
        Direction facing = context.getPlacementHorizontalFacing();
        ItemStack itemstack = player.getHeldItem(hand);
        World worldIn = context.getWorld();
        Random itemRand = context.getWorld().rand;
        if (!player.canPlayerEdit(pos, facing, itemstack)) {
            return ActionResultType.FAIL;
        }

        BlockPos withOffset = pos.offset(facing);

        if (!worldIn.isRemote
                && worldIn.isAirBlock(withOffset)
                && worldIn.isAirBlock(pos.up())) {

            worldIn.playSound(player, withOffset, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                    itemRand.nextFloat() * 0.4F + 0.8F);

            Block block = worldIn.getBlockState(pos).getBlock();
        //TODO - make portal from Twilight clock
        }

        return ActionResultType.FAIL;
    }
}
