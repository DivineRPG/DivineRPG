package divinerpg.client.particle;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.world.*;
import net.minecraft.particles.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleEnderTriplet extends SpriteTexturedParticle {

        IAnimatedSprite animatedSprite;
    private float sparkleParticleScale;
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;
    public ParticleEnderTriplet(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, IAnimatedSprite sprite)
            {
            this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1.0F, sprite);
            }

    public ParticleEnderTriplet(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float scale, IAnimatedSprite sprite)
            {
            super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);
                this.xd = xSpeed + (float) (Math.random() * 2.0D - 1.0D) * 0.05F;
                this.yd = ySpeed + (float) (Math.random() * 2.0D - 1.0D) * 0.05F;
                this.zd = zSpeed + (float) (Math.random() * 2.0D - 1.0D) * 0.05F;
                float var14 = this.random.nextFloat() * 0.6F + 0.4F;
                this.quadSize = this.random.nextFloat() * 0.2F + 0.5F;
                this.rCol = this.gCol = this.bCol = 1.0F * var14;
                this.gCol *= 0.3F;
                this.rCol *= 0.9F;
                this.quadSize = this.random.nextFloat() * this.random.nextFloat() * 6.0F + 1.0F;
                this.lifetime = (int) (16.0D / (this.random.nextFloat() * 0.8D + 0.2D)) + 2;
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
    public void render(IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
            float var8 = (this.age + partialTicks) / this.lifetime;
            var8 = 1.0F - var8;
            var8 *= var8;
            var8 = 1.0F - var8;
            this.quadSize = this.quadSize * var8;
            super.render(buffer, renderInfo, partialTicks);
            }

    @Override
    public void tick()  {
           this.xo = this.x;
           this.yo = this.y;
           this.zo = this.z;

           if (this.age++ >= this.lifetime) {
               this.shouldCull();
           }

           this.yd += 0.004D;
           this.xd *= 0.8999999761581421D;
           this.yd *= 0.8999999761581421D;
           this.zd *= 0.8999999761581421D;

           if (this.onGround) {
               this.xd *= 0.699999988079071D;
               this.zd *= 0.699999988079071D;
          }
    }

    @Override
    public IParticleRenderType getRenderType() {
            return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
            }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSetIn) {
            this.spriteSet = spriteSetIn;
        }

        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ParticleEnderTriplet particle = new ParticleEnderTriplet(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}