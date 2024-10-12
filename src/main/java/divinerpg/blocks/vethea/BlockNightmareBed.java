package divinerpg.blocks.vethea;

import divinerpg.block_entities.NightmareBedBlockEntity;
import divinerpg.config.CommonConfig;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;

public class BlockNightmareBed extends BedBlock {
    public BlockNightmareBed() {super(DyeColor.BLACK, Properties.of().mapColor(MapColor.COLOR_GRAY).ignitedByLava().pushReaction(PushReaction.DESTROY).strength(.2F).sound(SoundType.WOOD));}
    @Override public InteractionResult useWithoutItem(BlockState state, Level worldIn, BlockPos pos, Player player, BlockHitResult hit) {
        if(player.getInventory().isEmpty() || !CommonConfig.SAFER_VETHEA) {
        	if(!worldIn.isClientSide()) {
        		if(worldIn.getChunkSource().getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(pos) < 7 && worldIn.getChunkSource().getLightEngine().getLayerListener(LightLayer.SKY).getLightValue(pos) < 7) {
	                ((ServerPlayer) player).setRespawnPosition(worldIn.dimension(), player.blockPosition(), 0, false, false);
	                player.changeDimension(((VetheaPortal)BlockRegistry.vetheaPortal.get()).getPortalDestination((ServerLevel)worldIn, player, pos));
	            } else {
	                Component message = LocalizeUtils.clientMessage(ChatFormatting.RED, "nightmare_bed.restrict", player.getDisplayName());
	                player.displayClientMessage(message, true);
	            }
        	}
        } else {
            Component message = LocalizeUtils.clientMessage(ChatFormatting.RED, "nightmare_bed.inventory_full", player.getDisplayName());
            player.displayClientMessage(message, true);
        } return InteractionResult.CONSUME;
    }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new NightmareBedBlockEntity(pos, state);}
}