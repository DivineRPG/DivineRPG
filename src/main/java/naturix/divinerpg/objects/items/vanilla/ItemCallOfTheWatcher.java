package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.entities.entity.vanilla.TheWatcher;
import naturix.divinerpg.objects.items.base.ItemBase;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemCallOfTheWatcher extends ItemBase {

	public ItemCallOfTheWatcher(String name) {
		super(name);
		this.setMaxDamage(1);
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPGCreativeTabs.spawner);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		BlockPos pos = new BlockPos(playerIn);
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.shrink(1);
		}

		worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ,
		        SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote && worldIn.provider.getDimension() == -1) {
			TheWatcher entityegg = new TheWatcher(worldIn);
			entityegg.setPositionAndRotation(pos.getX() + 0.5D, (double) pos.getY() + 1, pos.getZ(),
			        playerIn.rotationYaw, playerIn.rotationPitch);
			worldIn.spawnEntity(entityegg);
		}

		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}
