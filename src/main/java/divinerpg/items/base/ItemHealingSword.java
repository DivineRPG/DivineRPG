package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemHealingSword extends ItemModSword {

    private float healAmount;

    public ItemHealingSword(String name, IItemTier material, float healAmount) {
        super(name, RarityList.COMMON, material, DivineRPG.tabs.melee);
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