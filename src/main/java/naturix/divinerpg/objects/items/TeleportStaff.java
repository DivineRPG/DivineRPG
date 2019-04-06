package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.items.base.ItemMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class TeleportStaff extends ItemMod {

	protected String name;

	public TeleportStaff(String name) {
		super(name);
		this.name = name;
		// this.setCreativeTab(DivineRPG.ItemsTab);
		this.setMaxDamage(10);
		this.setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Teleports the user to the worldgen spawn");
		tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		getDefaultInstance();
		player.setPosition(world.getSpawnPoint().getX(), world.getSpawnPoint().getY(), world.getSpawnPoint().getZ());
		player.getHeldItem(hand).damageItem(1, player);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
	}

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
}