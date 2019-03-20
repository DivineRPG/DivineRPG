package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityDeath;
import naturix.divinerpg.objects.items.base.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.DRPGSoundHandler;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class SerenadeDeath extends ItemBase {

	public SerenadeDeath(String name) {
		super(name);
		this.setCreativeTab(DRPGCreativeTabs.ranged);
		setMaxDamage(500);
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Poisons enemies for 2 seconds");
		tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
		tooltip.add(TooltipLocalizer.rangedDam(14));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {

		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		if (!world.isRemote) {
			world.playSound(entity, entity.getPosition(), DRPGSoundHandler.SERENADE, SoundCategory.MASTER, 1, 1);
			EntityThrowable bullet = new EntityDeath(world, entity);
			bullet.shoot(entity, entity.rotationPitch, entity.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(bullet);

			entity.getHeldItem(hand).damageItem(1, entity);
		}
		return ar;
	}
}