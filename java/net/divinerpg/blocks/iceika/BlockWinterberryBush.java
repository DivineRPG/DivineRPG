package net.divinerpg.blocks.iceika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWinterberryBush extends BlockMod implements IShearable {

    protected IIcon                     grown, notGrown;
    
    private IIcon[] textures = new IIcon[2];

    protected String                    stateChangeName;
    public boolean               		isGrown;



    public BlockWinterberryBush(boolean grown, String name) {
        super(EnumBlockType.LEAVES, name, 0.3F);
        this.isGrown = grown;
        setTickRandomly(true);
    }

    @Override
    public void onBlockDestroyedByPlayer(World w, int x, int y, int z, int meta) {
        if (isGrown) w.setBlock(x, y, z, IceikaBlocks.winterberryBush);
    }

    @Override
    public void updateTick(World w, int x, int y, int z, Random r) {
        if (r.nextInt(2) == 0 && w.getBlock(x, y, z) == IceikaBlocks.winterberryBush) w.setBlock(x, y, z, IceikaBlocks.winterberryBushRipe);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public IIcon getIcon(IBlockAccess world, int i, int j, int k, int par5) {
        if (Minecraft.getMinecraft().gameSettings.fancyGraphics) return this.textures[0];
        return this.textures[1];
    }
    
    @Override
    public void registerBlockIcons(IIconRegister i) {
    	this.blockIcon = i.registerIcon(textureName);
    	this.textures[0] = i.registerIcon(textureName);
    	this.textures[1] = i.registerIcon(textureName + "_fast");
    }

    @Override
    public Item getItemDropped(int meta, Random rand, int fortune) {
        if (this == IceikaBlocks.winterberryBushRipe) return IceikaItems.winterberry;
        return null;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        if(this == IceikaBlocks.winterberryBush)ret.add(new ItemStack(this, 1));
        return ret;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess w, int x, int y, int z, int meta) {
        Block block = w.getBlock(x, y, z);
        return !Minecraft.getMinecraft().gameSettings.fancyGraphics && block == this ? false : super.shouldSideBeRendered(w, x, y, z, meta);
    }

}
