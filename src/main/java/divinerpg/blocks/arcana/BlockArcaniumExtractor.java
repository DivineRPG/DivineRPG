package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.tiles.furnace.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.inventory.container.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockArcaniumExtractor extends BlockModFurnace {
    public static final VoxelShape BLOCK_AABB = VoxelShapes.create(new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F));

    public BlockArcaniumExtractor(String name) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(60000000F).noOcclusion());
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return BLOCK_AABB;
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    protected void openContainer(World world, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof TileEntityArcaniumExtractor) {
            player.openMenu((INamedContainerProvider)tileentity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityArcaniumExtractor();
    }

    public void onRemove(BlockState state, World world, BlockPos pos, BlockState state1, boolean b) {
        if (!state.is(state1.getBlock())) {
            TileEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof TileEntityArcaniumExtractor) {
                InventoryHelper.dropContents(world, pos, (TileEntityArcaniumExtractor)tileentity);
                ((TileEntityArcaniumExtractor)tileentity).getRecipesToAwardAndPopExperience(world, Vector3d.atCenterOf(pos));
                world.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, world, pos, state1, b);
        }
    }
}
