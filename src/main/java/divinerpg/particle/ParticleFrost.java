package divinerpg.particle;

import divinerpg.DivineRPG;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on Feb
 * /04/2019
 */
@SideOnly(Side.CLIENT)
public class ParticleFrost extends Particle {
    final float rotSpeed;
    float oSize;

    public ParticleFrost(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
        this.particleTexture = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(new ResourceLocation(DivineRPG.MODID, "particle/frost").toString());
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
        this.particleScale *= 0.75F;
        this.particleScale *= 0.9F;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * 0.5F);
        float f = (float)Math.random() * 0.4F + 0.6F;
        this.particleRed = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * f;
        this.rotSpeed = ((float)Math.random() - 0.9F) * 0.1F;
        this.particleAngle = (float)Math.random() * ((float)Math.PI * 2F);
    }

    public int getFXLayer(){
        return 1;
    }

    @Override
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
        float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge * 2.0F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        this.particleScale = this.oSize * f;
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.particleAlpha = ((float)this.particleMaxAge - (float)this.particleAge) / 50;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.particleAlpha = 0;
            this.setExpired();
        }

        this.prevParticleAngle = this.particleAngle;
        this.particleAngle += (float)Math.PI * this.rotSpeed * 1.0F;


        if (this.onGround)
        {
            this.prevParticleAngle = this.particleAngle = 0.0F;
        }

        this.move(this.motionX, this.motionY, this.motionZ);
        this.motionY -= 0.000300000026077032D;
        this.motionY = Math.max(this.motionY, -0.04000000059604645D);
    }
}
