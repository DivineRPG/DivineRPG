package naturix.divinerpg.objects.items;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySnowShuriken;
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

public class SnowShuriken extends ItemBase {
	protected float damage;

	public SnowShuriken(String name, float damage) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		this.damage = damage;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add(TooltipLocalizer.rangedDam(damage));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = new ItemStack(this.getContainerItem());
		if (!player.capabilities.isCreativeMode) {
			stack.shrink(1);
		}
		if (!world.isRemote) {
			world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.MASTER, 1f,
			        1f);
			EntitySnowShuriken shuriken = new EntitySnowShuriken(world, player);
			shuriken.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(shuriken);
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
	}
}