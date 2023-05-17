package divinerpg.blocks.vethea;

import divinerpg.registries.LevelRegistry;
import divinerpg.block_entities.NightmareBedBlockEntity;
import divinerpg.util.teleport.VetheaTeleporter;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.server.command.TextComponentHelper;

public class BlockNightmareBed extends BedBlock {

    public BlockNightmareBed() {
        super(DyeColor.BLACK, Properties.of(Material.CLOTH_DECORATION, MaterialColor.COLOR_GRAY).strength(0.2F, 0.2F).sound(SoundType.STONE));
    }

    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if(!worldIn.isClientSide && player.getUsedItemHand() == handIn) {
            if(worldIn.dimension() == Level.OVERWORLD) {
                if(worldIn.getChunkSource().getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(pos) < 7
                        && worldIn.getChunkSource().getLightEngine().getLayerListener(LightLayer.SKY).getLightValue(pos) < 7) {
                	((ServerPlayer) player).setRespawnPosition(worldIn.dimension(), player.blockPosition(), 0F, false, false);
                    player.changeDimension(player.getServer().getLevel(LevelRegistry.VETHEA), new VetheaTeleporter(false));
                } else {
                    MutableComponent message = TextComponentHelper.createComponentTranslation(player, "message.nightmare_bed.restrict", player.getDisplayName());
                    message.withStyle(ChatFormatting.RED);
                    player.displayClientMessage(message, true);
                }
            } else {
                MutableComponent message = TextComponentHelper.createComponentTranslation(player, "message.nightmare_bed.overworld_only", player.getDisplayName());
                message.withStyle(ChatFormatting.RED);
                player.displayClientMessage(message, true);
            }
        }
        return InteractionResult.CONSUME;
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NightmareBedBlockEntity(pos, state);
    }
}