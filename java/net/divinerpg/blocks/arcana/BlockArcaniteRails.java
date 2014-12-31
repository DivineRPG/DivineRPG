package net.divinerpg.blocks.arcana;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockArcaniteRails extends BlockRailPowered {
	
	private String name = "arcaniteRails";
			
	public BlockArcaniteRails() {
		setCreativeTab(DivineRPGTabs.utility);
		setBlockName(name);
		setBlockTextureName(Reference.PREFIX + name);
		GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
	}
	
	@Override
	protected boolean func_150057_a(World world, int x, int y, int z, boolean bool, int side, int meta) {
        Block block = world.getBlock(x, y, z);

        if (block == this) {
            int j1 = world.getBlockMetadata(x, y, z);
            int k1 = j1 & 7;

            if (meta == 1 && (k1 == 0 || k1 == 4 || k1 == 5))
                return false;

            if (meta == 0 && (k1 == 1 || k1 == 2 || k1 == 3))
            	return false;

            if ((j1 & 8) != 0)
                return true;
        }
        return false;
    }
	
	/*@Override
	protected void func_150048_a(World world, int x, int y, int z, int side, int meta, Block block) {
        boolean flag = world.isBlockIndirectlyGettingPowered(x, y, z);
        flag = flag || this.func_150058_a(world, x, y, z, side, true, 0) || this.func_150058_a(world, x, y, z, side, false, 0);
        boolean flag1 = false;

        if ((side & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, meta | 8, 3);
            flag1 = true;
        }
        else if (!flag && (side & 8) != 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, meta, 3);
            flag1 = true;
        }
        world.notifyBlocksOfNeighborChange(x, y - 1, z, this);

        if (meta == 2 || meta == 3 || meta == 4 || meta == 5)
        {
            world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
        }
    }*/
}
