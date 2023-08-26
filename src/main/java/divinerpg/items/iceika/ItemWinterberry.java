package divinerpg.items.iceika;

import divinerpg.DivineRPG;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.FoodList;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemWinterberry extends ItemNameBlockItem {
    public ItemWinterberry() {
        super(BlockRegistry.winterberryBush.get(), (new Item.Properties()).food(FoodList.WINTERBERRY));
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Block moss = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_moss"));
    	Direction face = context.getClickedFace();
        if(level.getBlockState(pos).is(moss) && face.getAxis() == Direction.Axis.Y) {
            if(!level.isClientSide) {
            	BlockPos above = pos.above(), below = pos.below();
            	if(face == Direction.UP && level.getBlockState(above).isAir()) level.setBlockAndUpdate(above, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_bush")).defaultBlockState());
            	else if(face == Direction.DOWN && level.getBlockState(below).isAir()) level.setBlockAndUpdate(below, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_head")).defaultBlockState());
            	else return use(level, context.getPlayer(), context.getHand()).getResult();
            	if(!context.getPlayer().isCreative()) context.getItemInHand().shrink(1);
            }
            level.playSound(context.getPlayer(), pos, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.PLAYERS);
            return InteractionResult.SUCCESS;
        } else return use(level, context.getPlayer(), context.getHand()).getResult();
    }
}