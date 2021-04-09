package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import java.util.*;

public class BlockAcid extends BlockMod {

    protected static final VoxelShape acidBoundingBox = VoxelShapes.create(new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F));
    protected boolean decays;
    protected boolean poison;

    public BlockAcid(String name, boolean decays) {
        this(name, decays, false);
    }

    public BlockAcid(String name, boolean decays, boolean poison) {
        super(name, Block.Properties.of(Material.SNOW).strength(0.1F, 3.0F).randomTicks());
        this.decays = decays;
        this.poison = poison;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader source, BlockPos pos, ISelectionContext context) {
        return acidBoundingBox;
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
    }

    @Override
    public void stepOn(World world, BlockPos pos, Entity entity) {
        if(entity instanceof PlayerEntity) {
            entity.hurt(DamageSources.acidSource, 3);
        }
    }

}
