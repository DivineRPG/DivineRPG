package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import java.util.function.Consumer;

public class ItemTeleportationCrystal extends ItemMod {
    public ItemTeleportationCrystal(Properties properties) {super(properties.stacksTo(1).durability(10));}

    @Override public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(!world.isClientSide() && player instanceof ServerPlayer s) {
            BlockPos respawnPos = s.getRespawnConfig().respawnData().pos();
            if(respawnPos != null) {
                if(!player.isCreative()) stack.hurtAndBreak(1, player, hand);
                player.getCooldowns().addCooldown(stack, 160);
                player.awardStat(Stats.ITEM_USED.get(this));
                //TODO - dimension change/transition
//                player.changeDimension(s.findRespawnPositionAndUseSpawnBlock(true, DimensionTransition.PLAY_PORTAL_SOUND));
                return InteractionResult.SUCCESS;
            } else {
                Component message = LocalizeUtils.clientMessage(ChatFormatting.RED, "teleport.no_respawn");
                player.sendSystemMessage(message);
                return InteractionResult.FAIL;
            }
        } return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.i18n("teleport.respawn_point"));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }

}