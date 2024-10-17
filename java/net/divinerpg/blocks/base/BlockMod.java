package net.divinerpg.blocks.base;

import java.util.Random;

import net.divinerpg.blocks.vanilla.DivineMetaItemBlock;
import net.divinerpg.blocks.vanilla.IDivineMetaBlock;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.material.EnumToolType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockMod extends Block {

    protected String        name;
    protected EnumBlockType blockType;
    protected Item          drop;
    protected Random        rand;
    protected boolean       exp         = false;
    protected boolean       twilightOre = false;

    public BlockMod(String name, float hardness) {
        this(EnumBlockType.ROCK, name, hardness, DivineRPGTabs.blocks);
    }

    public BlockMod(String name, float hardness, DivineRPGTabs tab) {
        this(EnumBlockType.ROCK, name, hardness, tab);
    }

    public BlockMod(String name, boolean breakable) {
        this(EnumBlockType.ROCK, name, breakable);
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness) {
        this(blockType, name, hardness, DivineRPGTabs.blocks);
        if (blockType == EnumBlockType.DIRT) setHarvestLevel("shovel", 3);
    }

    public BlockMod(String name, boolean breakable, DivineRPGTabs tab) {
        this(EnumBlockType.ROCK, name, breakable, tab);
    }

    public BlockMod(EnumBlockType blockType, String name, boolean breakable) {
        this(blockType, name, breakable, DivineRPGTabs.blocks);
    }

    public BlockMod(EnumBlockType blockType, String name, boolean breakable, DivineRPGTabs tab) {
        this(blockType, name, tab);
        if (!breakable) {
            setBlockUnbreakable();
            setResistance(6000000F);
        }
    }

    public BlockMod(EnumBlockType blockType, String name, DivineRPGTabs tab) {
        super(blockType.getMaterial());
        this.blockType = blockType;
        this.name = name;
        rand = new Random();
        setTextureName(Reference.PREFIX + name);
        setStepSound(blockType.getSound());
        setCreativeTab(tab);
        setTextureName(textureName);
        setBlockName(name);
        if (!(this instanceof IDivineMetaBlock)) {
            GameRegistry.registerBlock(this, name);
        } else {
            GameRegistry.registerBlock(this, DivineMetaItemBlock.class, name);
        }
        LangRegistry.addBlock(this);
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, DivineRPGTabs tab) {
        super(blockType.getMaterial());
        this.blockType = blockType;
        this.name = name;
        rand = new Random();
        setTextureName(Reference.PREFIX + name);
        setStepSound(blockType.getSound());
        setCreativeTab(tab);
        setTextureName(textureName);
        setBlockName(name);
        setHardness(hardness);
        if (hardness == -1F) {
            setBlockUnbreakable();
            setResistance(6000000F);
        }
        if (!(this instanceof IDivineMetaBlock)) {
            GameRegistry.registerBlock(this, name);
        } else {
            GameRegistry.registerBlock(this, DivineMetaItemBlock.class, name);
        }
        LangRegistry.addBlock(this);
    }

    public BlockMod(EnumBlockType blockType, String name, float hardness, DivineRPGTabs tab, Class<? extends ItemBlock> item) {
        super(blockType.getMaterial());
        this.blockType = blockType;
        this.name = name;
        rand = new Random();
        setTextureName(Reference.PREFIX + name);
        setStepSound(blockType.getSound());
        setCreativeTab(tab);
        setTextureName(textureName);
        setBlockName(name);
        setHardness(hardness);
        if (hardness == -1F) {
            setBlockUnbreakable();
            setResistance(6000000F);
        }
        GameRegistry.registerBlock(this, item, name);
        LangRegistry.addBlock(this);
    }

    @Override
    public Item getItemDropped(int par1, Random par2, int par3) {
        if (drop == null)
            return Util.toItem(this);
        return drop;
    }

    public BlockMod toggleExp(boolean exp) {
        this.exp = exp;
        return this;
    }

    public BlockMod setTwilightOre(boolean twilightOre) {
        this.twilightOre = twilightOre;
        return this;
    }

    public boolean isTwilightOre() {
        return twilightOre;
    }

    public BlockMod setDropItem(Item drop) {
        this.drop = drop;
        return this;
    }

    public BlockMod setHarvestLevel(EnumToolType type) {
        setHarvestLevel(type.getType(), type.getLevel());
        return this;
    }

    public BlockMod setTextureName(String textureName) {
        this.textureName = textureName;
        return this;
    }

    @Override
    public int getExpDrop(IBlockAccess block, int par5, int par7) {
        if (this.getItemDropped(par5, rand, par7) != Util.toItem(this)) {
            int j1 = 0;

            if (exp)
                j1 = MathHelper.getRandomIntegerInRange(rand, 0, 4);
            return j1;
        }
        return 0;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if (twilightOre && fortune > 0) {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0)
                j = 0;

            return (j + 1);
        }
        return 1;
    }
}
