package divinerpg.items.iceika;

import divinerpg.*;
import divinerpg.items.base.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe() {
        super("snow_globe", new Properties().tab(DivineRPG.tabs.utilities).stacksTo(1));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        BlockPos pos = context.getClickedPos();
        Vector3i facing = new Vector3i(context.getClickLocation().x, context.getClickLocation().y, context.getClickLocation().z);
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        World worldIn = context.getLevel();


        pos = pos.offset(facing);
        if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(worldIn, player)) {
            return ActionResultType.FAIL;
        }

        if (worldIn.isEmptyBlock(pos)) {
            worldIn.playSound(player, pos, SoundEvents.SNOW_STEP, SoundCategory.BLOCKS, 1.0F,
                    random.nextFloat() * 0.4F + 0.8F);

            Block snow = Blocks.SNOW;


            //TODO - Iceika portal item
//            if (worldIn.getBlockState(pos.below()).getBlock() == snow) {
//                IPortalDescription description = DimensionHelper.descriptionsByBlock.get(snow);
//                if (description != null) {
//                    BlockPattern.PatternHelper match = description.matchFrame(worldIn, pos.down());
//                    if (match != null) {
//                        description.lightPortal(worldIn, match);
//                    }
//                }
//            }
        }
        return super.useOn(context);
    }
}
