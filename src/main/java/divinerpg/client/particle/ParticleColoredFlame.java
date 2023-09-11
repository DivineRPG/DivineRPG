package divinerpg.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleColoredFlame extends RisingParticle {
//    private final float flameScale;
//    private SpriteSet sprite;

    protected ParticleColoredFlame(ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, float r, float g, float b, SpriteSet sprite) {
        super(world, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        this.xd = this.xd * 0.009999999776482582D + xSpeedIn;
        this.yd = this.yd * 0.009999999776482582D + ySpeedIn;
        this.zd = this.zd * 0.009999999776482582D + zSpeedIn;
        this.x += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
        this.y += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
        this.z += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
//        this.flameScale = this.quadSize;
        this.rCol = r;
        this.gCol = g;
        this.bCol = b;
        this.lifetime = (int) (8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
//        this.sprite = sprite;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
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
        f = Mth.clamp(f, 0.0F, 1.0F);
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
    public static class AquaProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public AquaProvider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0, 1.0F, 1.0F, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class BlackProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public BlackProvider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0.4F, 0.4F, 0.4F, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class GreenProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public GreenProvider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0.627F, 0.12549F, 0.941F, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class PurpleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public PurpleProvider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticleColoredFlame particle = new ParticleColoredFlame(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0.466F, 0.866F, 0.466F, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}