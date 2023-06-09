package divinerpg.items.iceika;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModPortal;
import divinerpg.items.base.ItemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        ItemStack itemstack = player.getItemInHand(hand);
        Level worldIn = context.getLevel();
        RandomSource random = worldIn.random;

        if (!player.mayUseItemAt(pos, facing, itemstack)) {
            return InteractionResult.FAIL;
        }

        if (facing != Direction.UP) {
            return InteractionResult.FAIL;
        }

        BlockModPortal portal = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "iceika_portal"));
        for (Direction direction : Direction.Plane.VERTICAL) {
            BlockPos framePos = pos.relative(direction);
            if (worldIn.getBlockState(framePos.below()) == Blocks.SNOW_BLOCK.defaultBlockState()) {
                if (portal.makePortal(worldIn, framePos)) {
                    worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                    return InteractionResult.SUCCESS;
                }
            }
            if (BaseFireBlock.canBePlacedAt(worldIn, pos.relative(facing), context.getHorizontalDirection()) && worldIn.getBlockState(pos).getBlock() == Blocks.SNOW_BLOCK) {
                worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlock(pos.above(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "iceika_fire")).defaultBlockState(), 0);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

}
