package divinerpg.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.*;
import net.minecraft.particles.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleTar extends SpriteTexturedParticle {
    private final double xStart;
    private final double yStart;
    private final double zStart;

    protected ParticleTar(ClientWorld p_i232417_1_, double p_i232417_2_, double p_i232417_4_, double p_i232417_6_, double p_i232417_8_, double p_i232417_10_, double p_i232417_12_) {
        super(p_i232417_1_, p_i232417_2_, p_i232417_4_, p_i232417_6_);
        this.xd = p_i232417_8_;
        this.yd = p_i232417_10_;
        this.zd = p_i232417_12_;
        this.x = p_i232417_2_;
        this.y = p_i232417_4_;
        this.z = p_i232417_6_;
        this.xStart = this.x;
        this.yStart = this.y;
        this.zStart = this.z;
        this.quadSize = 0.1F * (this.random.nextFloat() * 0.2F + 0.5F);
        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.rCol = f * 0.9F;
        this.gCol = f * 0.3F;
        this.bCol = f;
        this.lifetime = (int)(Math.random() * 10.0D) + 40;
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double p_187110_1_, double p_187110_3_, double p_187110_5_) {
        this.setBoundingBox(this.getBoundingBox().move(p_187110_1_, p_187110_3_, p_187110_5_));
        this.setLocationFromBoundingbox();
    }

    public float getQuadSize(float p_217561_1_) {
        float f = ((float)this.age + p_217561_1_) / (float)this.lifetime;
        f = 1.0F - f;
        f = f * f;
        f = 1.0F - f;
        return this.quadSize * f;
    }

    public int getLightColor(float p_189214_1_) {
        int i = super.getLightColor(p_189214_1_);
        float f = (float)this.age / (float)this.lifetime;
        f = f * f;
        f = f * f;
        int j = i & 255;
        int k = i >> 16 & 255;
        k = k + (int)(f * 15.0F * 16.0F);
        if (k > 240) {
            k = 240;
        }

        return j | k << 16;
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float)this.age / (float)this.lifetime;
            float f1 = -f + f * f * 2.0F;
            float f2 = 1.0F - f1;
            this.x = this.xStart + this.xd * (double)f2;
            this.y = this.yStart + this.yd * (double)f2 + (double)(1.0F - f);
            this.z = this.zStart + this.zd * (double)f2;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite p_i50607_1_) {
            this.sprite = p_i50607_1_;
        }

        public Particle createParticle(BasicParticleType p_199234_1_, ClientWorld p_199234_2_, double p_199234_3_, double p_199234_5_, double p_199234_7_, double p_199234_9_, double p_199234_11_, double p_199234_13_) {
            ParticleTar portalparticle = new ParticleTar(p_199234_2_, p_199234_3_, p_199234_5_, p_199234_7_, p_199234_9_, p_199234_11_, p_199234_13_);
            portalparticle.pickSprite(this.sprite);
            return portalparticle;
        }
    }
}
