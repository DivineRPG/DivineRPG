package divinerpg.items.vanilla;


import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;

public class ItemBurningSword extends ItemModSword {
    private final int burnSeconds;

    public ItemBurningSword(Tier tier, int seconds) {
        super(tier, new Item.Properties().fireResistant());
        this.burnSeconds = seconds;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity livingBase1, LivingEntity livingBase2) {
        stack.hurtAndBreak(1, livingBase1, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingBase1.getUsedItemHand());
        });
        livingBase1.setSecondsOnFire(this.burnSeconds);
        return true;
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        super.inventoryTick(stack, level, entity, p_41407_, p_41408_);
        if (!stack.isEnchanted()) {
            stack.enchant(Enchantments.FIRE_ASPECT, 1);
        }
    }

    @Override
    protected void addAdditionalInformation(List<Component> list) {
        list.add(LocalizeUtils.burn(this.burnSeconds));
    }
}