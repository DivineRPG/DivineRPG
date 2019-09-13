package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.ai.EntityBehemothEatWood;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behemoth extends EntityDivineRPGMob {

    public Behemoth(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1.2F);
    }

    @Override
    public float getEyeHeight() {
        return 0.7F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(180);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9);
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
        return ModSounds.ENDIKU;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENDIKU_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENDIKU_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_BEHEMOTH;
    }
}