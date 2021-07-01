package divinerpg.items.vanilla;


import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;

import java.util.*;

public class ItemBurningSword extends ItemModSword {
    private int burnSeconds;

    public ItemBurningSword(IItemTier tier, String name, int seconds) {
        super(name, tier, DivineRPG.tabs.melee);
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