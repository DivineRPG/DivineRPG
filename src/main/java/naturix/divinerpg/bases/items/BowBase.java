package naturix.divinerpg.bases.items;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.arrows.InfernoArrow;
import naturix.divinerpg.entities.entity.projectiles.EntityInfernoArrow;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BowBase extends ItemBow  {

	protected String repairIngot = "";
	public String name;
	protected ToolMaterial toolMaterial;

	protected float arrowDamageMultiplier = 0.0F;
	protected float arrowSpeedMultiplier = 0.0F;
	protected float zoomMultiplier = 0.15F;

	protected boolean showInCreative = true;

	public BowBase(String name) {

		this.name = name;
		setMaxStackSize(1);
//		setMaxDamage(toolMaterial.getMaxUses() + 325);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
			@SideOnly (Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

				if (entityIn == null) {
					return 0.0F;
				} else {
					ItemStack itemstack = entityIn.getActiveItemStack();
					return !itemstack.isEmpty() && itemstack.getItem() instanceof BowBase ? (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
				}
			}
		});
		addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {
			@SideOnly (Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
			}
		});
	}

	public BowBase setRepairIngot(String repairIngot) {

		this.repairIngot = repairIngot;
		return this;
	}

	public BowBase setArrowDamage(float multiplier) {

		arrowDamageMultiplier = multiplier;
		return this;
	}

	public BowBase setArrowSpeed(float multiplier) {

		this.arrowSpeedMultiplier = multiplier;
		return this;
	}

	public BowBase setZoomMultiplier(float multiplier) {

		this.zoomMultiplier = multiplier;
		return this;
	}

	public BowBase setShowInCreative(boolean showInCreative) {

		this.showInCreative = showInCreative;
		return this;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {

		if (isInCreativeTab(tab) && showInCreative) {
			items.add(new ItemStack(this, 1, 0));
		}
	}

	@Override
	public boolean isEnchantable(ItemStack stack) {

		return true;
	}

	@Override
	public int getItemEnchantability(ItemStack stack) {

		return toolMaterial.getEnchantability();
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

		ItemStack stack = player.getHeldItem(hand);
		boolean flag = !this.findAmmo(player).isEmpty();

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(stack, world, player, hand, flag);
		if (ret != null) {
			return ret;
		}
		if (!player.capabilities.isCreativeMode && !flag) {
			return !flag ? new ActionResult<>(EnumActionResult.FAIL, stack) : new ActionResult<>(EnumActionResult.PASS, stack);
		} else {
			player.setActiveHand(hand);
			return new ActionResult<>(EnumActionResult.SUCCESS, stack);
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase livingBase, int timeLeft) {

		if (livingBase instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) livingBase;
			ItemStack arrowStack = this.findAmmo(player);
			boolean flag = player.capabilities.isCreativeMode || (arrowStack.getItem() instanceof ItemArrow && ((ItemArrow) arrowStack.getItem()).isInfinite(arrowStack, stack, player));

			int charge = this.getMaxItemUseDuration(stack) - timeLeft;
			charge = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, world, (EntityPlayer) livingBase, charge, !arrowStack.isEmpty() || flag);
			if (charge < 0) {
				return;
			}
			if (!arrowStack.isEmpty() || flag) {
				if (arrowStack.isEmpty()) {
					arrowStack = new ItemStack(Items.ARROW);
				}
				float f = getArrowVelocity(charge);
				float speedMod = 1.0F + arrowSpeedMultiplier;

				if ((double) f >= 0.1D) {
					if (!world.isRemote) {
						int encPunch = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						int encPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
						boolean encFlame = EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0;

						InfernoArrow arrowItem = (InfernoArrow) (arrowStack.getItem() instanceof InfernoArrow ? arrowStack.getItem() : ModItems.arrowInferno);

						
							EntityInfernoArrow arrow = arrowItem.createArrow(world, arrowStack, player);
							arrow.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, f * 3.0F * speedMod, 1.0F + (1.5F - f));
							arrow.setDamage(arrow.getDamage() * (1 + arrowDamageMultiplier));

							if (f >= 1.0F) {
								arrow.setIsCritical(true);
							}
							if (encPower > 0) {
								arrow.setDamage(arrow.getDamage() + (double) encPower * 0.5D + 0.5D);
							}
							if (encPunch > 0) {
								arrow.setKnockbackStrength(encPunch);
							}
							if (encFlame) {
								arrow.setFire(100);
							}
							
							world.spawnEntity(arrow);
						}
						stack.damageItem(1, player);
					}
					world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

					if (!flag) {
						arrowStack.shrink(1);

						if (arrowStack.getCount() == 0) {
							player.inventory.deleteStack(arrowStack);
						}
					}
					player.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
	private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }
	protected boolean isArrow(ItemStack stack)
    {
		boolean isInfernal = false;
			if(this==ModItems.infernoBow) {
				isInfernal=true;
			}

        return isInfernal;
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
