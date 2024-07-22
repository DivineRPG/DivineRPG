package divinerpg.client.particle;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.particle.*;
import net.neoforged.api.distmarker.*;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;

@OnlyIn(Dist.CLIENT)
public class ParticleEnderTriplet extends TextureSheetParticle {

        SpriteSet animatedSprite;
//    private double portalPosX;
//    private double portalPosY;
//    private double portalPosZ;
//    private float portalParticleScale;
    public ParticleEnderTriplet(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprite)
            {
            this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1.0F, sprite);
            }

    public ParticleEnderTriplet(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float scale, SpriteSet sprite)
            {
            super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);
                this.xd = 0;
                this.yd = 0;
                this.zd = 0;
                this.quadSize *= 0.75F;
                this.quadSize *= 0.9F;
//                this.portalParticleScale = this.quadSize;
                this.lifetime = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
                this.lifetime = (int)((float)this.lifetime * 0.5F);
//                this.portalPosX = this.x = xCoordIn;
//                this.portalPosY = this.y = yCoordIn;
//                this.portalPosZ = this.z = zCoordIn;
                float f = (float)Math.random() * 0.4F + 0.6F;
                this.animatedSprite = sprite;
                this.rCol = this.gCol = this.bCol = 1.0F * f;
                this.gCol *= 0.3F;
                this.rCol *= 0.9F;
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

//           if (this.age++ >= this.lifetime) {
//               this.shouldCull();
//           }

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
            ParticleEnderTriplet particle = new ParticleEnderTriplet(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}