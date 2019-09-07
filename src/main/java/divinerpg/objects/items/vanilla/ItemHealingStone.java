package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemHealingStone extends ItemMod {
    private float healAmount;

    public ItemHealingStone(String name, float healAmount) {
        this(name, healAmount, DivineRPGTabs.items);
    }

    public ItemHealingStone(String name, float healAmount, CreativeTabs tab) {
        super(name, tab);
        this.healAmount = healAmount;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (healAmount != 0 && player.getHealth() < player.getMaxHealth()) {
            ItemStack stack = player.getHeldItem(hand);
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }
            player.heal(healAmount);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        } else {
            return super.onItemRightClick(world, player, hand);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add("Heals " + this.healAmount / 2 + " hearts on use");
    }
}
