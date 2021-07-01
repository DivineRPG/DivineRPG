package divinerpg.items.base;

import divinerpg.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemHealingSword extends ItemModSword {

    private float healAmount;

    public ItemHealingSword(String name, IItemTier material, float healAmount) {
        super(name, material, DivineRPG.tabs.melee);
        this.healAmount = healAmount;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if (!player.isCreative()) {
                stack.hurtAndBreak(2, player, (p_220044_0_) -> {
                    p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
            }
            player.heal(healAmount);
            player.playSound(SoundRegistry.HEAL, 1, 1);
        }
        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.heals",  healAmount / 2));
    }
}