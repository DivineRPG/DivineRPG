package divinerpg.blocks.vanilla;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModCrop;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockTomatoPlant extends BlockModCrop {
    private static final AABB[] CROPS_AABB = new AABB[] {
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.27D, 1.0D),
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.33D, 1.0D),
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.56D, 1.0D),
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.65D, 1.0D),
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.65D, 1.0D),
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.80D, 1.0D),
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.80D, 1.0D),
            new AABB(0.0D, 0.0D, 0.0D, 1.0D, 0.80D, 1.0D) };

    public BlockTomatoPlant() {
        super();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return Shapes.create(CROPS_AABB[((Integer) state.getValue(this.getAgeProperty())).intValue()]);
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tomato_seeds"));
    }

}
