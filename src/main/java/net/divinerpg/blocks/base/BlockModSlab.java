package net.divinerpg.blocks.base;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockModSlab extends BlockSlab {

    public final String NAME;
    private Block       single;

    public BlockModSlab(BlockMod base, boolean stack, String remove, Block single) {
        super(stack, base.blockType.getMaterial());
        setHardness(base.getBlockHardness(null, 0, 0, 0));
        setResistance((base.getExplosionResistance(null) * 5) / 3);
        setTextureName(Reference.PREFIX + base.name);
        NAME = base.name.replace(remove, "") + "Slab";
        setUnlocalizedName(NAME);
        if (!stack) {
            LangRegistry.addBlock(this);
            setCreativeTab(DivineRPGTabs.blocks);
            useNeighborBrightness = true;
        }
        this.single = single;
    }

    @Override
    public String getFullSlabName(int i) {
        return super.getUnlocalizedName();
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return single == null ? Item.getItemFromBlock(this) : Item.getItemFromBlock(single);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World w, int x, int y, int z) {
        return single == null ? Item.getItemFromBlock(this) : Item.getItemFromBlock(single);
    }

}
