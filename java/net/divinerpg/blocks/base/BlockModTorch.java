package net.divinerpg.blocks.base;

import java.util.Random;

import net.divinerpg.DivineRPG;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModTorch extends BlockTorch {
	
	private String particle;

    public BlockModTorch(String name, String particle) {
        super();
        this.setCreativeTab(DivineRPGTabs.blocks);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.PREFIX + name);
        this.setLightLevel(1);
        this.setHardness(0.0F);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
        this.particle = particle;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
    	
    	if(this.particle != null) {
    		
    		int l = world.getBlockMetadata(x, y, z);
        	double d0 = (double)((float)x + 0.5F);
        	double d1 = (double)((float)y + 0.7F);
        	double d2 = (double)((float)z + 0.5F);
        	double d3 = 0.2199999988079071D;
        	double d4 = 0.27000001072883606D;
        	
        	if (l == 1) DivineRPG.proxy.spawnParticle(world, d0 - d4, d1 + d3, d2, this.particle, false);
        	else if (l == 2) DivineRPG.proxy.spawnParticle(world, d0 + d4, d1 + d3, d2, this.particle, false);
        	else if (l == 3) DivineRPG.proxy.spawnParticle(world, d0, d1 + d3, d2 - d4, this.particle, false);
        	else if (l == 4) DivineRPG.proxy.spawnParticle(world, d0, d1 + d3, d2 + d4, this.particle, false);
        	else DivineRPG.proxy.spawnParticle(world, d0, d1, d2, this.particle, false);
    	}
    }
}