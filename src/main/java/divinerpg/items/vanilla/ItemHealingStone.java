package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

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
        tooltip.add(LocalizeUtils.i18n("tooltip.heals",  healAmount / 2));
    }
}