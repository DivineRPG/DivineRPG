package divinerpg.client.particle;


import net.minecraft.client.particle.*;
import net.minecraftforge.api.distmarker.*;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;

@OnlyIn(Dist.CLIENT)
public class ParticleSparkler extends TextureSheetParticle
{
    SpriteSet animatedSprite;
    private float sparkleParticleScale;
    private double portalPosX;
    private double portalPosY;
    private double portalPosZ;
    public ParticleSparkler(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, SpriteSet sprite)
    {
        this(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, 1.0F, sprite);
    }

    public ParticleSparkler(ClientLevel worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed, float scale, SpriteSet sprite)
    {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);

        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.quadSize *= 0.75F;
        this.quadSize *= 0.9F;
        this.lifetime = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
        this.lifetime = (int)((float)this.lifetime * 0.5F);
        this.portalPosX = this.x = xCoordIn;
        this.portalPosY = this.y = yCoordIn;
        this.portalPosZ = this.z = zCoordIn;
        this.random.nextFloat();
        this.sparkleParticleScale = this.quadSize = this.random.nextFloat() * 0.2F + 0.5F;
        this.bCol = (float) this.random.nextGaussian();
        this.gCol = (float) this.random.nextGaussian();
        this.rCol = (float) this.random.nextGaussian();
        this.roll = (float)Math.random() * ((float)Math.PI * 2F);
        this.animatedSprite = sprite;
    }

    @Override
    protected int getLightColor(float partialTick) {
        int var2 = super.getLightColor(partialTick);
        float var3 = (float) this.age / (float) this.age;
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

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        } else {
            this.yd -= (double) this.gravity;
            this.move(this.xd, this.yd, this.zd);
            this.xd *= (double) 0.98F;
            this.yd *= (double) 0.98F;
            this.zd *= (double) 0.98F;
            if (this.onGround) {
                if (Math.random() < 0.5D) {
                    this.remove();
                }

                this.xd *= (double) 0.7F;
                this.zd *= (double) 0.7F;
            }

            BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
            double d0 = Math.max(this.level.getBlockState(blockpos).getCollisionShape(this.level, blockpos).max(Direction.Axis.Y, this.x - (double) blockpos.getX(), this.z - (double) blockpos.getZ()), (double) this.level.getFluidState(blockpos).getHeight(this.level, blockpos));
            if (d0 > 0.0D && this.y < (double) blockpos.getY() + d0) {
                this.remove();
            }

        }
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
            ParticleSparkler particle = new ParticleSparkler(world, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed, sprites);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }
}