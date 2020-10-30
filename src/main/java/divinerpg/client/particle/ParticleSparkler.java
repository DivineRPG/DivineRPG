package divinerpg.client.particle;


import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ParticleSparkler extends Particle {

    private float sparkleParticleScale;
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;

    public ParticleSparkler(ClientWorld var1, double var2, double var4, double var6, double var8, double var10,
                            double var12) {
        super(var1, var2, var4, var6, var8, var10, var12);
        this.motionX = var8;
        this.motionY = var10;
        this.motionZ = var12;
        this.portalPosX = this.posX = var2;
        this.portalPosY = this.posY = var4;
        this.portalPosZ = this.posZ = var6;
        this.rand.nextFloat();
        this.sparkleParticleScale = this.rand.nextFloat() * 0.2F + 0.5F;
        this.particleBlue = (float) this.rand.nextGaussian();
        this.particleGreen = (float) this.rand.nextGaussian();
        this.particleRed = (float) this.rand.nextGaussian();
        this.maxAge = (int) (Math.random() * 10.0D) + 40;
//        this.setParticleTextureIndex((int) (Math.random() * 8.0D));
    }

    @Override
    public void renderParticle(IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks) {
        float f = ((float) this.age + partialTicks) / (float) this.maxAge;
        f = 1.0F - f;
        f *= f;
        f = 1.0F - f;
        this.sparkleParticleScale = this.sparkleParticleScale * f;
    }

    @Override
    public IParticleRenderType getRenderType() {
        return null;
    }

    @Override
    public int getBrightnessForRender(float var1) {
        int var2 = super.getBrightnessForRender(var1);
        float var3 = (float) this.age / (float) this.maxAge;
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
    public void tick() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float var1 = (float) this.age / (float) this.maxAge;
        float var2 = var1;
        var1 = -var1 + var1 * var1 * 2.0F;
        var1 = 1.0F - var1;
        this.posX = this.portalPosX + this.motionX * var1;
        this.posY = this.portalPosY + this.motionY * var1 + (1.0F - var2);
        this.posZ = this.portalPosZ + this.motionZ * var1;

        if (this.age++ >= this.maxAge) {
            this.setExpired();
        }
    }
}