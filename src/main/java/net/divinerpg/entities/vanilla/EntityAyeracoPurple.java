package net.divinerpg.entities.vanilla;

import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsWeapons;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityAyeracoPurple extends EntityAyeraco {
	
    private EntityAyeraco aGreen;
    private EntityAyeraco aBlue;
    private EntityAyeraco aRed;
    private EntityAyeraco aYellow;
    private String greenUUID;
    private String blueUUID;
    private String redUUID;
    private String yellowUUID;

    public EntityAyeracoPurple (World par1World) {
        super(par1World, "Purple");
    }

    public void initOthers (EntityAyeraco par2, EntityAyeraco par3, EntityAyeraco par4, EntityAyeraco par5) {
		this.aGreen = par2;
		this.aBlue = par3;
		this.aRed = par4;
		this.aYellow = par5;
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
            if (aRed == null && redUUID != null) {
                aRed = (EntityAyeraco)Util.findEntityByUUID(redUUID, this.worldObj);
                redUUID = null;
            }
            if (aYellow == null && yellowUUID != null) {
                aYellow = (EntityAyeraco)Util.findEntityByUUID(yellowUUID, this.worldObj);
                yellowUUID = null;
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        greenUUID = tag.getString("greenUUID");
        blueUUID = tag.getString("blueUUID");
        redUUID = tag.getString("redUUID");
        yellowUUID = tag.getString("yellowUUID");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setString("greenUUID", aGreen.getPersistentID().toString());
        tag.setString("blueUUID", aBlue.getPersistentID().toString());
        tag.setString("redUUID", aRed.getPersistentID().toString());
        tag.setString("yellowUUID", aYellow.getPersistentID().toString());
    }
}