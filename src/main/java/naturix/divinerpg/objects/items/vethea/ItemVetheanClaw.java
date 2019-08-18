package naturix.divinerpg.objects.items.vethea;

import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemVetheanClaw extends ItemVetheanSword {

    public ItemVetheanClaw(int damage, String name) {
        super(name, Utils.addHammerMaterial(damage));
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.NONE;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
		
    	return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
    }
}