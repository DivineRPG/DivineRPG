package net.divinerpg.entities.vanilla;

import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAyeracoPurple extends EntityAyeraco {
	
    private EntityAyeraco aGreen;
    private EntityAyeraco aBlue;
    private EntityAyeraco aRed;
    private EntityAyeraco aYellow;

    private int beamX;
    private int beamY;
    private int beamZ;

    public EntityAyeracoPurple (World par1World) {
        super (par1World, "Purple");
    }

    public void initOthers (EntityAyeraco par2, EntityAyeraco par3, EntityAyeraco par4, EntityAyeraco par5) {
		this.aGreen = par2;
		this.aBlue = par3;
		this.aRed = par4;
		this.aYellow = par5;
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
		if (this.aGreen != null && this.aGreen.abilityActive()) {
			return true;
		}
		return false;
	}
	
	@Override
    protected boolean canTeleport() {
		return true;
	}
	
    @Override
    protected void dropRareDrop(int par1)  {
        this.dropItem(VanillaItemsWeapons.enderSword, 1);
    }
}