package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import divinerpg.util.teleport.*;
import net.minecraft.*;
import net.minecraft.network.chat.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.server.command.*;

import javax.annotation.*;
import java.util.*;

public class ItemTeleportationCrystal extends ItemMod {

    public ItemTeleportationCrystal() {
        super(new Item.Properties().durability(10).tab(DivineRPG.tabs.utilities));
    }

    public ItemTeleportationCrystal(int durability) {
        super(new Item.Properties().durability(durability).tab(DivineRPG.tabs.utilities));
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
                if (((ServerPlayer) player).getRespawnPosition() != null) {
                    player.changeDimension(world.getServer().getLevel(Level.OVERWORLD), new SecondaryTeleporter(world.getServer().getLevel(Level.OVERWORLD)));
                    if (!player.isCreative()) {
                        ItemStack stack = player.getItemInHand(hand);
                        stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                    }
                    return InteractionResultHolder.success(player.getItemInHand(hand));
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
