package divinerpg.client.particle;


import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.world.*;
import net.minecraft.particles.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleWildwoodPortal extends SpriteTexturedParticle {

	private float portalParticleScale;
	private double portalPosX, portalPosY, portalPosZ;

	protected ParticleWildwoodPortal(ClientWorld var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public ParticleWildwoodPortal(ClientWorld var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.xd = var8;
		this.yd = var10;
		this.zd = var12;
		this.portalPosX = this.x = var2;
		this.portalPosY = this.y = var4;
		this.portalPosZ = this.z = var6;
		float var14 = this.random.nextFloat() * 0.6F + 0.4F;
		this.portalParticleScale = this.quadSize = this.random.nextFloat() * 0.2F + 0.5F;
		this.bCol = 1.0F;
		this.gCol = 0.0F;
		this.rCol = 0.0F;
		this.lifetime = (int)(Math.random() * 10.0D) + 40;
	}

	@Override
	public int getLightColor(float var1) {
		int var2 = super.getLightColor(var1);
		float var3 = (float)this.age / (float)this.lifetime;
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
	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		float var1 = (float)this.age / (float)this.lifetime;
		float var2 = var1;
		var1 = -var1 + var1 * var1 * 2.0F;
		var1 = 1.0F - var1;
		this.xd = this.portalPosX + this.x * var1;
		this.yd = this.portalPosY + this.y * var1 + (1.0F - var2);
		this.zd = this.portalPosZ + this.z * var1;
		if(this.age++ >= this.lifetime) {
			this.shouldCull();
		}
	}

	@Override
	public void render(IVertexBuilder p_225606_1_, ActiveRenderInfo p_225606_2_, float partialTicks) {
		float var8 = (this.age + lifetime) / this.lifetime;
		var8 = 1.0F - var8;
		var8 *= var8;
		var8 = 1.0F - var8;
		this.scale(portalParticleScale * var8);
	}

	@Override
	public IParticleRenderType getRenderType() {
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			ParticleWildwoodPortal particle = new ParticleWildwoodPortal(worldIn, x, y, z);
			particle.setSpriteFromAge(this.spriteSet);
			return particle;
		}
	}
}