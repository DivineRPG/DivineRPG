package divinerpg.objects.blocks.vanilla;

import divinerpg.objects.blocks.BlockModCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockTomatoPlant extends BlockModCrop {
    private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.27D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.33D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.56D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.65D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.65D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.80D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.80D, 1.0D),
            new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.80D, 1.0D) };

    public BlockTomatoPlant() {
        super("tomato_plant");
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        /*int age = ((Integer) state.getValue(this.getAgeProperty())).intValue();
        if (age == 0) {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.27D, 1.0D);
        } else if (age == 1) {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.33D, 1.0D);
        } else if (age == 2) {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.56D, 1.0D);
        } else if (age == 3) {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.65D, 1.0D);
        } else if (age == 4) {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.65D, 1.0D);
        } else if (age == 5) {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8D, 1.0D);
        } else if (age == 6) {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8D, 1.0D);
        } else {
            return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8D, 1.0D);
        }*/
        return CROPS_AABB[((Integer) state.getValue(this.getAgeProperty())).intValue()];
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected Item getSeed() {
        return ItemRegistry.tomatoSeeds;
    }

    @Override
    protected Item getCrop() {
        return ItemRegistry.tomato;
    }
}