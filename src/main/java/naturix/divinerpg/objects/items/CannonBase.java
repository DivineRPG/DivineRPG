package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CannonBase extends ItemBase {
	public String name;

	public CannonBase(String name) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxStackSize(1);
		setMaxDamage(0);
		this.name = name;
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Not yet finished");
	}

	/**
	 * ItemStack stack= new ItemStack(ModItems.acid);
	 *
	 * @Override public ActionResult<ItemStack> onItemRightClick(World world,
	 *           EntityPlayer player, EnumHand handIn) { player.swingArm(handIn); if
	 *           (!world.isRemote) { if(player.inventory.hasItemStack(stack)) {
	 *           world.spawnEntity(new EntityEMP(world, player)); stack.shrink(1); }
	 *           }
	 *
	 *           DivineRPG.logger.info(stack.getDisplayName());
	 *
	 *           return new ActionResult<ItemStack>(EnumActionResult.PASS,
	 *           player.getHeldItem(handIn)); }
	 */
}