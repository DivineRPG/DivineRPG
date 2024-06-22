package divinerpg.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticlePortal extends TextureSheetParticle {
    SpriteSet animatedSprite;
    private final float portalParticleScale;
    private final double portalPosX, portalPosY, portalPosZ;
    public ParticlePortal(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float r, float g, float b, SpriteSet sprite) {
        this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1, r, g, b, sprite);
    }
    public ParticlePortal(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float scale, float r, float g, float b, SpriteSet sprite) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);
        xd = yd = zd = 0;
        quadSize *= .8;
        quadSize *= .9;
        lifetime = (int)(32 / (Math.random() * .8 + .2));
        lifetime = (int)((float)lifetime * .5);
        portalParticleScale = quadSize;
        portalPosX = x = xCoordIn;
        portalPosY = y = yCoordIn;
        portalPosZ = z = zCoordIn;
        rCol = r;
        gCol = g;
        bCol = b;
        animatedSprite = sprite;
    }
    @Override protected int getLightColor(float partialTick) {
        int var2 = super.getLightColor(partialTick);
        float var3 = (float)age / (float)lifetime;
        var3 *= var3;
        var3 *= var3;
        int var4 = var2 & 255;
        int var5 = var2 >> 16 & 255;
        var5 += (int)(var3 * 15 * 16);
        if(var5 > 240) var5 = 240;
        return var4 | var5 << 16;
    }
    @Override public void render(VertexConsumer buffer, Camera renderInfo, float partialTicks) {
        float var8 = (age + partialTicks) / lifetime * 2;
        var8 = 1 - var8;
        var8 *= var8;
        var8 = 1 - var8;
        quadSize = portalParticleScale * var8;
        super.render(buffer, renderInfo, partialTicks);
    }
    @Override public void tick() {
        xo = x;
        yo = y;
        zo = z;
        float var1 = (float)age / (float)lifetime;
        float var2 = var1;
        var1 = -var1 + var1 * var1 * 2;
        var1 = 1 - var1;
        x = portalPosX + xd * var1;
        y = portalPosY + yd * var1 + (1 - var2);
        z = portalPosZ + zd * var1;
        if(age++ >= lifetime) remove();
    }
    @Override public ParticleRenderType getRenderType() {return ParticleRenderType.PARTICLE_SHEET_OPAQUE;}
    @OnlyIn(Dist.CLIENT)
    public static class EdenProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public EdenProvider(SpriteSet spriteSet) {sprites = spriteSet;}
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticlePortal particle = new ParticlePortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, .95F, world.random.nextFloat() * .4F + .6F, .24F, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class WildwoodProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public WildwoodProvider(SpriteSet spriteSet) {sprites = spriteSet;}
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticlePortal particle = new ParticlePortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0, world.random.nextFloat() * .6F + .4F, 1, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class ApalachiaProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public ApalachiaProvider(SpriteSet spriteSet) {sprites = spriteSet;}
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticlePortal particle = new ParticlePortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, world.random.nextFloat() * .6F + .4F, 0, .87F, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class SkythernProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public SkythernProvider(SpriteSet spriteSet) {sprites = spriteSet;}
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            float f = world.random.nextFloat() * .1F + .8F;
            ParticlePortal particle = new ParticlePortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, f, f, f, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class MortumProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public MortumProvider(SpriteSet spriteSet) {sprites = spriteSet;}
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            float f = world.random.nextFloat() * .4F + .1F;
            ParticlePortal particle = new ParticlePortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, f, f, f, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class HaliteProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public HaliteProvider(SpriteSet spriteSet) {sprites = spriteSet;}
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticlePortal particle = new ParticlePortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 0, world.random.nextFloat() * .6F + .3F, .3F, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class TwilightProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;
        public TwilightProvider(SpriteSet spriteSet) {sprites = spriteSet;}
        public Particle createParticle(SimpleParticleType type, ClientLevel world, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {
            ParticlePortal particle = new ParticlePortal(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, world.random.nextFloat() * .6F + .2F, 0, 0, sprites);
            particle.pickSprite(sprites);
            return particle;
        }
    }
}