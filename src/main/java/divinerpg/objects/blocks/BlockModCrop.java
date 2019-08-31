package divinerpg.objects.blocks;

import divinerpg.DivineRPG;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.IHasModel;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockModCrop extends BlockCrops implements IHasModel {
    protected String name;

    /**
     * Contains stages of growth
     */
    protected List<AxisAlignedBB> aabb = new ArrayList<>();

    public BlockModCrop(String name) {
        this(name, 0.8);
    }

    /**
     * @param maxHeight - max height of plant, 0 > height >= 1
     */
    public BlockModCrop(String name, double maxHeight) {
        super();
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        // Stages starting with zero
        double step = maxHeight / ((double)getMaxAge() + 1);

        // Stages are grown by steps
        for (int i = 0; i <= getMaxAge(); i++){
            aabb.add(new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, step * (i + 1), 1.0D));
        }
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && soil.getBlock() == Blocks.FARMLAND;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return aabb.get(MathHelper.clamp(this.getAge(state), 0, aabb.size() - 1));
    }
}