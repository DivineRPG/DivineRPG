package divinerpg.items.vethea;

import divinerpg.items.base.ItemMod;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.world.effect.MobEffects.HASTE;

public class ItemMinersAmulet extends ItemMod {
    public ItemMinersAmulet(Properties properties) {super(properties.stacksTo(1).component(POTION_CONTENTS, PotionContents.EMPTY.withEffectAdded(new MobEffectInstance(HASTE, 2 * 20, 1))));}

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        Player player = (Player) owner;
        for(InteractionHand hand : InteractionHand.values()) {
            ItemStack handStack = player.getItemInHand(hand);
            if(handStack.getItem() == this) player.addEffect(new MobEffectInstance(HASTE, 2 * 20, 1, false, false));
        } super.inventoryTick(stack, level, owner, slot);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(Component.translatable("item.modifiers.hand").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }

}