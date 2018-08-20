package naturix.divinerpg.bases.items;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class CannonBase extends ItemBase {

	public static Item block;
	public static Object instance;
	public static String name;

		public CannonBase(String name, Item ammo) {
			super(name);
			setMaxDamage(100);
			maxStackSize = 1;
			setFull3D();
			setCreativeTab(CreativeTabs.COMBAT);
			this.name=name;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack par1ItemStack) {
			return 72000;
		}

//		@Override
//		public ActionResult<ItemStack> onItemRightClick(World par2World, final EntityPlayer par3EntityPlayer, EnumHand hand) {
//			par3EntityPlayer.setActiveHand(hand);
//			ItemStack par1ItemStack = par3EntityPlayer.getHeldItem(hand);
//			boolean flag = par3EntityPlayer.capabilities.isCreativeMode
//					|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, par1ItemStack) > 0;
//			if (flag || par3EntityPlayer.inventory.hasItemStack(new ItemStack(ModItems.acid))) {
//				float f = 1.0F;
//				EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer);
//				entityarrow.shoot(par3EntityPlayer.getLookVec().x, par3EntityPlayer.getLookVec().y, par3EntityPlayer.getLookVec().z, f * 2.0F, 0);
//				entityarrow.setIsCritical(false);
//				entityarrow.setDamage(5.0);
//				entityarrow.setKnockbackStrength(5);
//				
//				par1ItemStack.damageItem(1, par3EntityPlayer);
//				int i = (int) par3EntityPlayer.posX;
//				int j = (int) par3EntityPlayer.posY;
//				int k = (int) par3EntityPlayer.posZ;
//				par2World.playSound((EntityPlayer) null, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D,
//						(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
//								.getObject(new ResourceLocation(("entity.arrow.shoot"))), SoundCategory.NEUTRAL, 1.0F, 1.0F
//								/ (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
//				if (flag) {
//					entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
//				} else {
//					par3EntityPlayer.inventory.clearMatchingItems(new ItemStack(ModItems.acid).getItem(), -1, 1, null);
//				}
//				if (!par2World.isRemote) {
//					par2World.spawnEntity(entityarrow);
//				}
//				World world = par2World;
//				EntityPlayer entity = par3EntityPlayer;
//				ItemStack itemstack = par1ItemStack;
//			}
//			return new ActionResult(EnumActionResult.SUCCESS, par1ItemStack);
//		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.BOW;
		}
	}
