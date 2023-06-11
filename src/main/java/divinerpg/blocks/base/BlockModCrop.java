package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class BlockModCrop extends CropBlock {
    int age, maxAge;
    ResourceLocation seed;
    protected List<VoxelShape> growthStageHitboxes = new ArrayList<VoxelShape>();
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    public BlockModCrop() {
        this(0.8);
    }

    public BlockModCrop(double maxHeight) {
        this(maxHeight, 0);
    }

    public BlockModCrop(double maxHeight, int maxAge) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).pushReaction(PushReaction.DESTROY).noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.CROP));
        this.maxAge = maxAge;

        double step = maxHeight / ((double) getMaxAge() + 1);

        for (int i = 0; i <= getMaxAge(); i++)
            growthStageHitboxes.add(Shapes.create(new AABB(0.0D, 0.0D, 0.0D, 1.0D, step * (i + 1), 1.0D)));
    }

    public BlockModCrop(int age, ResourceLocation seed) {
        this(0.8, age);
        this.age=age;
        this.seed=seed;
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
    }

    @Override
    public int getMaxAge() {
        return age;
    }

    public boolean canSurvive(BlockState state, LevelReader levelReader, BlockPos pos) {
        return (levelReader.getRawBrightness(pos, 0) >= 8 || levelReader.canSeeSky(pos)) && levelReader.getBlockState(pos.below()).is(Blocks.FARMLAND);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(seed);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(seed));
    }
}
