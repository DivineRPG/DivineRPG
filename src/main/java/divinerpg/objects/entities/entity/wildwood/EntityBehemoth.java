package divinerpg.objects.entities.entity.wildwood;

import divinerpg.objects.entities.ai.EntityBehemothEatWood;
import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityBehemoth extends EntityDivineMob {

    public EntityBehemoth(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1.2F);
    }

    @Override
    public float getEyeHeight() {
        return 0.7F;
    }
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityBehemothEatWood(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    }

    @Override
    public boolean isValidLightLevel() {
        return true;
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ENDIKU;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ENDIKU_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ENDIKU_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_BEHEMOTH;
    }
}