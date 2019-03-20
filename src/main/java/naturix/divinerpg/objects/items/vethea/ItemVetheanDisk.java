package naturix.divinerpg.objects.items.vethea;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVetheanDisk extends ItemBase {

	public int damage;

	public ItemVetheanDisk(int par1, String name) {
		super(name);
		this.maxStackSize = 1;
		this.damage = par1;
		this.setCreativeTab(DRPGCreativeTabs.ranged);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add(TooltipLocalizer.rangedDam(damage));
		list.add("Returns to sender");
		list.add(TooltipLocalizer.vethean());
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World par2, EntityPlayer par3, EnumHand handIn) {
		ItemStack par1 = new ItemStack(this);
		if (!par3.capabilities.isCreativeMode) {
			par1.shrink(1);
		}

		par2.playSound(par3, par3.getPosition(), SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, SoundCategory.PLAYERS, 0.5F,
		        0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!par2.isRemote) {
			shoot(par1, par2, par3);
		}

		return new ActionResult<ItemStack>(EnumActionResult.PASS, par3.getHeldItem(handIn));
	}

	protected void shoot(ItemStack stack, World par2, EntityPlayer par3) {
	}
}