package divinerpg.blocks.arcana;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.state.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.*;

public class BlockHeatTrap extends BlockModUnbreakable {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public BlockHeatTrap(String name) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.LAPIS).randomTicks().requiresCorrectToolForDrops().strength(-1, 3600000.0F).sound(SoundType.STONE));
        this.registerDefaultState(stateDefinition.any().setValue(ACTIVE, Boolean.valueOf(false)));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        boolean i = state.hasProperty(ACTIVE);
        if (i == true && random.nextInt(5) == 0) {
            worldIn.setBlock(pos, state.setValue(ACTIVE, Boolean.valueOf(false)), 2);
        }

    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return VoxelShapes.create(new AxisAlignedBB(1.1, 1.1, 1.1, -0.1, -0.1, -0.1));
    }



    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        super.entityInside(state, world, pos, entity);
        if (world.getBlockState(pos).getValue(ACTIVE) == false) {
            world.setBlock(pos, BlockRegistry.heatTrap.defaultBlockState().setValue(ACTIVE, Boolean.valueOf(true)), 1);
        }

        if (world.getBlockState(pos).getValue(ACTIVE) == true && entity instanceof ServerPlayerEntity) {
            LivingEntity entityLivingBase = (LivingEntity)entity;
            if(entityLivingBase.getEffect(new EffectInstance(Effects.FIRE_RESISTANCE).getEffect()) == null) {
                entityLivingBase.hurt(DamageSources.trapSource, 6);
            }
            entityLivingBase.setSecondsOnFire(12);
        }
    }

}
