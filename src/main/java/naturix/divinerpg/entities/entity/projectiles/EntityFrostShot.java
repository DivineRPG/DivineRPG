package naturix.divinerpg.entities.entity.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFrostShot extends EntityFireball {

    public EntityFrostShot(World w) {
        super(w);
        setSize(0.3125F, 0.3125F);
    }

    public EntityFrostShot(World w, EntityLivingBase shooter, double i, double j, double k) {
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
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.entityHit != null) {
                if (!result.entityHit.isImmuneToFire()) {
                    boolean flag = result.entityHit
                            .attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0F);

                    if (flag) {
                        this.applyEnchantments(this.shootingEntity, result.entityHit);
                        result.entityHit.setFire(5);
                    }
                }
            } else {
                boolean flag1 = true;

                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving) {
                    flag1 = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world,
                            this.shootingEntity);
                }

                if (flag1) {
                    BlockPos blockpos = result.getBlockPos().offset(result.sideHit);

                    if (this.world.isAirBlock(blockpos)) {
                        this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
                    }
                }
            }

            this.setDead();
        }
    }
}
