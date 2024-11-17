package net.divinerpg.blocks.vanilla;

import java.util.Random;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSlimeLight extends BlockMod {
    private final boolean isOn;

    public BlockSlimeLight(boolean on) {
        super(EnumBlockType.GLASS, on ? "slimeLightOn" : "slimeLight", 2);
        this.isOn = on;
        setBlockName("slimeLight");
        if (on) {
            this.setLightLevel(1.0F);
            setCreativeTab(null);
        }
    }

    @Override
    public void onBlockAdded(World w, int x, int y, int z) {
        if (!w.isRemote) {
            if (this.isOn && !w.isBlockIndirectlyGettingPowered(x, y, z)) w.scheduleBlockUpdate(x, y, z, this, 4);
            else if (!this.isOn && w.isBlockIndirectlyGettingPowered(x, y, z)) w.setBlock(x, y, z, VanillaBlocks.slimeLightOn, 0, 2);
        }
    }

    @Override
    public void onNeighborBlockChange(World w, int x, int y, int z, Block neighbor) {
        if (!w.isRemote) {
            if (this.isOn && !w.isBlockIndirectlyGettingPowered(x, y, z)) w.scheduleBlockUpdate(x, y, z, this, 4);
            else if (!this.isOn && w.isBlockIndirectlyGettingPowered(x, y, z)) w.setBlock(x, y, z, VanillaBlocks.slimeLightOn, 0, 2);
        }
    }

    @Override
    public void updateTick(World w, int x, int y, int z, Random random) {
        if (!w.isRemote && this.isOn && !w.isBlockIndirectlyGettingPowered(x, y, z)) w.setBlock(x, y, z, VanillaBlocks.slimeLight, 0, 2);
    }

    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return Item.getItemFromBlock(VanillaBlocks.slimeLight);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, int x, int y, int z)
    {
        return Item.getItemFromBlock(VanillaBlocks.slimeLight);
    }

    @Override
    protected ItemStack createStackedBlock(int meta)
    {
        return new ItemStack(VanillaBlocks.slimeLight);
    }
}