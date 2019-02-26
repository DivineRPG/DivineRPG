package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.ItemBase;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityVileStorm;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Vilestorm extends ItemBase {

	public Vilestorm(String name) {
		super(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TooltipLocalizer.rangedDam(4));
		tooltip.add("Poisons Enemies");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		//ItemStack stack = new ItemStack(ModItems.vileStorm);
		if (!player.capabilities.isCreativeMode) {
			//stack.shrink(1);
		}
		BlockPos pos = new BlockPos(player.getPosition());
		if (!world.isRemote) {
			world.playSound(player, pos, SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.MASTER, 1f, 1f);
			EntityThrowable bullet = new EntityVileStorm(world, player);
			bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(bullet);
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
	}
}
