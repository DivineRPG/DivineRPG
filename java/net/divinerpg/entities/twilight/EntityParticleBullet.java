package net.divinerpg.entities.twilight;

import java.awt.Color;

import net.divinerpg.DivineRPG;
import net.divinerpg.entities.fx.EntityColoredFX;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityParticleBullet extends EntityShooterBullet {
		
	public EntityParticleBullet(World w) {
		super(w);
	}

	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, String texture, String particle) {
		super(world, entity, damage, texture);
		this.setParticle(particle);
	}
	
	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, Item ammo, String particle) {
		super(world, entity, damage, ammo);
		this.setParticle(particle);
	}
	
	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, String texture, Color c) {
		super(world, entity, damage, texture);
		this.setColor(c);
	}
	
	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, Item ammo, Color c) {
		super(world, entity, damage, ammo);
		this.setColor(c);
	}
	
	public EntityParticleBullet(World world, double posX, double posY, double posZ, float damage, String texture, Color c) {
		super(world, posX, posY, posZ, damage, texture);
		this.setColor(c);
	}
	
	@Override
	public void entityInit() {
	    super.entityInit();
	    this.dataWatcher.addObject(19, 0);
	    this.dataWatcher.addObject(20, 0);
	    this.dataWatcher.addObject(21, 0);
	    this.dataWatcher.addObject(22, "");
	    this.dataWatcher.addObject(23, 0);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setString("Particle", this.getParticle());
		tag.setInteger("Red", this.getColor().getRed());
		tag.setInteger("Green", this.getColor().getGreen());
		tag.setInteger("Blue", this.getColor().getBlue());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.setParticle(tag.getString("Particle"));
		if(tag.hasKey("Red")) {
			this.setColor(new Color(tag.getInteger("Red"), tag.getInteger("Green"), tag.getInteger("Blue")));
		}
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.getParticle().equals("")) {
        	for (int var3 = 0; var3 < 8; ++var3) {
        		DivineRPG.proxy.spawnParticle(this.worldObj, this.posX, this.posY, this.posZ, this.getParticle(), true);
        	}
        } else {
        	for (int var3 = 0; var3 < 8; ++var3) {
        		EntityColoredFX e = new EntityColoredFX(this.worldObj, this.posX+(rand.nextDouble()-rand.nextDouble())/4, this.posY+(rand.nextDouble()-rand.nextDouble())/4, this.posZ+(rand.nextDouble()-rand.nextDouble())/4, 0, 0, 0, this.getColor());
        		if(this.getBiggerParticles()) e.bigger = true;
        		FMLClientHandler.instance().getClient().effectRenderer.addEffect(e);
        	}
        }
    }
	public EntityParticleBullet setMoreParticles() {
		this.setBiggerParticles();
		return this;
	}
	
	public void setColor(Color c) {
	    this.dataWatcher.updateObject(19, c.getRed());
	    this.dataWatcher.updateObject(20, c.getGreen());
	    this.dataWatcher.updateObject(21, c.getBlue());
	}
	
	public Color getColor() {
	    return new Color(this.dataWatcher.getWatchableObjectInt(19), this.dataWatcher.getWatchableObjectInt(20), this.dataWatcher.getWatchableObjectInt(21));
	}

	public String getParticle() {
	    return this.dataWatcher.getWatchableObjectString(22);
	}
	
	public void setParticle(String p) {
        this.dataWatcher.updateObject(22, p);
    }
	
	public void setBiggerParticles() {
	    this.dataWatcher.updateObject(23, 1);
	}
	
	public boolean getBiggerParticles() {
        return this.dataWatcher.getWatchableObjectInt(23) == 1;
    }
}
