package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class BlockModCrop extends CropBlock {
    int age, maxAge;
    ResourceLocation seed;
    protected List<VoxelShape> growthStageHitboxes = new ArrayList<VoxelShape>();

    public BlockModCrop() {
        this(0.8);
    }

    public BlockModCrop(double maxHeight) {
        this(maxHeight, 0);
    }

    public BlockModCrop(double maxHeight, int maxAge) {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.CROP));
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
    public int getMaxAge() {
        return age;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(seed);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(seed));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        growthStageHitboxes.get(Mth.clamp(getAge(state), 0, growthStageHitboxes.size() - 1));
        return growthStageHitboxes.get(Mth.clamp(getAge(state), 0, growthStageHitboxes.size() - 1));
    }
}
