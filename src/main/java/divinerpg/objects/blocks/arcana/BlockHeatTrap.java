package divinerpg.objects.blocks.arcana;

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

public class BlockHeatTrap extends BlockModUnbreakable {
     private static final AxisAlignedBB HEAT_TRAP_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D,
            0.9375D);

    public BlockHeatTrap(String name) {
        super(name);
        this.setTickRandomly(true);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
            List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, HEAT_TRAP_AABB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return HEAT_TRAP_AABB;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if (this == BlockRegistry.heatTrapOn) {
            world.setBlockState(pos, BlockRegistry.heatTrap.getDefaultState());
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entityIn) {
        super.onEntityCollidedWithBlock(world, pos, state, entityIn);
        if (this == BlockRegistry.heatTrap) {
            world.setBlockState(pos, BlockRegistry.heatTrapOn.getDefaultState());
        }

        if (this == BlockRegistry.heatTrapOn && entityIn instanceof EntityPlayerMP) {
            entityIn.attackEntityFrom(Utils.trapSource, 16);
            entityIn.setFire(15);
        }
    }
}