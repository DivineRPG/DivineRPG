package net.divinerpg.api.blocks;

import static net.minecraftforge.common.util.ForgeDirection.*;

import java.util.ArrayList;

import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockFire;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModFire extends BlockFire {

    protected ArrayList<BlockModPortal> portals = new ArrayList<BlockModPortal>();
    protected String name;
    protected IIcon[] icons;

    public BlockModFire(String name) { //TODO
        super();
        this.name = name;
        setLightLevel(1.0F);
        setCreativeTab(null);
        setBlockName(name);
        setBlockTextureName(Reference.PREFIX + name);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
    }

    public void addPortal(BlockModPortal portal) {
        portals.add(portal);
    }

    protected void lightPortal(World world, int x, int y, int z){
        
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        lightPortal(world, x, y, z);
    }

    protected boolean canNeighborBurn(World world, int x, int y, int z) {
        return this.canCatchFire(world, x + 1, y, z, WEST) ||
                this.canCatchFire(world, x - 1, y, z, EAST) ||
                this.canCatchFire(world, x, y - 1, z, UP) ||
                this.canCatchFire(world, x, y + 1, z, DOWN) ||
                this.canCatchFire(world, x, y, z - 1, SOUTH) ||
                this.canCatchFire(world, x, y, z + 1, NORTH);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconReg) {
        this.icons = new IIcon[] { iconReg.registerIcon(Reference.PREFIX + "blueFire_0"), iconReg.registerIcon(Reference.PREFIX + "blueFire_1") };
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getFireIcon(int side) {
        return icons[side];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return icons[0];
    }

}
