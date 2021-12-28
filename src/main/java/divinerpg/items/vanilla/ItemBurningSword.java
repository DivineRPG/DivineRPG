package divinerpg.items.vanilla;


import divinerpg.DivineRPG;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public class ItemBurningSword extends ItemModSword {
    private int burnSeconds;

    public ItemBurningSword(IItemTier tier, String name, int seconds) {
        super(name, RarityList.COMMON, tier, DivineRPG.tabs.melee);
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
    protected void addAdditionalInformation(List<ITextComponent> list) {
        list.add(LocalizeUtils.burn(this.burnSeconds));
    }
}