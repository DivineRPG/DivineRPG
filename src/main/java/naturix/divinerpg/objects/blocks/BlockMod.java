package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import naturix.divinerpg.utils.material.EnumBlockType;
import naturix.divinerpg.utils.material.EnumToolType;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockMod extends Block implements IHasModel {

    protected String name;
    protected EnumBlockType blockType;
    protected Item drop;
    protected Random rand;
    protected boolean exp = false;
    protected boolean twilightOre = false;
    protected float hardness = 2.0f;

    public BlockMod(EnumBlockType blockType, String name, boolean breakable) {
        this(blockType, name, breakable, DivineRPGTabs.BlocksTab);
    }

    public BlockMod(EnumBlockType blockType, String name, boolean breakable, CreativeTabs tab) {
        this(blockType, name, tab);
        if (!breakable) {
            setBlockUnbreakable();
            setResistance(6000000F);
        }
    }

    public BlockMod(EnumBlockType blockType, String name, CreativeTabs tab) {
        super(blockType.getMaterial());
        this.blockType = blockType;
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        rand = new Random();
        setSoundType(blockType.getSound());
        setCreativeTab(tab);
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness) {
        this(blockType, name, hardness, DivineRPGTabs.BlocksTab);
        if (blockType == EnumBlockType.DIRT) {
            setHarvestLevel("shovel", 3);
        }
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, CreativeTabs tab) {
        this(blockType, blockType.getMaterial().getMaterialMapColor(), name, hardness, tab);
    }

    public BlockMod(EnumBlockType blockType, MapColor mapColor, String name, float hardness, CreativeTabs tab) {
        super(blockType.getMaterial(), mapColor);
        this.blockType = blockType;
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        rand = new Random();
        setSoundType(blockType.getSound());
        setCreativeTab(tab);
        this.hardness = hardness;
        setHardness(hardness);
        if (hardness == -1F) {
            setBlockUnbreakable();
            setResistance(6000000F);
        }
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, CreativeTabs tab,
            Class<? extends ItemBlock> item) {
        super(blockType.getMaterial());
        this.blockType = blockType;
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        rand = new Random();
        setSoundType(blockType.getSound());
        setCreativeTab(tab);
        this.hardness = hardness;
        setHardness(hardness);
        if (hardness == -1F) {
            setBlockUnbreakable();
            setResistance(6000000F);
        }
        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockMod(Material rock, String name2) {
        this(EnumBlockType.ROCK, name2, 1, DivineRPGTabs.BlocksTab);
    }

    public BlockMod(String name, boolean breakable) {
        this(EnumBlockType.ROCK, name, breakable);
    }

    public BlockMod(String name, boolean breakable, CreativeTabs tab) {
        this(EnumBlockType.ROCK, name, breakable, tab);
    }

    public BlockMod(String name, float hardness) {
        this(EnumBlockType.ROCK, name, hardness, DivineRPGTabs.BlocksTab);
    }

    public BlockMod(String name, float hardness, CreativeTabs tab) {
        this(EnumBlockType.ROCK, name, hardness, tab);
    }

    public float getBlockModHardness() {
        return hardness;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int j1 = 0;

            if (exp) {
                j1 = MathHelper.getInt(rand, 0, 4);
            }
            return j1;
        }
        return 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (drop == null) {
            return Item.getItemFromBlock(this);
        }
        return drop;
    }

    public boolean isTwilightOre() {
        return twilightOre;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        if (twilightOre && fortune > 0) {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0) {
                j = 0;
            }

            return (j + 1);
        }
        return 1;
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    public BlockMod setDropItem(Item drop) {
        this.drop = drop;
        return this;
    }

    public BlockMod setHarvestLevel(EnumToolType type) {
        setHarvestLevel(type.getType(), type.getLevel());
        return this;
    }

    public BlockMod setTwilightOre(boolean twilightOre) {
        this.twilightOre = twilightOre;
        return this;
    }

    public BlockMod toggleExp(boolean exp) {
        this.exp = exp;
        return this;
    }
}
