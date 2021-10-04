package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import divinerpg.tiles.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.fluid.*;
import net.minecraft.inventory.container.*;
import net.minecraft.item.*;
import net.minecraft.state.*;
import net.minecraft.state.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;

public class BlockDreamLamp extends BlockMod implements ITileEntityProvider {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public BlockDreamLamp(String name) {
        super(name, 3.0F, 3.0F, Material.BUILDABLE_GLASS);
        this.registerDefaultState(this.getStateDefinition().any().setValue(POWERED, false));
    }


    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(POWERED, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos())));
    }

    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos pos2, boolean p_220069_6_) {
        if (!world.isClientSide) {
            boolean flag = state.getValue(POWERED);
            if (flag != world.hasNeighborSignal(pos)) {
                if (flag) {
                    world.getBlockTicks().scheduleTick(pos, this, 4);
                } else {
                    world.setBlock(pos, state.cycle(POWERED), 2);
                }
            }

        }
    }

    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.getValue(POWERED) && !world.hasNeighborSignal(pos)) {
            world.setBlock(pos, state.cycle(POWERED), 2);
        }

    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        return state.getValue(POWERED)? 15 : 0;
    }

    public void setOn(World worldIn, BlockPos pos) {
        worldIn.setBlock(pos, this.defaultBlockState().setValue(POWERED, true), 2);
    }

    public void setOff(World worldIn, BlockPos pos) {
        worldIn.setBlock(pos, this.defaultBlockState(), 2);
    }

    public boolean hasAnalogOutputSignal(BlockState state) {
        return state.getValue(POWERED);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult result) {
        if(playerEntity.isCrouching()) {
            return ActionResultType.SUCCESS;
        }
        playerEntity.openMenu((INamedContainerProvider)world.getBlockEntity(pos));
        return super.use(state, world, pos, playerEntity, hand, result);
    }

    @Override
    public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity player, boolean willHarvest, FluidState fluid) {
        TileEntity tile = world.getBlockEntity(pos).getTileEntity();
        if(tile instanceof TileEntityDreamLamp){
            ((TileEntityDreamLamp)tile).dropAllContents(world, pos);
        }
        return false;
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new TileEntityDreamLamp();
    }
}
