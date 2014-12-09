package net.divinerpg.entities.twilight;

import net.divinerpg.DivineRPG;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityParticleBullet extends EntityShooterBullet {
	
	private String particle;
	
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
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setString("particle", this.particle);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.particle = tag.getString("particle");
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();

        for (int var3 = 0; var3 < 8; ++var3) {
            DivineRPG.proxy.spawnParticle(this.worldObj, this.posX, this.posY, this.posZ, this.particle, true);
        }
    }


}
