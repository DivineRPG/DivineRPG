package naturix.divinerpg.bases.items;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.arrows.InfernoArrow;
import naturix.divinerpg.entities.entity.projectiles.EntityInfernoArrow;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class BowBase extends ItemBow
{
	String name;
    public BowBase(String name)
    {
    	this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.CombatTab);
    }
    private ItemStack getAmmo(EntityPlayer player) {
		if(isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
			return player.getHeldItem(EnumHand.OFF_HAND);
		else if(isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
			return player.getHeldItem(EnumHand.MAIN_HAND);
		else for(int i = 0; i < player.inventory.getSizeInventory(); ++i) {
			ItemStack itemstack = player.inventory.getStackInSlot(i);

			if (isArrow(itemstack))
				return itemstack;
		}

		return ItemStack.EMPTY;
	}
    @Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, EntityPlayer player, @Nonnull EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		// Copy from superclass with our own check
		ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(stack, world, player, hand, true);
		if (ret != null) return ret;

		if (!player.capabilities.isCreativeMode)
		{
			return new ActionResult<>(EnumActionResult.FAIL, stack);
		}
		else
		{
			player.setActiveHand(hand);
			return new ActionResult<>(EnumActionResult.SUCCESS, stack);
		}
	}

	@Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase shooter, int useTicks) {
		EntityPlayer player = (EntityPlayer) shooter;

		ItemStack itemstack = getAmmo(player);

		int i = (int) ((getMaxItemUseDuration(stack) - useTicks) );
		i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, world, player, i, !itemstack.isEmpty());
		if (i < 0) return;

		if (!itemstack.isEmpty())
		{
			if (itemstack.isEmpty())
			{
				itemstack = new ItemStack(ModItems.arrowInferno);
			}
		}
			float f = getArrowVelocity(i);


				if (!world.isRemote)
				{
					InfernoArrow itemarrow = (InfernoArrow) (itemstack.getItem() instanceof InfernoArrow ? itemstack.getItem() : ModItems.arrowInferno);
					EntityInfernoArrow entityarrow = itemarrow.createArrow(world, itemstack, shooter);
					
					entityarrow.shoot(shooter, shooter.rotationPitch, shooter.rotationYaw, 0.0F, f * 3.0F, 1.0F);
					   
					if (f == 1.0F)
					{
						entityarrow.setIsCritical(true);
					}

					world.spawnEntity(entityarrow);
					DivineRPG.logger.info(shooter.getName() + " just shot an arrow with the pitch "+shooter.rotationPitch+" and the yaw of "+shooter.rotationYaw);

				world.playSound(null, shooter.posX, shooter.posY, shooter.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

				player.addStat(StatList.getObjectUseStats(this));
			}
		}
	
	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add("Not yet finished");
    }
}
