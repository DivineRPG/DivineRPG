package divinerpg.blocks.vanilla;

import divinerpg.block_entities.block.UpdatableBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.BossEvent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class AyeracoBeam extends BaseEntityBlock {
    private BossEvent.BossBarColor color;
    public AyeracoBeam(Properties properties) {super(properties);}
    public AyeracoBeam(Properties p, BossEvent.BossBarColor color) {
        super(p);
        this.color = color;
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return Shapes.empty();}
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new UpdatableBlockEntity(BlockEntityRegistry.AYERACO_BEAM.get(), pos, state);}
    public BossEvent.BossBarColor getColor() {return color;}
}