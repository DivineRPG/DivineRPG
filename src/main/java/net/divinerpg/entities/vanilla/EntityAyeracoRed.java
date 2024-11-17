package net.divinerpg.entities.vanilla;

import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAyeracoRed extends EntityAyeraco {
	
    private EntityAyeraco aGreen;
    private EntityAyeraco aBlue;
    private EntityAyeraco aYellow;
    private EntityAyeraco aPurple;
    private String greenUUID;
    private String blueUUID;
    private String yellowUUID;
    private String purpleUUID;
    private int healTick;

    public EntityAyeracoRed (World par1World) {
        super(par1World, "Red");
        this.healTick = 0;
    }

    public void initOthers (EntityAyeraco par2, EntityAyeraco par3, EntityAyeraco par4, EntityAyeraco par5) {
		this.aGreen = par2;
		this.aBlue = par3;
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
		if (this.aGreen != null && this.aGreen.abilityActive()) {
			return true;
		}
		return false;
	}
	
    @Override
    protected void tickAbility() {
		if (this.healTick == 0) {
			if (this.aGreen != null && !this.aGreen.isDead) {
				aGreen.heal(1);
			}
			if (this.aBlue != null && !this.aBlue.isDead) {
				aBlue.heal(1);
			}
			if (this.aYellow != null && !this.aYellow.isDead) {
				aYellow.heal(1);
			}
			if (this.aPurple != null && !this.aPurple.isDead) {
				aPurple.heal(1);
			}
		} else {
			healTick--;
		}
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
        this.dropItem(VanillaItemsWeapons.redEnderSword, 1);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.worldObj.isRemote) {
            if (aGreen == null && greenUUID != null) {
                aGreen = (EntityAyeraco)Util.findEntityByUUID(greenUUID, this.worldObj);
                greenUUID = null;
            }
            if (aBlue == null && blueUUID != null) {
                aBlue = (EntityAyeraco)Util.findEntityByUUID(blueUUID, this.worldObj);
                blueUUID = null;
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
        blueUUID = tag.getString("blueUUID");
        yellowUUID = tag.getString("yellowUUID");
        purpleUUID = tag.getString("purpleUUID");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setString("greenUUID", aGreen.getPersistentID().toString());
        tag.setString("blueUUID", aBlue.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
        tag.setString("purpleUUID", aPurple.getPersistentID().toString());
    }
}