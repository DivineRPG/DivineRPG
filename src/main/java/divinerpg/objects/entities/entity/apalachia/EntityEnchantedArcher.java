package divinerpg.objects.entities.entity.apalachia;

import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.objects.entities.entity.projectiles.EntityDivineArrow;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityEnchantedArcher extends EntityDivineMob implements IRangedAttackMob {

    public EntityEnchantedArcher(World worldIn) {
        super(worldIn);
        this.setSize(1.8F, 3.0F);
    }

    @Override
    public float getEyeHeight() {
        return 2.9F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
        this.tasks.addTask(0, new EntityAIAttackRanged(this, 1, 15, 60, 15));
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.world.spawnEntity(
                new EntityDivineArrow(this.world, ArrowType.ENCHANTED_ARCHER_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ARCHER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HIGH_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HIGH_HIT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ENCHANTED_ARCHER;
    }
}
