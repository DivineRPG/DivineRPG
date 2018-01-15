package naturix.divinerpg.bases.clock;

import naturix.divinerpg.Divine;
import naturix.divinerpg.bases.PortalBase;
import naturix.divinerpg.dimensions.base.PortalHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysteriousClock extends Item {

			protected String name;

			public MysteriousClock(String name) {
				this.name = name;
				setUnlocalizedName(name);
				setRegistryName(name);
				this.setCreativeTab(Divine.ItemsTab);
			}
			
			public void registerItemModel() {
				Divine.proxy.registerItemRenderer(this, 0, name);
			}
			@Override
			public EnumActionResult onItemUse(EntityPlayer par2EntityPlayer, World par3World, BlockPos pos, EnumHand hand, EnumFacing side, float par8,
					float par9, float par10) {

				ItemStack par1ItemStack = par2EntityPlayer.getHeldItem(hand);

				int par4 = pos.getX();
				int par5 = pos.getY();
				int par6 = pos.getZ();

				int par7 = side.getIndex();

				if (par7 == 0) {
					par5--;
				}
				if (par7 == 1) {
					par5++;
				}
				if (par7 == 2) {
					par6--;
				}
				if (par7 == 3) {
					par6++;
				}
				if (par7 == 4) {
					par4--;
				}
				if (par7 == 5) {
					par4++;
				}
				if (!par2EntityPlayer.canPlayerEdit(new BlockPos(par4, par5, par6), side, par1ItemStack)) {
					return EnumActionResult.FAIL;
				}
				Block i1 = PortalBase.getBlock(par3World, par4, par5, par6);
				if (i1 == Blocks.AIR) {
					par3World.playSound(par2EntityPlayer, new BlockPos(par4, par5, par6), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
							itemRand.nextFloat() * 0.4F + 0.8F);
					PortalHelper.tryToCreatePortal(par3World, par4, par5, par6);
				}
				par1ItemStack.damageItem(1, par2EntityPlayer);
				return EnumActionResult.SUCCESS;
			}
}
