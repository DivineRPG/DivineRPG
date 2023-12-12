package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.teleport.SecondaryTeleporter;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.command.TextComponentHelper;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTeleportationCrystal extends ItemMod {

    public ItemTeleportationCrystal() {
        super(new Item.Properties().durability(10));
    }

    public ItemTeleportationCrystal(int durability) {
        super(new Item.Properties().durability(durability));
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.teleport_bed_spawn"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) {
            if (player instanceof ServerPlayer) {
                BlockPos respawnPos = ((ServerPlayer) player).getRespawnPosition();
                if (respawnPos != null) {
                    ResourceKey<Level> respawnDimension = ((ServerPlayer) player).getRespawnDimension();
                    ServerLevel respawnWorld = world.getServer().getLevel(respawnDimension);

                    if (respawnWorld != null) {
                        player.changeDimension(respawnWorld, new SecondaryTeleporter(respawnWorld, respawnPos));

                        if (!player.isCreative()) {
                            ItemStack stack = player.getItemInHand(hand);
                            stack.hurtAndBreak(1, player, (player1) -> {
                                player1.broadcastBreakEvent(player.getUsedItemHand());
                            });
                        }

                        return InteractionResultHolder.success(player.getItemInHand(hand));
                    } else {
                        MutableComponent message = TextComponentHelper.createComponentTranslation(player, "message.teleportation_crystal_no_respawn_dimension");
                        message.withStyle(ChatFormatting.RED);
                        player.displayClientMessage(message, true);
                    }
                } else {
                    MutableComponent message = TextComponentHelper.createComponentTranslation(player, "message.teleportation_crystal_no_respawn");
                    message.withStyle(ChatFormatting.RED);
                    player.displayClientMessage(message, true);
                }
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}
