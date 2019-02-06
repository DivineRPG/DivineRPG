package naturix.divinerpg.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ParticleEntityPortal extends Particle
{
    private float portalParticleScale;
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;

    public ParticleEntityPortal(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        super(par1World, par2, par4, par6, par8, par10, par12);
        motionX = par8;
        motionY = par10;
        motionZ = par12;
        portalPosX = posX = par2;
        portalPosY = posY = par4;
        portalPosZ = posZ = par6;
        float f = rand.nextFloat() * 0.6F + 0.4F;
        portalParticleScale = particleScale = rand.nextFloat() * 0.2F + 0.5F;
        particleRed = particleGreen = particleBlue = 1.0F * f;
        particleGreen *= 0.3F;
        particleRed *= 0.9F;
        particleMaxAge = (int)(Math.random() * 10D) + 40;
        canCollide = true;
        setParticleTextureIndex((int)(Math.random() * 8D));
    }
    public EntityPlayer player;
    public void renderParticle(BufferBuilder par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        float f = ((float)particleAge + par2) / (float)particleMaxAge;
        f = 1.0F - f;
        f *= f;
        f = 1.0F - f;
        particleScale = portalParticleScale * f;
        super.renderParticle(par1Tessellator, player, par2, par3, par4, par5, par6, par7);
    }

    public int getBrightnessForRender(float par1)
    {
        int i = super.getBrightnessForRender(par1);
        float f = (float)particleAge / (float)particleMaxAge;
        f *= f;
        f *= f;
        int j = i & 0xff;
        int k = i >> 16 & 0xff;
        k += (int)(f * 15F * 16F);

        if (k > 240)
        {
            k = 240;
        }

        return j | k << 16;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        float f = super.getBrightnessForRender(par1);
        float f1 = (float)particleAge / (float)particleMaxAge;
        f1 = f1 * f1 * f1 * f1;
        return f * (1.0F - f1) + f1;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        float f = (float)particleAge / (float)particleMaxAge;
        float f1 = f;
        f = -f + f * f * 2.0F;
        f = 1.0F - f;
        posX = portalPosX + motionX * (double)f;
        posY = portalPosY + motionY * (double)f + (double)(1.0F - f1);
        posZ = portalPosZ + motionZ * (double)f;

        if (particleAge++ >= particleMaxAge)
        {
            this.setExpired();
        }
    }
}