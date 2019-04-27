package naturix.divinerpg.objects.items.twilight;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class ItemTwilightSeeds extends ItemSeeds {
    private Block grass, crop;
    public ItemTwilightSeeds(String name, Block block, Block grass) {
        super(block, grass);
        this.grass=grass;
        this.crop = block;
        setUnlocalizedName(name);
        setRegistryName(name);
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Plains;
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {    
        ItemStack itemstack = player.getHeldItem(hand);
    net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
    if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
    {
        worldIn.setBlockState(pos.up(), this.crop.getDefaultState());

        itemstack.shrink(1);
        return EnumActionResult.SUCCESS;
    }
    else
    {
        return EnumActionResult.FAIL;
    }
    }
}