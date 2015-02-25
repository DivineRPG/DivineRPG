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
	
	private String particle = "";
	private Color color;
	private boolean lotsOfParticles;
	
	public EntityParticleBullet(World w) {
		super(w);
	}

	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, String texture, String particle) {
		super(world, entity, damage, texture);
		this.particle = particle;
	}
	
	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, Item ammo, String particle) {
		super(world, entity, damage, ammo);
		this.particle = particle;
	}
	
	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, String texture, Color c) {
		super(world, entity, damage, texture);
		this.color = c;
	}
	
	public EntityParticleBullet(World world, EntityLivingBase entity, float damage, Item ammo, Color c) {
		super(world, entity, damage, ammo);
		this.color = c;
	}
	
	public EntityParticleBullet(World world, double posX, double posY, double posZ, float damage, String texture, Color c) {
		super(world, posX, posY, posZ, damage, texture);
		this.color = c;
	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setString("Particle", this.particle);
		if(this.color != null) {
			tag.setInteger("Red", this.color.getRed());
			tag.setInteger("Green", this.color.getGreen());
			tag.setInteger("Blue", this.color.getBlue());
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.particle = tag.getString("Particle");
		if(tag.hasKey("Red")) {
			this.color = new Color(tag.getInteger("Red"), tag.getInteger("Green"), tag.getInteger("Blue"));
		}
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(this.color == null) {
        	for (int var3 = 0; var3 < 8; ++var3) {
        		DivineRPG.proxy.spawnParticle(this.worldObj, this.posX, this.posY, this.posZ, this.particle, true);
        	}
        } else {
        	for (int var3 = 0; var3 < 8; ++var3) {
        		EntityColoredFX e = new EntityColoredFX(this.worldObj, this.posX+(rand.nextDouble()-rand.nextDouble())/4, this.posY+(rand.nextDouble()-rand.nextDouble())/4, this.posZ+(rand.nextDouble()-rand.nextDouble())/4, 0, 0, 0, this.color);
        		if(this.lotsOfParticles) e.bigger = true;
        		FMLClientHandler.instance().getClient().effectRenderer.addEffect(e);
        	}
        }
    }
	public EntityParticleBullet setMoreParticles() {
		this.lotsOfParticles = true;
		return this;
	}

}
