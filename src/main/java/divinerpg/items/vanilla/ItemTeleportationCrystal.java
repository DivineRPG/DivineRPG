package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.teleport.SecondaryTeleporter;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.server.command.TextComponentHelper;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTeleportationCrystal extends ItemMod {

    public ItemTeleportationCrystal() {
        super("teleportation_crystal", new Item.Properties().durability(10).tab(DivineRPG.tabs.utilities));
    }

    public ItemTeleportationCrystal(String name, int durability) {
        super(name, new Item.Properties().durability(durability).tab(DivineRPG.tabs.utilities));
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.teleport_bed_spawn"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }


    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            if (player instanceof ServerPlayerEntity) {
                if (((ServerPlayerEntity) player).getRespawnPosition() != null) {
                    player.changeDimension(world.getServer().getLevel(World.OVERWORLD), new SecondaryTeleporter(world.getServer().getLevel(World.OVERWORLD)));
                    if (!player.isCreative()) {
                        ItemStack stack = player.getItemInHand(hand);
                        stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                            p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                    }
                    return ActionResult.success(player.getItemInHand(hand));
                } else {
                    TextComponent message = TextComponentHelper.createComponentTranslation(player, "message.teleportation_crystal_no_respawn");
                    message.withStyle(TextFormatting.RED);
                    player.sendMessage(message, player.getUUID());
                }
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }
}
