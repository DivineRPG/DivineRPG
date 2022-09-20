package divinerpg.client.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.*;
import net.minecraft.particles.*;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleColoredFlame extends RisingParticle {
    private final float flameScale;
    private IAnimatedSprite sprite;

    protected ParticleColoredFlame(ClientWorld world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, float r, float g, float b, IAnimatedSprite sprite) {
        super(world, xCoordIn, yCoordIn, zCoordIn, (float) xSpeedIn, (float) ySpeedIn, (float) zSpeedIn, 0, 0, 0, 0, sprite, 0.5F, 20, -0.004D, false);
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
        this.sprite = sprite;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double p_106817_, double p_106818_, double p_106819_) {
        this.setBoundingBox(this.getBoundingBox().move(p_106817_, p_106818_, p_106819_));
        this.setLocationFromBoundingbox();
    }

    public float getQuadSize(float p_106824_) {
        float f = ((float)this.age + p_106824_) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f * 0.5F);
    }

    public int getLightColor(float p_106821_) {
        float f = ((float)this.age + p_106821_) / (float)this.lifetime;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        int i = super.getLightColor(p_106821_);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    @OnlyIn(Dist.CLIENT)
    public static class AquaProvider implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprites;

        public AquaProvider(IAnimatedSprite spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(BasicParticleType type, ClientWorld world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0, 1.0F, 1.0F, sprites);
            particle.pickSprite(this.sprites);
            particle.setColor(0, 1, 1);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class BlackProvider implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprites;

        public BlackProvider(IAnimatedSprite spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(BasicParticleType type, ClientWorld world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0, 0F, 0F, sprites);
            particle.pickSprite(this.sprites);
            particle.setColor(0, 0, 0);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class GreenProvider implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprites;

        public GreenProvider(IAnimatedSprite spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(BasicParticleType type, ClientWorld world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0.466F, 0.866F, 0.466F, sprites);
            particle.pickSprite(this.sprites);
            particle.setColor(0.627F, 0.12549F, 0.941F);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class PurpleProvider implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprites;

        public PurpleProvider(IAnimatedSprite spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(BasicParticleType type, ClientWorld world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0.627F, 0.12549F, 0.941F, sprites);
            particle.pickSprite(this.sprites);
            particle.setColor(0.466F, 0.866F, 0.466F);
            return particle;
        }
    }
}