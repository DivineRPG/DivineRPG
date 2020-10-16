package divinerpg.objects.entities.entity.boss;

import divinerpg.objects.entities.entity.EntityDivineBoss;
import divinerpg.objects.entities.entity.projectiles.EntitySoulFiendShot;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo.Color;

public class EntitySoulFiend extends EntityDivineBoss {

    public EntitySoulFiend(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2.0F);
    }

    @Override
    public float getEyeHeight() {
        return 1.725F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote && this.ticksExisted % 300 == 0) {
            for (int i = 0; i < 4; i++) {
                EntitySoulFiendShot shot = new EntitySoulFiendShot(this.world, this);
                shot.shoot(this.rand.nextDouble() - this.rand.nextDouble(), -0.25,
                        this.rand.nextDouble() - this.rand.nextDouble(), 0.5f, 12);
                this.world.spawnEntity(shot);
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (entity instanceof EntityPlayer) {
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 12 * 20, 0));
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 12 * 20, 0));
            }
            entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * 2.5, 0.4D,
                    MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * 2.5);
            this.motionX *= 0.6D;
            this.motionZ *= 0.6D;
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SOUL_FIEND;
    }
    
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
}
