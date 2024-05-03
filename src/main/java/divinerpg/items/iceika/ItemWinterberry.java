package divinerpg.items.iceika;

import divinerpg.registries.BlockRegistry;
import divinerpg.util.FoodList;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ItemWinterberry extends ItemNameBlockItem {
    public ItemWinterberry() {super(BlockRegistry.winterberryBush.get(), (new Properties()).food(FoodList.WINTERBERRY));}
    @Override public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos(), above = pos.above(), below = pos.below();
    	Direction face = context.getClickedFace();
        Player player = context.getPlayer();
        if(level.getBlockState(pos).is(BlockRegistry.brittleMoss.get()) && face.getAxis() == Direction.Axis.Y) {
        	boolean b;
        	if(b = (face == Direction.UP && level.getBlockState(above).isAir())) level.setBlockAndUpdate(above, BlockRegistry.winterberryBush.get().defaultBlockState());
        	else if(b = (face == Direction.DOWN && level.getBlockState(below).isAir())) level.setBlockAndUpdate(below, BlockRegistry.winterberryVinesHead.get().defaultBlockState());
        	if(b) {
            	if(!player.isCreative()) context.getItemInHand().shrink(1);
                level.playSound(player, pos, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS);
                return InteractionResult.SUCCESS;
        	}
        } return use(level, player, context.getHand()).getResult();
    }
}