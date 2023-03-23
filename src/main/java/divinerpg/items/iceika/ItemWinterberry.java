package divinerpg.items.iceika;

import divinerpg.registries.BlockRegistry;
import divinerpg.util.FoodList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ItemWinterberry extends ItemNameBlockItem {
    public ItemWinterberry() {
        super(BlockRegistry.winterberryBush.get(), (new Item.Properties()).food(FoodList.WINTERBERRY));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState stateAbove = level.getBlockState(pos.above());
        if (!stateAbove.isAir()) {
            if (!level.isClientSide) {
                level.setBlockAndUpdate(pos, BlockRegistry.winterberryVinesHead.get().defaultBlockState());
            }
            return InteractionResult.SUCCESS;
        } else {
            return super.useOn(context);
        }
    }
}
