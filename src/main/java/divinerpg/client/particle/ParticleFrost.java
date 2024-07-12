package divinerpg.client.particle;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.particle.*;
import net.neoforged.api.distmarker.*;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;

/**
 * Created by LiteWolf101 on Feb
 * /04/2019
 */

@OnlyIn(Dist.CLIENT)
public class ParticleFrost extends TextureSheetParticle
{
    SpriteSet animatedSprite;
    final float rotSpeed;
    float oSize;

    public ParticleFrost(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprite)
    {
        this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1.0F, sprite);
    }

    public ParticleFrost(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float scale, SpriteSet sprite)
    {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.quadSize *= 0.75F;
        this.quadSize *= 0.9F;
        this.oSize = this.quadSize;
        this.lifetime = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
        this.lifetime = (int)((float)this.lifetime * 0.5F);
        float f = (float)Math.random() * 0.4F + 0.6F;
        this.rCol = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * f;
        this.rotSpeed = ((float)Math.random() - 0.9F) * 0.1F;
        this.roll = (float)Math.random() * ((float)Math.PI * 2F);
        this.animatedSprite = sprite;
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
        float f = ((float)this.age + partialTicks) / (float)this.lifetime * 2.0F;
        f = Mth.clamp(f, 0.0F, 1.0F);
        this.quadSize = this.oSize * f;
        super.render(buffer, renderInfo, partialTicks);
    }

    @Override
    public void tick()
    {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.alpha = ((float)this.lifetime - (float)this.age) / 50;

        if (this.age++ >= this.lifetime)
        {
            this.alpha = 0;
            this.remove();
        }

        this.oRoll = this.roll;
        this.roll += (float)Math.PI * this.rotSpeed * 1.0F;


        if (this.onGround)
        {
            this.oRoll = this.roll = 0.0F;
        }

        this.move(this.xd, this.yd, this.zd);
        this.yd -= 0.000300000026077032D;
        this.yd = Math.max(this.yd, -0.04000000059604645D);
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
            ParticleFrost particle = new ParticleFrost(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}