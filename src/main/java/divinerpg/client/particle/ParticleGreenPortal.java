package divinerpg.client.particle;

import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.world.*;
import net.minecraft.particles.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleGreenPortal extends SpriteTexturedParticle
{
    IAnimatedSprite animatedSprite;
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;
    public ParticleGreenPortal(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, IAnimatedSprite sprite)
    {
        this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1.0F, sprite);
    }

    public ParticleGreenPortal(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float scale, IAnimatedSprite sprite)
    {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.portalPosX = this.x = xCoordIn;
        this.portalPosY = this.y = yCoordIn;
        this.portalPosZ = this.z = zCoordIn;
        float var14 = this.random.nextFloat() * 0.6F + 0.4F;
        this.quadSize = this.random.nextFloat() * 0.2F + 0.5F;
        this.bCol = 0.0F;
        this.gCol = 1.0F;
        this.rCol = 0.0F;
        this.lifetime = (int) (Math.random() * 10.0D) + 40;
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
    public void render(IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
        float var8 = (this.age + partialTicks) / this.lifetime;
        var8 = 1.0F - var8;
        var8 *= var8;
        var8 = 1.0F - var8;
        this.quadSize = this.quadSize * var8;
        super.render(buffer, renderInfo, partialTicks);
    }

    @Override
    public void tick()
    {
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

        if (this.age++ >= this.lifetime) {
            this.shouldCull();
        }
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSetIn) {
            this.spriteSet = spriteSetIn;
        }

        @Override
        public Particle createParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ParticleGreenPortal particle = new ParticleGreenPortal(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }
}