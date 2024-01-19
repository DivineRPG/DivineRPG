package divinerpg.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleWildwoodPortal extends TextureSheetParticle {

	SpriteSet spriteSet;
	private final float portalParticleScale;
	private final double portalPosX, portalPosY, portalPosZ;

	public ParticleWildwoodPortal(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprite)
	{
		this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1.0F, sprite);
	}

	public ParticleWildwoodPortal(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float scale, SpriteSet sprite)
	{
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);
		this.xd = 0;
		this.yd = 0;
		this.zd = 0;
		this.quadSize *= 0.8F;
		this.quadSize *= 0.9F;
		this.portalParticleScale = this.quadSize;
		this.lifetime = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
		this.lifetime = (int)((float)this.lifetime * 0.5F);
		this.portalPosX = this.x = xCoordIn;
		this.portalPosY = this.y = yCoordIn;
		this.portalPosZ = this.z = zCoordIn;
		this.bCol = 1.0F;
		this.gCol = (float)Math.random() * 0.6F + 0.4F;;
		this.rCol = 0.0F;
		this.spriteSet = sprite;
	}
	@Override
	protected int getLightColor(float partialTick) {
		int var2 = super.getLightColor(partialTick);
		float var3 = (float) this.age / (float) this.lifetime;
		var3 *= var3;
		var3 *= var3;
		int var4 = var2 & 255;
		int var5 = var2 >> 16 & 255;
		var5 += (int) (var3 * 15.0F * 16.0F);

		if (var5 > 240) {
			var5 = 240;
		}

		return var4 | var5 << 16;
	}


	@Override
	public void render(VertexConsumer buffer, Camera renderInfo, float partialTicks) {
		float var8 = (this.age + partialTicks) / this.lifetime * 2.0F;
		var8 = 1.0F - var8;
		var8 *= var8;
		var8 = 1.0F - var8;
		this.quadSize = this.portalParticleScale * var8;
		super.render(buffer, renderInfo, partialTicks);
	}

	@Override
	public void tick()
	{
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		float var1 = (float) this.age / (float) this.lifetime;
		float var2 = var1;
		var1 = -var1 + var1 * var1 * 2.0F;
		var1 = 1.0F - var1;
		this.x = this.portalPosX + this.xd * var1;
		this.y = this.portalPosY + this.yd * var1 + (1.0F - var2);
		this.z = this.portalPosZ + this.zd * var1;
		if (this.age++ >= this.lifetime) {
			this.remove();
		}
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprites;

		public Provider(SpriteSet spriteSet) {
			this.sprites = spriteSet;
		}

		public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
			ParticleWildwoodPortal particle = new ParticleWildwoodPortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, sprites);
			particle.pickSprite(this.sprites);
			return particle;
		}
	}
}