package divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.utils.TooltipHelper;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStaffEnrichment extends ItemMod {

	public ItemStaffEnrichment(String name) {
		super(name, DivineRPGTabs.tools);
		this.maxStackSize = 1;
		this.setMaxDamage(100);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {	ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());
		if (!player.canPlayerEdit(pos, facing, stack)) {
    	return EnumActionResult.FAIL;
		} else {
			Block var11 = world.getBlockState(pos).getBlock();
			Block var12 = world.getBlockState(pos.up()).getBlock();

			if(var11 == ModBlocks.arcaniteDirt) {
				Block var13 = ModBlocks.arcaniteGrass;
				player.playSound(SoundEvents.BLOCK_METAL_STEP, 0.8f, 0.8f);
				if (world.isRemote) {
					return EnumActionResult.PASS;
				} else {
					world.setBlockState(pos, var13.getDefaultState());
					stack.damageItem(1, player);
					return EnumActionResult.PASS;
				}
			}return EnumActionResult.FAIL;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {	list.add(TooltipHelper.getInfoText("tooltip.staff_of_enrichment"));
		list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
}