package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.teleport.SecondaryTeleporter;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.command.TextComponentHelper;
import javax.annotation.Nullable;
import java.util.List;

public class ItemTeleportationCrystal extends ItemMod {
    public ItemTeleportationCrystal() {super(new Item.Properties().durability(10));}
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide && player instanceof ServerPlayer) {
            BlockPos respawnPos = ((ServerPlayer)player).getRespawnPosition();
            if(respawnPos != null) {
                ResourceKey<Level> respawnDimension = ((ServerPlayer) player).getRespawnDimension();
                player.changeDimension(world.getServer().getLevel(respawnDimension), new SecondaryTeleporter(world.getServer().getLevel(respawnDimension)));
                ItemStack stack = player.getItemInHand(hand);
                if(!player.isCreative()) stack.hurtAndBreak(1, player, (p_220009_1_) -> p_220009_1_.broadcastBreakEvent(player.getUsedItemHand()));
                player.getCooldowns().addCooldown(stack.getItem(), 160);
                return InteractionResultHolder.success(player.getItemInHand(hand));
            } else {
                MutableComponent message = TextComponentHelper.createComponentTranslation(player, "message.teleportation_crystal_no_respawn");
                message.withStyle(ChatFormatting.RED);
                player.displayClientMessage(message, true);
            }
        } return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.teleport_respawn_point"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}