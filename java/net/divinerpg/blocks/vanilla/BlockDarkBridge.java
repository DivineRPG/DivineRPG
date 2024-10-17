package net.divinerpg.blocks.vanilla;

import java.util.Random;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkBridge extends BlockMod {
    
    private final boolean on;

    public BlockDarkBridge(boolean on) {
        super(EnumBlockType.GLASS, on ? "darkBridgeOn" : "darkBridge", 1.5F);
        this.on = on;
        setBlockName("darkBridge");
        if(on) {
            this.setLightLevel(1.0F);
            setCreativeTab(null);
            setLightOpacity(3);
        }
    }

    @Override
    public void onBlockAdded(World w, int x, int y, int z) {
        if (!w.isRemote) {
            if (on && !w.isBlockIndirectlyGettingPowered(x, y, z)) w.scheduleBlockUpdate(x, y, z, this, 4);
            else if (!on && w.isBlockIndirectlyGettingPowered(x, y, z)) w.setBlock(x, y, z, VanillaBlocks.darkBridgeOn, 0, 2);
        }
    }

    @Override
    public void onNeighborBlockChange(World w, int x, int y, int z, Block neighbor) {
        if (!w.isRemote) {
            if (on && !w.isBlockIndirectlyGettingPowered(x, y, z)) w.scheduleBlockUpdate(x, y, z, this, 4);
            else if (!on && w.isBlockIndirectlyGettingPowered(x, y, z)) w.setBlock(x, y, z, VanillaBlocks.darkBridgeOn, 0, 2);
        }
    }

    @Override
    public void updateTick(World w, int x, int y, int z, Random random) {
        if (!w.isRemote && on && !w.isBlockIndirectlyGettingPowered(x, y, z)) w.setBlock(x, y, z, VanillaBlocks.darkBridge, 0, 2);
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(VanillaBlocks.darkBridge);
    }

    @Override
    public boolean isOpaqueCube() {
        return !on ? false : true;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return !on ? false : true;
    }
    
    @Override
    public int getRenderBlockPass() {
        return !on ? 1 : 0;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
        return !on ? null : AxisAlignedBB.getBoundingBox((double)x + minX, (double)y + minY, (double)z + minZ, (double)x + maxX, (double)y + maxY, (double)z + maxZ);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, int x, int y, int z) {
        return Item.getItemFromBlock(VanillaBlocks.darkBridge);
    }

    @Override
    protected ItemStack createStackedBlock(int meta) {
        return new ItemStack(VanillaBlocks.darkBridge);
    }
}