package divinerpg.objects.blocks.vethea;

import divinerpg.objects.blocks.BlockMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAcid extends BlockMod {

    protected static final AxisAlignedBB acidBoundingBox = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    protected boolean decays;
    protected boolean poison;

    public BlockAcid(String name, boolean decays) {
        this(name, decays, false);
    }

    public BlockAcid(String name, boolean decays, boolean poison) {
        super(name, 0.1F, Material.SNOW, DivineRPGTabs.vethea);
        this.setTickRandomly(true);
        this.decays = decays;
        this.poison = poison;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return acidBoundingBox;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        if (!(world.getBlockState(pos).getBlock() == Blocks.AIR)) {
            return false;
        } else {
            IBlockState blockState = world.getBlockState(pos.add(0, -1, 0));
            return blockState.isFullBlock();
        }
    }

    @Override
    public int tickRate(World par1World) {
        return 160;
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random) {
        par1World.setBlockToAir(pos);
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if(entityIn instanceof EntityPlayer) {
            entityIn.attackEntityFrom(Utils.acidSource, 3);
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}