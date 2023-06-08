package divinerpg.blocks.arcana;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModUnbreakable;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockHeatTrap extends BlockModUnbreakable {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public BlockHeatTrap() {
        super(Block.Properties.of().mapColor(MapColor.COLOR_BLUE).randomTicks().strength(-1, 3600000.0F));
        registerDefaultState(stateDefinition.any().setValue(ACTIVE, false));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }
    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if(state.getValue(ACTIVE) && random.nextInt(5) == 0) worldIn.setBlock(pos, state.setValue(ACTIVE, false), 2);
    }
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
    	if(state.is(this) && !(entity instanceof LivingEntity && EnchantmentHelper.hasFrostWalker((LivingEntity) entity))) {
            if(!state.getValue(ACTIVE)) level.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "heat_trap")).defaultBlockState().setValue(ACTIVE, true), 2);
            entity.lavaHurt();
    	}
    }
    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float distance) {
    	super.fallOn(level, state, pos, entity, distance);
    	stepOn(level, pos, state, entity);
    }
}
