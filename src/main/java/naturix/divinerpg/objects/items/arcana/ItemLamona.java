package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLamona extends ItemMod {
	
	public ItemLamona() {
		super("lamona");
		setCreativeTab(DivineRPGTabs.utility);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());
		if(!player.capabilities.isCreativeMode) stack.shrink(1);
		if(!world.isRemote) {
		player.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1, 1);
		//FIXME - Lamona needs entity
//		EntityThrowable bullet = new EntityLamona(world, player);
//		world.spawnEntityInWorld(bullet);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {	list.add(TooltipHelper.getInfoText("tooltip.lamona.light"));
	}
}