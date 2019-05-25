package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGBoss;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySoulFiendShot;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SoulFiend extends EntityDivineRPGBoss {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/soul_fiend");

    public SoulFiend(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1100);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(24);
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
        return this.LOOT;
    }
}
