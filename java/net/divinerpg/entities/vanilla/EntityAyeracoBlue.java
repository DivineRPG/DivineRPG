package net.divinerpg.entities.vanilla;

import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAyeracoBlue extends EntityAyeraco {
	
    private EntityAyeraco aGreen;
    private EntityAyeraco aRed;
    private EntityAyeraco aYellow;
    private EntityAyeraco aPurple;
    private String greenUUID;
    private String redUUID;
    private String yellowUUID;
    private String purpleUUID;

    public EntityAyeracoBlue (World par1World) {
        super(par1World, "Blue");
    }

    public void initOthers(EntityAyeraco par2, EntityAyeraco par3, EntityAyeraco par4, EntityAyeraco par5) {
		this.aGreen = par2;
		this.aRed = par3;
		this.aYellow = par4;
		this.aPurple = par5;
	}
	
    @Override
    public void onDeath(DamageSource par1DamageSource) {
    	super.onDeath(par1DamageSource);
    	worldObj.setBlock(beamX, beamY, beamZ, Blocks.air);
    }

    @Override
    protected boolean canBlockProjectiles() {
		if(this.aGreen != null && this.aGreen.abilityActive()) {
			return true;
		}
		return false;
	}
	
    @Override
    protected void tickAbility() {
		this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 2));
		if(this.aGreen != null && !this.aGreen.isDead) {
			aGreen.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 2));
		}
		if(this.aYellow != null && !this.aYellow.isDead) {
			aYellow.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 2));
		}
		if(this.aRed != null && !this.aRed.isDead) {
			aRed.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 2));
		}
		if(this.aPurple != null && !this.aPurple.isDead) {
			aPurple.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1, 2));
		}
	}
	
    @Override
    protected boolean canTeleport() {
		if(this.aPurple != null && this.aPurple.abilityActive()) 
			return true;
		return false;
	}

    @Override
    protected void dropRareDrop(int par1) {
        this.dropItem(VanillaItemsWeapons.blueEnderSword, 1);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.worldObj.isRemote) {
            if (aGreen == null && greenUUID != null) {
                aGreen = (EntityAyeraco)Util.findEntityByUUID(greenUUID, this.worldObj);
                greenUUID = null;
            }
            if (aRed == null && redUUID != null) {
                aRed = (EntityAyeraco)Util.findEntityByUUID(redUUID, this.worldObj);
                redUUID = null;
            }
            if (aYellow == null && yellowUUID != null) {
                aYellow = (EntityAyeraco)Util.findEntityByUUID(yellowUUID, this.worldObj);
                yellowUUID = null;
            }
            if (aPurple == null && purpleUUID != null) {
                aPurple = (EntityAyeraco)Util.findEntityByUUID(purpleUUID, this.worldObj);
                purpleUUID = null;
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        greenUUID = tag.getString("greenUUID");
        redUUID = tag.getString("redUUID");
        yellowUUID = tag.getString("yellowUUID");
        purpleUUID = tag.getString("purpleUUID");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setString("greenUUID", aGreen.getPersistentID().toString());
        tag.setString("redUUID", aRed.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
        tag.setString("purpleUUID", aPurple.getPersistentID().toString());
    }
}