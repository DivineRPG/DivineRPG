package divinerpg.objects.blocks.vethea;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.objects.blocks.BlockModUnbreakable;
import divinerpg.registry.BlockRegistry;
import divinerpg.utils.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockKarosHeatTile extends BlockModUnbreakable {
    private static final AxisAlignedBB KAROS_HEAT_TILE_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D,
            0.9375D);

    public BlockKarosHeatTile(String name) {
        super(name);
        this.setTickRandomly(true);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
                                      List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, KAROS_HEAT_TILE_AABB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return KAROS_HEAT_TILE_AABB;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (this == BlockRegistry.karosHeatTileRed) {
            world.setBlockState(pos, BlockRegistry.karosHeatTileGreen.getDefaultState());
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollidedWithBlock(world, pos, state, entityIn);
        if (this == BlockRegistry.karosHeatTileRed && entityIn instanceof EntityPlayerMP) {
            entityIn.attackEntityFrom(Utils.trapSource, 6);
            entityIn.setFire(5);
        }
    }
}