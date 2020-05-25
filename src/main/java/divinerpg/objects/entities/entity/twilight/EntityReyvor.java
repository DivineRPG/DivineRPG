package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.ArrowType;
import divinerpg.objects.entities.entity.EntityDivineBoss;
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
import net.minecraft.world.BossInfo.Color;
import net.minecraft.world.World;

public class EntityReyvor extends EntityDivineBoss implements IRangedAttackMob {

    public EntityReyvor(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.5F);
    }

    @Override
    public float getEyeHeight() {
        return 2.0F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(6,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
        this.tasks.addTask(7, new EntityAIAttackRanged(this, 0.25, 40, 64));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase target, float f) {
        this.world.spawnEntity(new EntityDivineArrow(this.world, ArrowType.REYVOR_ARROW, this, target, 1.6F, 12.0F));
    }

    @Override
    public void setSwingingArms(boolean swingingArms) {
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.REYVOR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.REYVOR_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_REYVOR;
    }
}
