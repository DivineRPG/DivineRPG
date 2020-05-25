package divinerpg.objects.entities.entity.twilight.mage;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightMageShot;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public abstract class EntityMageBase extends EntityDivineMob {
    private final BulletType bullet;

    private EntityMageBase(World worldIn) {
        this(worldIn, BulletType.MAGE_SHOT);
    }

    protected EntityMageBase(World world, BulletType bullet) {
        super(world);
        this.bullet = bullet;
        this.setSize(0.5F, 2.2F);
    }

    @Override
    public float getEyeHeight() {
        return 2.0F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(2,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted % 10 == 0) {
            this.attackingPlayer = this.world.getNearestAttackablePlayer(this, 16D, 16D);
            if (this.attackingPlayer != null && !this.world.isRemote) {
                double tx = this.attackingPlayer.posX - this.posX;
                double ty = this.attackingPlayer.getEntityBoundingBox().minY - this.posY;
                double tz = this.attackingPlayer.posZ - this.posZ;
                EntityTwilightMageShot shot = new EntityTwilightMageShot(this.world, this, bullet);
                shot.shoot(tx, ty, tz, 1.6f, 0);
                this.world.spawnEntity(shot);
                this.world.playSound(null, this.attackingPlayer.posX, this.attackingPlayer.posY,
                        this.attackingPlayer.posZ, SoundRegistry.MAGE_FIRE, SoundCategory.HOSTILE, 1.0F, 1.0F);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.INSECT;
    }
}
