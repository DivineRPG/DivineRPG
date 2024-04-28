package divinerpg.items.twilight;

import divinerpg.blocks.base.BlockModPortal;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import java.io.Serial;
import java.util.*;

public class ItemTwilightClock extends ItemMod {
    private final Set<Block> possibleBlocks = new HashSet<>() {
        @Serial private static final long serialVersionUID = 1L;
        {
            add(BlockRegistry.divineRock.get());
            add(BlockRegistry.edenBlock.get());
            add(BlockRegistry.wildwoodBlock.get());
            add(BlockRegistry.apalachiaBlock.get());
            add(BlockRegistry.skythernBlock.get());
        }
    };
    public ItemTwilightClock() {super(new Item.Properties().stacksTo(1));}
    @Override public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        ItemStack itemstack = player.getItemInHand(hand);
        Level level = context.getLevel();
        RandomSource random = level.random;
        if(!player.mayUseItemAt(pos, facing, itemstack)) return InteractionResult.FAIL;
        if(facing != Direction.UP) return InteractionResult.FAIL;
        BlockModPortal portalBlock = null;
        for(Direction direction : Direction.Plane.VERTICAL) {
            BlockPos framePos = context.getClickedPos().relative(direction);
            if(level.getBlockState(framePos.below()) == BlockRegistry.divineRock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.EDEN) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal) BlockRegistry.edenPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.edenBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.WILDWOOD) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal) BlockRegistry.wildwoodPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.wildwoodBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.APALACHIA) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal) BlockRegistry.apalachiaPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.apalachiaBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.SKYTHERN) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal) BlockRegistry.skythernPortal.get();
            } else if(level.getBlockState(framePos.below()) == BlockRegistry.skythernBlock.get().defaultBlockState() && (level.dimension().equals(LevelRegistry.MORTUM) || level.dimension().equals(Level.OVERWORLD))) {
                portalBlock = (BlockModPortal) BlockRegistry.mortumPortal.get();
            } else if(BaseFireBlock.canBePlacedAt(level, pos.relative(facing), context.getHorizontalDirection()) && possibleBlocks.contains(level.getBlockState(context.getClickedPos()).getBlock())) {
                level.setBlock(context.getClickedPos().above(), BlockRegistry.blueFire.get().defaultBlockState(), 0);
                level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, random.nextFloat() * .4F + .8F);
                return InteractionResult.SUCCESS;
            } if(portalBlock.makePortal(context.getLevel(), framePos)) {
                level.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, random.nextFloat() * .4F + .8F);
                return InteractionResult.SUCCESS;
            }
        } return InteractionResult.FAIL;
    }
}