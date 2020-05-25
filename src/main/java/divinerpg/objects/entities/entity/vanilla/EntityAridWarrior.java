package divinerpg.objects.entities.entity.vanilla;

import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityAridWarrior extends EntityDivineMob implements IRangedAttackMob {

    public EntityAridWarrior(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 2.8f);
    }

    @Override
    public float getEyeHeight() {
        return 2.25F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 0.27F, 18, 16.0F));
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.world
                .spawnEntity(new EntityDivineArrow(this.world, ArrowType.ARID_WARRIOR_ARROW, this, target, 1.6F, 4.5F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ARID_WARRIOR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ARID_WARRIOR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ARID_WARRIOR_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ARID_WARRIOR;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.provider.getDimension() == 0 && super.getCanSpawnHere();
    }
}
