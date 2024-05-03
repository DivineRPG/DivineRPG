package divinerpg.items.iceika;

import divinerpg.blocks.base.BlockModPortal;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe() {super(new Properties().stacksTo(1));}
    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        InteractionHand hand = context.getHand();
        Level worldIn = context.getLevel();
        Player player = context.getPlayer();
        RandomSource random = worldIn.random;
        ItemStack stack = player.getItemInHand(hand);
        if(!player.mayUseItemAt(pos, facing, stack)) return InteractionResult.FAIL;
        if(facing != Direction.UP) return InteractionResult.FAIL;
        BlockModPortal portal = (BlockModPortal)BlockRegistry.iceikaPortal.get();
        for(Direction direction : Direction.Plane.VERTICAL) {
            BlockPos framePos = pos.relative(direction);
            if(worldIn.getBlockState(framePos.below()) == Blocks.SNOW_BLOCK.defaultBlockState() && (worldIn.dimension().equals(LevelRegistry.ICEIKA) || worldIn.dimension().equals(Level.OVERWORLD))) {
                if(portal.makePortal(worldIn, framePos)) {
                    worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, random.nextFloat() * .4F + .8F);
                    return InteractionResult.SUCCESS;
                }
            } if(BaseFireBlock.canBePlacedAt(worldIn, pos.relative(facing), context.getHorizontalDirection()) && worldIn.getBlockState(pos).getBlock() == Blocks.SNOW_BLOCK) {
                worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, random.nextFloat() * .4F + .8F);
                worldIn.setBlock(pos.above(), BlockRegistry.iceikaFire.get().defaultBlockState(), 0);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.FAIL;
    }
}