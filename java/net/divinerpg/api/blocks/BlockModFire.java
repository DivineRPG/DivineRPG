package net.divinerpg.api.blocks;

import java.util.ArrayList;

import net.divinerpg.Reference;
import net.divinerpg.api.blocks.portal.BlockModPortal;
import net.divinerpg.helper.tabs.DivineRPGTabs;
import net.divinerpg.helper.utils.LangRegistry;
import net.minecraft.block.BlockFire;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import static net.minecraftforge.common.util.ForgeDirection.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModFire extends BlockFire {

    protected ArrayList<BlockModPortal> portals = new ArrayList<BlockModPortal>();
    protected String                    name;
    protected IIcon[]                   icons;

    public BlockModFire(String name) { //TODO
        super();
        this.name = name;
        setLightLevel(1.0F);
        setCreativeTab(DivineRPGTabs.blocks);//For bug testing
        setBlockName(name);
        setBlockTextureName(Reference.PREFIX + name);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
    }

    public void addPortal(BlockModPortal portal) {
        portals.add(portal);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        for (int i = 0; i < portals.size(); i++) {
            BlockModPortal portal = portals.get(i);
            if (world.provider.dimensionId > 0 || !portal.isPortalCorrectSize(world, x, y, z)) {
                if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) world.setBlockToAir(x, y, z);
                else world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
            }
        }
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
