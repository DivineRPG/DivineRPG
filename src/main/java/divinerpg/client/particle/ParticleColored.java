package divinerpg.client.particle;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class ParticleColored extends Particle {

    private float portalParticleScale;
    private double portalPosX, portalPosY, portalPosZ;
    public boolean bigger;
    public boolean shortLived;

    public ParticleColored(World var1, double var2, double var4, double var6, double var8, double var10, double var12,
                           Color c, boolean bigger, boolean shortLived) {
        super((ClientWorld)var1, var2, var4, var6, var8, var10, var12);
        this.motionX = var8;
        this.motionY = var10;
        this.motionZ = var12;
        this.bigger = bigger;
        this.shortLived = shortLived;
        this.portalPosX = this.posX = var2;
        this.portalPosY = this.posY = var4;
        this.portalPosZ = this.posZ = var6;
        float var14 = this.rand.nextFloat() * 0.6F + 0.4F;
        this.portalParticleScale = this.rand.nextFloat() * 0.2F + 0.5F;
        this.particleRed = (float) c.getRed() / 255;
        this.particleGreen = (float) c.getGreen() / 255;
        this.particleBlue = (float) c.getBlue() / 255;
        this.maxAge = (int) (Math.random() * 10.0D) + 40;
        //this.noClip = true;
//        this.setParticleTextureIndex((int) (Math.random() * 8.0D));
    }


    @Override
    public void renderParticle(IVertexBuilder p_180434_1_, ActiveRenderInfo renderInfo, float partialTicks) {
        float var8 = (this.age) / this.maxAge * 3;
        var8 = 1.0F - var8;
        var8 *= var8;
        var8 = 1.0F - var8;
        if (bigger) {
            this.portalParticleScale = (this.portalParticleScale * var8 * 7);
        } else {
            this.portalParticleScale = (this.portalParticleScale * var8);
        }
        if (shortLived)
            this.age += 2;
}

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.CUSTOM;
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
        if (var5 > 240)
            var5 = 240;
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
        if (this.age++ >= this.maxAge)
            this.setExpired();
    }
}
