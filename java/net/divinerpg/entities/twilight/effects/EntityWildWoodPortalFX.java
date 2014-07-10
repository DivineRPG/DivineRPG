package net.divinerpg.entities.twilight.effects;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityWildWoodPortalFX extends EntityFX {

	private float portalParticleScale;
	private double portalPosX, portalPosY, portalPosZ;

	public EntityWildWoodPortalFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.motionX = var8;
		this.motionY = var10;
		this.motionZ = var12;
		this.portalPosX = this.posX = var2;
		this.portalPosY = this.posY = var4;
		this.portalPosZ = this.posZ = var6;
		float var14 = this.rand.nextFloat() * 0.6F + 0.4F;
		this.portalParticleScale = this.particleScale = this.rand.nextFloat() * 0.2F + 0.5F;
		this.particleBlue = 1.0F;
		this.particleGreen = 0.0F;
		this.particleRed = 0.0F;
		this.particleMaxAge = (int)(Math.random() * 10.0D) + 40;
		this.noClip = true;
		this.setParticleTextureIndex((int)(Math.random() * 8.0D));
	}

	@Override
	public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = (this.particleAge + var2) / this.particleMaxAge;
		var8 = 1.0F - var8;
		var8 *= var8;
		var8 = 1.0F - var8;
		this.particleScale = this.portalParticleScale * var8;
		super.renderParticle(var1, var2, var3, var4, var5, var6, var7);
	}

	@Override
	public int getBrightnessForRender(float var1) {
		int var2 = super.getBrightnessForRender(var1);
		float var3 = (float)this.particleAge / (float)this.particleMaxAge;
		var3 *= var3;
		var3 *= var3;
		int var4 = var2 & 255;
		int var5 = var2 >> 16 & 255;
		var5 += (int)(var3 * 15.0F * 16.0F);
		if(var5 > 240) 
			var5 = 240;
		return var4 | var5 << 16;
	}

	@Override
	public float getBrightness(float var1) {
		float var2 = super.getBrightness(var1);
		float var3 = (float)this.particleAge / (float)this.particleMaxAge;
		var3 = var3 * var3 * var3 * var3;
		return var2 * (1.0F - var3) + var3;
	}
 
	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		float var1 = (float)this.particleAge / (float)this.particleMaxAge;
		float var2 = var1;
		var1 = -var1 + var1 * var1 * 2.0F;
		var1 = 1.0F - var1;
		this.posX = this.portalPosX + this.motionX * var1;
		this.posY = this.portalPosY + this.motionY * var1 + (1.0F - var2);
		this.posZ = this.portalPosZ + this.motionZ * var1;
		if(this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
		}
	}
}