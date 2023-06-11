package divinerpg.blocks.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModCrop;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockSkyPlant extends BlockModCrop {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)
    };

    public BlockSkyPlant() {
        super(0.5);
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sky_plant_seeds"));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "sky_plant_seeds")));
    }
}
