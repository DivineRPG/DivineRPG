package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.objects.entities.entity.arcana.Dramix;
import naturix.divinerpg.objects.entities.entity.arcana.Parasecta;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemWizardsBook extends ItemMod {

	public ItemWizardsBook(String name) {
		super(name, DivineRPGTabs.spawner);
		setMaxStackSize(1);
	} 

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		int x=pos.getX(), y=pos.getY(), z=pos.getZ();
		ItemStack stack = new ItemStack(player.getHeldItem(hand).getItem());
        Parasecta parasecta = new Parasecta(world, player);
		Dramix dramix = new Dramix(world, player);
		Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
		RayTraceResult rtr = player.rayTrace(4, 1);
		int x2 = rtr.getBlockPos().getX(), y2 = rtr.getBlockPos().getY(), z2 = rtr.getBlockPos().getZ();
		if(!world.isRemote){
			if(block == ModBlocks.parasectaAltar){
				parasecta.setLocationAndAngles(x2 + 0.5F, y2 + 1, z2 + 0.5F, 0.0F, 0.0F);
				    world.spawnEntity(parasecta);
				    if(!player.capabilities.isCreativeMode) stack.shrink(1);
				return EnumActionResult.PASS;
			} 

			if(block == ModBlocks.dramixAltar){
				dramix.setLocationAndAngles(x2 + 0.5F, y2 + 1, z2 + 0.5F, 0.0F, 0.0F);
				    world.spawnEntity(dramix);
				    if(!player.capabilities.isCreativeMode) stack.shrink(1);
				return EnumActionResult.PASS;
			}
		}return EnumActionResult.FAIL;
	}
}