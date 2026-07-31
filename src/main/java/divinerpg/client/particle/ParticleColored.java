package divinerpg.client.particle;

import divinerpg.client.particle.options.ParticleColouredOption;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import javax.annotation.Nullable;

public class ParticleColored extends SimpleAnimatedParticle {

    private double portalPosX, portalPosY, portalPosZ;

    protected ParticleColored(ClientLevel world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, SpriteSet pSprites, int red, int green, int blue) {
        super(world, x, y, z, pSprites, -0.05F);
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.quadSize *= 0.75F;
        this.lifetime = 60 + this.random.nextInt(12);
        this.portalPosX = this.x = x;
        this.portalPosY = this.y = y;
        this.portalPosZ = this.z = z;
        this.setSpriteFromAge(pSprites);
        this.setColor(red / 255F, green / 255F, blue / 255F);
        this.friction = 0.6F;
    }

    @Override
    public Layer getLayer() {
        return Layer.OPAQUE;
    }

    @Override
    public int getLightCoords(float partialTick) {
        int light = super.getLightCoords(partialTick);
        float ageFactor = (float) this.age / (float) this.lifetime;
        ageFactor *= ageFactor;
        ageFactor *= ageFactor;
        int blockLight = light & 255;
        int skyLight = light >> 16 & 255;
        skyLight += (int) (ageFactor * 15.0F * 16.0F);
        if (skyLight > 240) skyLight = 240;
        return blockLight | skyLight << 16;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        float ageRatio = (float) this.age / (float) this.lifetime;
        float progress = ageRatio;
        ageRatio = -ageRatio + ageRatio * ageRatio * 2.0F;
        ageRatio = 1.0F - ageRatio;
        this.x = this.portalPosX + this.xd * ageRatio;
        this.y = this.portalPosY + this.yd * ageRatio + (1.0F - progress);
        this.z = this.portalPosZ + this.zd * ageRatio;
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
    }

    public static class Provider implements ParticleProvider<ParticleColouredOption> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        @Nullable
        @Override
        public Particle createParticle(ParticleColouredOption data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource randomSource) {
            return new ParticleColored(level, x, y, z, xSpeed, ySpeed, zSpeed, sprites, (int)(data.getRed() * 255), (int)(data.getGreen() * 255), (int)(data.getBlue() * 255));
        }
    }
}