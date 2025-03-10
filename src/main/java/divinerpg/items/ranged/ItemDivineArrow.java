package divinerpg.items.ranged;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.api.distmarker.*;

import java.util.List;

public class ItemDivineArrow extends ArrowItem {
    public ItemDivineArrow(Properties properties) {super(properties);}
    @Override public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return bow.getEnchantmentLevel(livingEntity.registryAccess().holderOrThrow(Enchantments.INFINITY)) > 0 || (bow.getItem() instanceof ItemBow b && b.infinityArrow != null && b.infinityArrow.get() == this);
    }
    public int getBaseDamage() {return 2;}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.baseDamage(getBaseDamage()));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}