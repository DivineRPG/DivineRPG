package divinerpg.blocks.vanilla;

import divinerpg.tiles.bosses.*;
import net.minecraft.core.*;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.*;

public class BlockAyeracoBeam extends BaseEntityBlock {
	private final BossBarColor color;
    public BlockAyeracoBeam(BossBarColor color) {
        super(Block.Properties.of(Material.FIRE).strength(6000000.0F, 6000000.0F).air());
        this.color = color;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
    	return Shapes.empty();
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new TileEntityAyeracoBeam(p_153215_, p_153216_);
    }
    public BossBarColor getColor() {
    	return color;
    }
}
