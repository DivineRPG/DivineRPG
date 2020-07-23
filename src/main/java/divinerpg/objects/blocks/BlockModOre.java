package divinerpg.objects.blocks;

import java.util.Random;
import java.util.function.Supplier;

import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockModOre extends BlockMod {
    private Supplier<Item> dropItemSupplier;
    private Random rand;

    public BlockModOre(String name, float hardness, float resistance, int harvestLevel, Supplier<Item> drop) {
        super(name, hardness, Material.ROCK);
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.setResistance(resistance);
        this.dropItemSupplier = drop;

        this.rand = new Random();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        Item dropItem = this.dropItemSupplier.get();
        return dropItem != null ? dropItem : Item.getItemFromBlock(this);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Item dropItem = this.dropItemSupplier.get();
        return dropItem != null ? MathHelper.getInt(rand, 0, 4) : 0;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        Item dropItem = this.dropItemSupplier.get();
        return dropItem != null ? random.nextInt(fortune + 1) + 1 : 1;
    }
}
