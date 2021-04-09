package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.*;

import java.util.*;

public class BlockModCrop extends CropsBlock {
    int age, maxAge;
    IItemProvider seed;
    protected List<VoxelShape> growthStageHitboxes = new ArrayList<VoxelShape>();

    public BlockModCrop(String name) {
        this(name, 0.8);
    }

    public BlockModCrop(String name, double maxHeight) {
        this(name, maxHeight, 0);
    }

    public BlockModCrop(String name, double maxHeight, int maxAge) {
        super(AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
        this.setRegistryName(name);
        this.maxAge = maxAge;

        double step = maxHeight / ((double) getMaxAge() + 1);

        for (int i = 0; i <= getMaxAge(); i++)
            growthStageHitboxes.add(VoxelShapes.create(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, step * (i + 1), 1.0D)));
    }

    public BlockModCrop(String name, int age, IItemProvider seed) {
        this(name, 0.8, age);
        this.age=age;
        this.seed=seed;
    }
    @Override
    public int getMaxAge() {
        return age;
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return seed;
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return new ItemStack(seed);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        growthStageHitboxes.get(MathHelper.clamp(getAge(state), 0, growthStageHitboxes.size() - 1));
        return growthStageHitboxes.get(MathHelper.clamp(getAge(state), 0, growthStageHitboxes.size() - 1));
    }
}
