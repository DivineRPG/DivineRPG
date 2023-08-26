package divinerpg.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.core.particles.*;
import net.minecraftforge.api.distmarker.*;

import net.minecraft.client.multiplayer.ClientLevel;

@OnlyIn(Dist.CLIENT)
public class ParticleTar extends TextureSheetParticle {
    SpriteSet sprites;
    protected ParticleTar(ClientLevel p_i232417_1_, double p_i232417_2_, double p_i232417_4_, double p_i232417_6_, double p_i232417_8_, double p_i232417_10_, double p_i232417_12_, SpriteSet sprite) {
        super(p_i232417_1_, p_i232417_2_, p_i232417_4_, p_i232417_6_);
        this.gravity = 0.75F;
        this.friction = 0.999F;
        this.xd *= (double)0.8F;
        this.yd *= (double)0.8F;
        this.zd *= (double)0.8F;
        this.yd = (double)(this.random.nextFloat() * 0.4F + 0.05F);
        this.quadSize *= this.random.nextFloat() * 2.0F + 0.2F;
        this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        float f = (float)Math.random() * 0.4F + 0.6F;
        this.bCol = 1.0F * f;
        this.roll = (float)Math.random() * ((float)Math.PI * 2F);
        this.sprites = sprite;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double p_187110_1_, double p_187110_3_, double p_187110_5_) {
        this.setBoundingBox(this.getBoundingBox().move(p_187110_1_, p_187110_3_, p_187110_5_));
        this.setLocationFromBoundingbox();
    }

    public float getQuadSize(float p_217561_1_) {
        float f = ((float)this.age + p_217561_1_) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f);
    }

    public int getLightColor(float p_189214_1_) {
        int i = super.getLightColor(p_189214_1_);
        int k = i >> 16 & 255;
        return 240 | k << 16;
    }

    public void tick() {
        super.tick();
        if (!this.removed) {
            float f = (float)this.age / (float)this.lifetime;
            if (this.random.nextFloat() > f) {
                this.level.addParticle(ParticleTypes.SMOKE, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleTar particle = new ParticleTar(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}
