package divinerpg.client.particle;

import divinerpg.client.particle.options.ParticleColouredType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraftforge.api.distmarker.*;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
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
        this.setColor(red/255F, green/255F, blue/255F);
        friction = 0.6F;
    }


    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float partialTick) {
        int var2 = super.getLightColor(partialTick);
        float var3 = (float) this.age / (float) this.lifetime;
        var3 *= var3;
        var3 *= var3;
        int var4 = var2 & 255;
        int var5 = var2 >> 16 & 255;
        var5 += (int) (var3 * 15.0F * 16.0F);
        if (var5 > 240)
            var5 = 240;
        return var4 | var5 << 16;
    }

    public void tick() {
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
        if (this.age++ >= this.lifetime)
            this.remove();
    }

    public static class Provider implements ParticleProvider<ParticleColouredType.ParticleColour> {

        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        @Nullable
        @Override
        public Particle createParticle(ParticleColouredType.ParticleColour data, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new ParticleColored(level, x, y, z, xSpeed, ySpeed, zSpeed, sprites, data.getRed(), data.getGreen(), data.getBlue());
        }
    }
}
