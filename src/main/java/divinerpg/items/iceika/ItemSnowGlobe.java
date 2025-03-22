package divinerpg.items.iceika;

import divinerpg.blocks.base.PortalBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.api.distmarker.*;

import java.util.List;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe() {super(new Properties().stacksTo(1));}
    @Override public InteractionResult useOn(UseOnContext context) {
        Direction facing = context.getClickedFace();
        BlockPos pos = context.getClickedPos();
        Level worldIn = context.getLevel();
        Player player = context.getPlayer();
        if(!player.mayUseItemAt(pos, facing, player.getItemInHand(context.getHand()))) return InteractionResult.FAIL;
        BlockState block = worldIn.getBlockState(pos);
        if(!block.is(BlockRegistry.icyFire)) return InteractionResult.FAIL;
        if(!worldIn.isClientSide()) {
            PortalBlock portal = (PortalBlock)BlockRegistry.iceikaPortal.get();
            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
            Axis axis = portal.checkForFrame(worldIn, pos);
            if(axis != null) {
                PortalBlock.spreadBlock(worldIn, portal.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, axis), pos, Blocks.AIR, axis);
                worldIn.playSound(null, pos, SoundRegistry.ICEIKA_PORTAL_TRIGGER.get(), SoundSource.BLOCKS, 1, 1);
                return InteractionResult.SUCCESS;
            } else worldIn.setBlock(pos, block, Block.UPDATE_NONE);
        } return InteractionResult.CONSUME;
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("snow_globe"));
    }
}