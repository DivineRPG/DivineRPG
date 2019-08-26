package divinerpg.objects.blocks;

import divinerpg.enums.EnumBlockType;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockModOre extends BlockMod {
    private Item dropItem;
    private Random rand;

    public BlockModOre(String name, float hardness, float resistance, int harvestLevel, Item drop)
    {
        super(EnumBlockType.ROCK, name, hardness, DivineRPGTabs.BlocksTab);
        this.setHarvestLevel("pickaxe", harvestLevel);
        this.setResistance(resistance);
        this.dropItem = drop;

        this.rand = new Random();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return this.dropItem != null ? this.dropItem : Item.getItemFromBlock(this);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return this.dropItem != null ? MathHelper.getInt(rand, 0, 4): 0;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return this.dropItem != null ? random.nextInt(fortune + 1) + 1 : 1;
    }

}
