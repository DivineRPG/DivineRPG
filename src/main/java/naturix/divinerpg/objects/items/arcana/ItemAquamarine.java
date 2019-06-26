package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemAquamarine extends ItemMod{

	public ItemAquamarine(String name) {
		super(name, DivineRPGTabs.utility);
		setMaxDamage(10);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		int i = pos.getX(), j=pos.getY(), k=pos.getZ();
        Block block = world.getBlockState(new BlockPos(i, j, k)).getBlock();

        if (block == Blocks.SNOW_LAYER) facing = facing.DOWN;
        
        else {
            if(facing == facing.UP) --j;

            else if(facing == facing.DOWN) ++j;

            else if(facing == facing.EAST) --k;

            else if(facing == facing.WEST) ++k;

            else if(facing == facing.NORTH) --i;

            else if(facing == facing.SOUTH) ++i;
        }
        ItemStack stack = new ItemStack(this);
        if (!player.canPlayerEdit(new BlockPos(i, j, k), facing, stack) || stack.getCount() == 0) 
            return EnumActionResult.FAIL;

        if(!world.isRemote)world.setBlockState(new BlockPos(i, j, k), Blocks.FLOWING_WATER.getDefaultState(), 3);
        if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
        return EnumActionResult.PASS;
    }
}