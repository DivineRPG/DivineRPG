package TeamDivineRPG.divinerpg.blocks.vanilla;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockMobPumpkin extends HorizontalBlock {
    private final SoundEvent sound;
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public BlockMobPumpkin(String name, SoundEvent sound) {
        super(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                .func_235861_h_()
                .hardnessAndResistance(1.0F, 1.0F)
                .sound(SoundType.WOOD));
        setRegistryName(name);
        this.sound=sound;
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if(!player.isSneaking() && sound != null){
        worldIn.playSound(player, pos, sound, SoundCategory.BLOCKS, 20.0F, 1.0F);
    }
        return ActionResultType.PASS;

    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
