package divinerpg.items.ranged;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ItemDivineArrow extends ArrowItem {
    public ItemDivineArrow(Properties properties) {
        super(properties);
    }
    public boolean isInfinite(ItemStack ammo, ItemStack bow, LivingEntity livingEntity) {
        return bow.getItem() instanceof ItemBow b && b.infinityArrow != null && b.infinityArrow.get() == this;
    }
    public float getBaseDamage() {return 2F;}
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(LocalizeUtils.baseDamage(getBaseDamage()));
    }
}