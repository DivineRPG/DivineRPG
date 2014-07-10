package net.divinerpg.entities.vanilla;

import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAyeracoYellow extends EntityAyeraco {
	
    private EntityAyeraco aGreen;
    private EntityAyeraco aBlue;
    private EntityAyeraco aRed;
    private EntityAyeraco aPurple;

    private int beamX;
    private int beamY;
    private int beamZ;

    public EntityAyeracoYellow (World par1World) {
        super (par1World, "Yellow");
    }

    public void initOthers (EntityAyeraco par2, EntityAyeraco par3, EntityAyeraco par4, EntityAyeraco par5) {
		this.aGreen = par2;
		this.aBlue = par3;
		this.aRed = par4;
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
		if (this.aGreen != null && this.aGreen.abilityActive()) {
			return true;
		}
		return false;
	}
	
    @Override
    protected boolean canTeleport() {
		if (this.aPurple != null && this.aPurple.abilityActive()) {
			return true;
		}
		return false;
	}
	
    @Override
    protected void tickAbility() {
		this.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 1));
		if (this.aGreen != null && !this.aGreen.isDead) {
			aGreen.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 1));
		}
		if (this.aBlue != null && !this.aBlue.isDead) {
			aBlue.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 1));
		}
		if (this.aRed != null && !this.aRed.isDead) {
			aRed.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 1));
		}
		if (this.aPurple != null && !this.aPurple.isDead) {
			aPurple.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1, 1));
		}
	}

    @Override
    protected void dropRareDrop(int par1) {
        this.dropItem(VanillaItemsWeapons.enderSwordYellow, 1);
    }
}
