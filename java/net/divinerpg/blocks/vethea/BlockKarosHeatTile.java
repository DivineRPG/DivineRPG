package net.divinerpg.blocks.vethea;

import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockKarosHeatTile extends BlockMod {

    public BlockKarosHeatTile() {
        super(EnumBlockType.GLASS, "karosHeatTileRed", false, DivineRPGTabs.vethea);
        if (this == VetheaBlocks.karosHeatTileRed) {
            this.setTickRandomly(true);
        }
    }

    @Override
    public void updateTick(World w, int x, int y, int z, Random rand) {
        if (!w.isRemote) {
            if (this == VetheaBlocks.karosHeatTileRed) {
                w.setBlock(x, y, z, VetheaBlocks.karosHeatTileGreen);
            }
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(World w, int x, int y, int z, Entity entity) {
    	if(entity instanceof EntityPlayer && !((EntityPlayer)entity).capabilities.isCreativeMode) {
    		entity.setFire(5);
    		entity.attackEntityFrom(DamageSource.onFire, 6);
    	}
    }

}
