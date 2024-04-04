package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockMod;
import divinerpg.util.DamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

public class BlockAcid extends BlockMod {
    protected static final VoxelShape acidBoundingBox = Block.box(0, 0, 0, 16, 2, 16);
    public BlockAcid() {super(Block.Properties.of().strength(.1F).randomTicks().sound(SoundType.SNOW));}
    @Override public VoxelShape getShape(BlockState state, BlockGetter source, BlockPos pos, CollisionContext context) {return acidBoundingBox;}
    @Override public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if(random.nextInt(5) == 0) worldIn.removeBlock(pos, true);
    }
    @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof Player) entity.hurt(DamageSources.source(level, DamageSources.ACID), 3);
    }
}