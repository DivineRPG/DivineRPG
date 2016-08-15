package net.divinerpg.entities.vanilla;

import java.util.UUID;

import net.divinerpg.utils.LogHelper;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAyeracoGreen extends EntityAyeraco {
	
    private EntityAyeraco aBlue;
    private EntityAyeraco aRed;
    private EntityAyeraco aYellow;
    private EntityAyeraco aPurple;
    private String blueUUID;
    private String redUUID;
    private String yellowUUID;
    private String purpleUUID;

    public EntityAyeracoGreen (World par1World) {
        super (par1World, "Green");
    }

    public void initOthers (EntityAyeraco par2, EntityAyeraco par3, EntityAyeraco par4, EntityAyeraco par5) {
		this.aBlue = par2;
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
        this.dropItem(VanillaItemsWeapons.greenEnderSword, 1);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.worldObj.isRemote) {
            if (aBlue == null && blueUUID != null) {
                aBlue = (EntityAyeraco)Util.findEntityByUUID(blueUUID, this.worldObj);
                blueUUID = null;
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

        blueUUID = tag.getString("blueUUID");
        redUUID = tag.getString("redUUID");
        yellowUUID = tag.getString("yellowUUID");
        purpleUUID = tag.getString("purpleUUID");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setString("blueUUID", aBlue.getPersistentID().toString());
        tag.setString("redUUID", aRed.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
        tag.setString("purpleUUID", aPurple.getPersistentID().toString());
    }
}