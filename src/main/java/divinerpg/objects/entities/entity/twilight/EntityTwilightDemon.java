package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.objects.entities.entity.projectiles.EntityTwilightDemonShot;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

public class EntityTwilightDemon extends EntityDivineBoss {

    int shooting;

    public EntityTwilightDemon(World worldIn) {
        super(worldIn);
        this.setSize(2.0F, 4.0F);
    }

    @Override
    public float getEyeHeight() {
        return 3.5F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 40.0F, 50));
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            if (this.ticksExisted % 160 == 0)
                this.shooting = 100;
            this.setAttackTarget(this.world.getNearestAttackablePlayer(this, 40.0D, 40.0D));
            if (this.getAttackTarget() != null && this.shooting > 0) {
                double tx = this.getAttackTarget().posX - this.posX;
                double ty = this.getAttackTarget().getEntityBoundingBox().minY - this.posY - 2;
                double tz = this.getAttackTarget().posZ - this.posZ;
                double angle = Math.atan(-(tx) / (tz));
                EntityTwilightDemonShot e = new EntityTwilightDemonShot(this.world, this, this.rand.nextInt(50) == 0 ?
                        BulletType.TWILIGHT_DEMON_RED_SHOT : BulletType.TWILIGHT_DEMON_BLACK_SHOT);
                e.posZ += Math.sin(angle);
                e.posX += Math.cos(angle);
                e.shoot(tx - Math.cos(angle), ty, tz - Math.sin(angle), 1.6f, 0);
                this.world.spawnEntity(e);

                EntityTwilightDemonShot e1 = new EntityTwilightDemonShot(this.world, this, this.rand.nextInt(50) == 0 ?
                        BulletType.TWILIGHT_DEMON_RED_SHOT : BulletType.TWILIGHT_DEMON_BLACK_SHOT);
                e1.posZ -= Math.sin(angle);
                e1.posX -= Math.cos(angle);
                e1.shoot(tx + Math.cos(angle), ty, tz + Math.sin(angle), 1.6f, 0);
                this.world.spawnEntity(e1);
            }
            if (this.shooting > 0) {
                this.shooting--;
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_TWILIGHT_DEMON;
    }
    
    @Override
    public Color getBarColor() {
        return Color.RED;
    }
}
