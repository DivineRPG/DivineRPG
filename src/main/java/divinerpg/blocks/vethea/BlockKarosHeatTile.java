package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockModUnbreakable;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.MapColor;

public class BlockKarosHeatTile extends BlockModUnbreakable {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public BlockKarosHeatTile() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).randomTicks().strength(-1, 3600000).instrument(NoteBlockInstrument.BASEDRUM));
        registerDefaultState(stateDefinition.any().setValue(ACTIVE, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(ACTIVE);}
    @Override public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if(state.getValue(ACTIVE) && random.nextInt(5) == 0) worldIn.setBlock(pos, state.setValue(ACTIVE, false), 2);
    }
    @Override public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(state.getValue(ACTIVE) && entity instanceof ServerPlayer && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
            entity.hurt(entity.damageSources().hotFloor(), 6);
            entity.setSecondsOnFire(5);
        }
    }
}