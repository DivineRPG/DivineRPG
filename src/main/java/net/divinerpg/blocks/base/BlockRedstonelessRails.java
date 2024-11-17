package net.divinerpg.blocks.base;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockRedstonelessRails extends BlockRailPowered {
				
	public BlockRedstonelessRails(String name) {
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
	
	@Override
	protected boolean func_150058_a(World p_150058_1_, int p_150058_2_, int p_150058_3_, int p_150058_4_, int p_150058_5_, boolean p_150058_6_, int p_150058_7_)
    {
        if (p_150058_7_ >= 8)
        {
            return false;
        }
        else
        {
            int j1 = p_150058_5_ & 7;
            boolean flag1 = true;

            switch (j1)
            {
                case 0:
                    if (p_150058_6_)
                    {
                        ++p_150058_4_;
                    }
                    else
                    {
                        --p_150058_4_;
                    }

                    break;
                case 1:
                    if (p_150058_6_)
                    {
                        --p_150058_2_;
                    }
                    else
                    {
                        ++p_150058_2_;
                    }

                    break;
                case 2:
                    if (p_150058_6_)
                    {
                        --p_150058_2_;
                    }
                    else
                    {
                        ++p_150058_2_;
                        ++p_150058_3_;
                        flag1 = false;
                    }

                    j1 = 1;
                    break;
                case 3:
                    if (p_150058_6_)
                    {
                        --p_150058_2_;
                        ++p_150058_3_;
                        flag1 = false;
                    }
                    else
                    {
                        ++p_150058_2_;
                    }

                    j1 = 1;
                    break;
                case 4:
                    if (p_150058_6_)
                    {
                        ++p_150058_4_;
                    }
                    else
                    {
                        --p_150058_4_;
                        ++p_150058_3_;
                        flag1 = false;
                    }

                    j1 = 0;
                    break;
                case 5:
                    if (p_150058_6_)
                    {
                        ++p_150058_4_;
                        ++p_150058_3_;
                        flag1 = false;
                    }
                    else
                    {
                        --p_150058_4_;
                    }

                    j1 = 0;
            }

            return this.func_150057_a(p_150058_1_, p_150058_2_, p_150058_3_, p_150058_4_, p_150058_6_, p_150058_7_, j1) ? true : flag1 && this.func_150057_a(p_150058_1_, p_150058_2_, p_150058_3_ - 1, p_150058_4_, p_150058_6_, p_150058_7_, j1);
        }
    }

	@Override
    protected void func_150048_a(World p_150048_1_, int p_150048_2_, int p_150048_3_, int p_150048_4_, int p_150048_5_, int p_150048_6_, Block p_150048_7_)
    {
        boolean flag = this.func_150058_a(p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_, p_150048_5_, true, 0) || this.func_150058_a(p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_, p_150048_5_, false, 0);
        boolean flag1 = false;

        if (flag && (p_150048_5_ & 8) == 0)
        {
            p_150048_1_.setBlockMetadataWithNotify(p_150048_2_, p_150048_3_, p_150048_4_, p_150048_6_ | 8, 3);
            flag1 = true;
        }
        else if (!flag && (p_150048_5_ & 8) != 0)
        {
            p_150048_1_.setBlockMetadataWithNotify(p_150048_2_, p_150048_3_, p_150048_4_, p_150048_6_, 3);
            flag1 = true;
        }

        if (flag1)
        {
            p_150048_1_.notifyBlocksOfNeighborChange(p_150048_2_, p_150048_3_ - 1, p_150048_4_, this);

            if (p_150048_6_ == 2 || p_150048_6_ == 3 || p_150048_6_ == 4 || p_150048_6_ == 5)
            {
                p_150048_1_.notifyBlocksOfNeighborChange(p_150048_2_, p_150048_3_ + 1, p_150048_4_, this);
            }
        }
    }
}
