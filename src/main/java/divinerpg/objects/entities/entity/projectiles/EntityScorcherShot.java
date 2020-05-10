package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityScorcherShot extends EntityFireball {

    public EntityScorcherShot(World w) {
        super(w);
        setSize(0.3125F, 0.3125F);
    }

    public EntityScorcherShot(World w, EntityLivingBase shooter, double i, double j, double k) {
        this(w);
        this.setLocationAndAngles(shooter.posX, shooter.posY, shooter.posZ, shooter.rotationYaw, shooter.rotationPitch);
        this.setPosition(shooter.posX, shooter.posY, shooter.posZ);
        double d = (double) MathHelper.sqrt(i * i + j * j + k * k);
        this.accelerationX = i / d * 0.1D;
        this.accelerationY = j / d * 0.1D;
        this.accelerationZ = k / d * 0.1D;
        this.shootingEntity = shooter;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = result.getBlockPos().offset(result.sideHit);

                if (this.world.isAirBlock(blockpos)) {
                    this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
                }
            } else if (result.entityHit != null) {
                if (!result.entityHit.isImmuneToFire()) {
                    boolean flag = result.entityHit
                            .attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 4.0F);

                    if (flag && this.rand.nextInt(3) == 0) {
                        result.entityHit.setFire(5);
                    }
                }
            }
        }

        setDead();
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        if (!this.world.isRemote) {
            this.posX += (this.rand.nextDouble() - this.rand.nextDouble()) / 3;
            this.posY += (this.rand.nextDouble() - this.rand.nextDouble()) / 3;
            this.posZ += (this.rand.nextDouble() - this.rand.nextDouble()) / 3;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote) {
            /*
             * for (int i = 0; i < 3; i++) { ParticleEntityPortal particle = new
             * ParticleEntityPortal(this.world, this.posX + (this.rand.nextDouble() -
             * this.rand.nextDouble()) / 5, this.posY + 0.5D + (this.rand.nextDouble() -
             * this.rand.nextDouble()) / 5, this.posZ + (this.rand.nextDouble() -
             * this.rand.nextDouble()) / 5, 0.0D, 0.0D, 0.0D);
             * FMLClientHandler.instance().getClient().effectRenderer.addEffect(particle); }
             */
        }
    }
}
