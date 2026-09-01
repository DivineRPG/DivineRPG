package divinerpg.items.ranged;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.world.item.enchantment.Enchantments.INFINITY;

public class ItemDivineArrow extends ArrowItem {
    public ItemDivineArrow(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return bow.getEnchantmentLevel(livingEntity.registryAccess().getOrThrow(INFINITY)) > 0 || (bow.getItem() instanceof ItemBow b && b.infinityArrow != null && b.infinityArrow.get() == this);
    }
    public int getBaseDamage(){return 2;}

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(LocalizeUtils.baseDamage(getBaseDamage()));
        PotionContents potionContents = itemStack.get(POTION_CONTENTS);
        if(potionContents != null) potionContents.addToTooltip(context, builder, tooltipFlag, itemStack);
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}