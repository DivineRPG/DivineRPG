package divinerpg.items.iceika;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModPortal;
import divinerpg.items.base.ItemMod;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe() {
        super(new Properties().tab(DivineRPG.tabs.utilities).stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        ItemStack itemstack = player.getItemInHand(hand);
        Level worldIn = context.getLevel();
        RandomSource random = context.getLevel().random;

        if (!player.mayUseItemAt(pos, facing, itemstack)) {
            return InteractionResult.FAIL;
        }

        if (facing != Direction.UP) {
            return InteractionResult.FAIL;
        }

        if (!worldIn.isClientSide) {
            worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F,
                    random.nextFloat() * 0.4F + 0.8F);
            BlockModPortal portal = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "iceika_portal"));
            for (Direction direction : Direction.Plane.VERTICAL) {
                BlockPos framePos = context.getClickedPos().relative(direction);
                if (worldIn.getBlockState(framePos.below()) == Blocks.SNOW_BLOCK.defaultBlockState()) {
                    if (portal.makePortal(context.getLevel(), framePos)) {
                        return InteractionResult.CONSUME;
                    }
                } else {
                    if (worldIn.getBlockState(context.getClickedPos()).getBlock() == Blocks.SNOW_BLOCK) {
                        worldIn.setBlock(context.getClickedPos().above(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "iceika_fire")).defaultBlockState(), 0);
                    }
                    return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }

}
