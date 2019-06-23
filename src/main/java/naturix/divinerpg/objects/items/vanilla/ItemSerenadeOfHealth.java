package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSerenadeOfHealth extends ItemMod {

    public ItemSerenadeOfHealth(String name) {
        super(name);
        this.setCreativeTab(DivineRPGTabs.utility);
        setMaxDamage(7);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipHelper.getInfoText("tooltip.serenade_of_health"));
        tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getHeldItem(hand);
            if (!player.capabilities.isCreativeMode) {
                stack.damageItem(1, player);
            }
            player.setHealth(player.getMaxHealth());
            player.playSound(ModSounds.HEAL, 1, 1);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        } else {
            return super.onItemRightClick(world, player, hand);
        }
    }
}