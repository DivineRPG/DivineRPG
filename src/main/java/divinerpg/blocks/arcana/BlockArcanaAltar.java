package divinerpg.blocks.arcana;

import divinerpg.block_entities.bosses.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

import static divinerpg.registries.BlockRegistry.dramixAltar;
import static net.minecraft.world.level.block.Blocks.BEDROCK;

public class BlockArcanaAltar extends BaseEntityBlock {

    public BlockArcanaAltar(Properties properties) {
        super(properties);
    }

    public BlockArcanaAltar(MapColor color){
        super(Properties.ofFullCopy(BEDROCK).mapColor(color).noOcclusion());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.create(new AABB(0, 0, 0, 1, 0.9, 1));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return this == dramixAltar.get() ? new DramixAltarBlockEntity(pos, state) : new ParasectaAltarBlockEntity(pos, state);
    }
}
