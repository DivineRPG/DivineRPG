package divinerpg.items.ranged;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.world.item.enchantment.Enchantments.INFINITY;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemDivineArrow extends ArrowItem {
    public ItemDivineArrow(Properties properties) {super(properties);}
    @Override public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return bow.getEnchantmentLevel(livingEntity.registryAccess().holderOrThrow(INFINITY)) > 0 || (bow.getItem() instanceof ItemBow b && b.infinityArrow != null && b.infinityArrow.get() == this);
    }
    public int getBaseDamage() {return 2;}
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.baseDamage(getBaseDamage()));
        PotionContents potioncontents = stack.get(POTION_CONTENTS);
        if(potioncontents != null) potioncontents.addPotionTooltip(tooltip::add, 1, context.tickRate());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}