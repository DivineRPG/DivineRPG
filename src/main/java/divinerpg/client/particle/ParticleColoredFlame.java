package divinerpg.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.*;
import net.minecraft.particles.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleColoredFlame extends SpriteTexturedParticle {
    private final float flameScale;

    protected ParticleColoredFlame(ClientWorld world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, float r, float g, float b) {
        super(world, xCoordIn, yCoordIn, zCoordIn);
        this.xd = this.xd * 0.009999999776482582D + xSpeedIn;
        this.yd = this.yd * 0.009999999776482582D + ySpeedIn;
        this.zd = this.zd * 0.009999999776482582D + zSpeedIn;
        this.x += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
        this.y += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
        this.z += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
        this.flameScale = this.quadSize;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
        this.lifetime = (int) (8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
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
            this.shouldCull();
        }

        this.move(this.xd, this.yd, this.zd);
        this.xd *= 0.9599999785423279D;
        this.yd *= 0.9599999785423279D;
        this.zd *= 0.9599999785423279D;

        if (this.onGround) {
            this.xd *= 0.699999988079071D;
            this.zd *= 0.699999988079071D;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(BasicParticleType type, ClientWorld world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
            ParticleColoredFlame portalparticle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn, 0, 0, 0);
            portalparticle.pickSprite(this.sprite);
            return portalparticle;
        }
    }
}