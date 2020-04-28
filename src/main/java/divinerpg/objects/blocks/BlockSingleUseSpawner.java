package divinerpg.objects.blocks;

import java.util.Random;

import divinerpg.enums.EnumBlockType;
import divinerpg.objects.entities.entity.twilight.EntitySunstorm;
import divinerpg.objects.entities.entity.twilight.EntityTermasect;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSingleUseSpawner extends BlockMod	{
	public BlockSingleUseSpawner(String name) {
		super(EnumBlockType.IRON, name, 1);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		Entity ent = null;
		if(this==ModBlocks.sunstormSpawner) {
			ent = new EntitySunstorm(worldIn);
		}
		if(this==ModBlocks.termasectSpawner) {
			ent = new EntityTermasect(worldIn);
		}
		
		if(ent != null && !worldIn.isRemote && worldIn.getDifficulty() != EnumDifficulty.PEACEFUL) {
		ent.setLocationAndAngles(worldIn.rand.nextInt(3)+pos.getX(), pos.getY(), worldIn.rand.nextInt(3)+pos.getZ(), playerIn.rotationYaw, playerIn.rotationPitch);
		worldIn.spawnEntity(ent);
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
		return false;
    }
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.AIR;
    }
	@Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        return 15 + RANDOM.nextInt(15) + RANDOM.nextInt(15);
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return ItemStack.EMPTY;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
}
