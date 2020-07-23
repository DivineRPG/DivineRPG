package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntityCaveRock;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityCaveclops extends EntityDivineMob implements IRangedAttackMob {

    public EntityCaveclops(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 4.0F);
    }

    @Override
    public float getEyeHeight() {
        return 3.5F;
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 0.27F, 30, 10.0F));
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        EntityCaveRock rock = new EntityCaveRock(this.world, this);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - rock.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        rock.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 12.0F);
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(rock);
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYCLOPS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_CAVECLOPS;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && this.posY < 20.0D && super.getCanSpawnHere();
    }
}
