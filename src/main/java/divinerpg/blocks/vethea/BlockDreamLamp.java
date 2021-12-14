package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import divinerpg.tiles.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockDreamLamp extends BlockMod implements ITileEntityProvider {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public BlockDreamLamp(String name) {
        super(name, 3.0F, 3.0F, Material.BUILDABLE_GLASS);
        this.registerDefaultState(this.getStateDefinition().any().setValue(POWERED, false));
    }


    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(POWERED, false);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        if(state.getValue(POWERED)){
            return 15;
        }
        return 0;
    }

    public void setOn(World worldIn, BlockPos pos) {
        worldIn.setBlock(pos, worldIn.getBlockState(pos).setValue(POWERED, true), 2);
    }

    public void setOff(World worldIn, BlockPos pos) {
        worldIn.setBlock(pos, worldIn.getBlockState(pos).setValue(POWERED, false), 2);
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new TileEntityDreamLamp();
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(!world.isClientSide){
            TileEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof TileEntityDreamLamp) {
                playerEntity.openMenu((TileEntityDreamLamp) tileentity);
            }
        }
        return super.use(state, world, pos, playerEntity, hand, result);
    }

}
