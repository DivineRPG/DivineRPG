package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockModCrop extends BlockCrops {

    protected List<AxisAlignedBB> growthStageHitboxes = new ArrayList<>();

    public BlockModCrop(String name) {
        this(name, 0.8);
    }

    /**
     * @param maxHeight max height of plant, 0 > height >= 1
     */
    public BlockModCrop(String name, double maxHeight) {
        super();
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);

        // Stages starting with zero
        double step = maxHeight / ((double) getMaxAge() + 1);

        // Stages are grown by steps
        for (int i = 0; i <= getMaxAge(); i++) {
            growthStageHitboxes.add(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, step * (i + 1), 1.0D));
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return growthStageHitboxes.get(MathHelper.clamp(this.getAge(state), 0, growthStageHitboxes.size() - 1));
    }
}