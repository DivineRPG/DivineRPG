package divinerpg.objects.entities.entity.projectiles;

import static divinerpg.enums.ParticleType.FROST;

import divinerpg.DivineRPG;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFractiteShot extends EntityFireball {
    public static void registerFixesDragonFireball(DataFixer fixer) {
        EntityFireball.registerFixesFireball(fixer, "FractiteShot");
    }

    public EntityFractiteShot(World worldIn) {
        super(worldIn);
        this.isImmuneToFire = true;
    }

    @SideOnly(Side.CLIENT)
    public EntityFractiteShot(World worldIn, double x, double y, double z, double accelX, double accelY,
            double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.isImmuneToFire = true;
    }

    public EntityFractiteShot(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.isImmuneToFire = true;
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
    protected boolean isFireballFiery() {
        return false;
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 12.0F);
        }

        this.world.createExplosion(null, this.posX, this.posY, this.posZ, 3.0F, false);
        this.setDead();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onUpdate() {
        super.onUpdate();
        for (int i = 0; i < 5; i++) {
            DivineRPG.proxy.spawnParticle(this.world, FROST, this.posX, this.posY, this.posZ, 0, 1, 0);
        }
    }
}
