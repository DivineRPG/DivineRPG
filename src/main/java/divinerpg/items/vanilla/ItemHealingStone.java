package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemHealingStone extends ItemMod {
    private float healAmount;

    public ItemHealingStone(String name, float healAmount) {
        this(name, healAmount, DivineRPG.tabs.materials);
    }

    public ItemHealingStone(String name, float healAmount, ItemGroup tab) {
        super(name, tab);
        this.healAmount = healAmount;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (healAmount != 0 && player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getItemInHand(hand);
            if (!player.isCreative()) {
                stack.shrink(1);
            }
            player.heal(healAmount);
            return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
        } else {
            return super.use(world, player, hand);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("Heals " + this.healAmount / 2 + " hearts on use"));
    }
}