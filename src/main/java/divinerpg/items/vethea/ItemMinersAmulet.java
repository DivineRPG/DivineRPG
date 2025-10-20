package divinerpg.items.vethea;

import divinerpg.items.base.ItemMod;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.world.effect.MobEffects.DIG_SPEED;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemMinersAmulet extends ItemMod {
    public ItemMinersAmulet() {super(new Properties().stacksTo(1).component(POTION_CONTENTS, PotionContents.EMPTY.withEffectAdded(new MobEffectInstance(DIG_SPEED, 2 * 20, 1))));}
    @Override public void inventoryTick(ItemStack stack, Level world, Entity entity, int i, boolean b) {
        Player player = (Player) entity;
        for(InteractionHand hand : InteractionHand.values()) {
            ItemStack handStack = player.getItemInHand(hand);
            if(handStack.getItem() == this) player.addEffect(new MobEffectInstance(DIG_SPEED, 2 * 20, 1, false, false));
        } super.inventoryTick(stack, world, entity, i, b);
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("item.modifiers.hand").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}