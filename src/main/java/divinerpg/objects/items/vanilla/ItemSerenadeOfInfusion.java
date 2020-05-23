package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSerenadeOfInfusion extends ItemMod {

    public ItemSerenadeOfInfusion(String name) {
        super(name);
        this.setCreativeTab(DivineRPGTabs.utility);
        setMaxDamage(15);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_infusion"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (!player.capabilities.isCreativeMode) {
            stack.damageItem(1, player);
        }
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 2, true, false));
        player.playSound(SoundRegistry.HEAL, 1, 1);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}