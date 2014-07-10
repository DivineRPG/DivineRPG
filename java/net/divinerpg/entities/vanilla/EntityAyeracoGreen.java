package net.divinerpg.entities.vanilla;

import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAyeracoGreen extends EntityAyeraco {
	
    private EntityAyeraco aBlue;
    private EntityAyeraco aRed;
    private EntityAyeraco aYellow;
    private EntityAyeraco aPurple;

    private int beamX;
    private int beamY;
    private int beamZ;

    public EntityAyeracoGreen (World par1World) {
        super (par1World, "Green");
    }

    public void initOthers (EntityAyeraco par2, EntityAyeraco par3, EntityAyeraco par4, EntityAyeraco par5) {
		this.aBlue = par2;
		this.aRed = par3;
		this.aYellow = par4;
		this.aPurple = par5;
	}
	
    public void setBeamLocation(int x, int y, int z) {
		beamX = x;
		beamY = y;
		beamZ = z;
	}
 
    @Override
    public void onDeath(DamageSource par1DamageSource) {
    	super.onDeath(par1DamageSource);
    	worldObj.setBlock(beamX, beamY, beamZ, Blocks.air);
    }

    @Override
    protected boolean canBlockProjectiles() {
		return true;
	}
	
    @Override
    protected boolean canTeleport() {
		if (this.aPurple != null && this.aPurple.abilityActive()) {
			return true;
		}
		return false;
	}

    @Override
    protected void dropRareDrop(int par1) {
        this.dropItem(VanillaItemsWeapons.enderSwordGreen, 1);
    }
}