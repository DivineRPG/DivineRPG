package net.divinerpg.blocks.vethea;

import java.util.Random;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockKarosHeatTile extends BlockMod {

    public BlockKarosHeatTile() {
        super(EnumBlockType.GLASS, "karosHeatTileRed", false, DivineRPGTabs.vethea);
        this.setTickRandomly(true);
    }

    @Override
    public void updateTick(World w, int x, int y, int z, Random rand) {
        if (!w.isRemote) w.setBlock(x, y, z, VetheaBlocks.karosHeatTileGreen);
    }
    
    @Override
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity entity) {
    	if(entity instanceof EntityPlayer && !((EntityPlayer)entity).capabilities.isCreativeMode) {
    		entity.setFire(5);
    		entity.attackEntityFrom(Util.trapSource, 6);
    	}
    }
    
    @Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1) - f, (double)(z + 1));
    }

}
