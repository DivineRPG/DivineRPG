package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.*;
import net.minecraft.world.*;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.function.Predicate;

public class EntityMiner extends EntityDivineMob {
    private static final Predicate<Difficulty> HARD_DIFFICULTY_PREDICATE = (p_213697_0_) -> {return p_213697_0_ == Difficulty.HARD;};
    public EntityMiner(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.725F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
        goalSelector.addGoal(1, new BreakDoorGoal(this, HARD_DIFFICULTY_PREDICATE));
         }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.minerHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.minerDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.minerSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.minerFollowRange).createMutableAttribute(Attributes.ARMOR, 10);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_MINER;
    }
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag) {
            float f = this.world.getDifficultyForLocation(getPosition()).getAdditionalDifficulty();
            if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
                entityIn.setFire(2 * (int)f);
            }
        }

        return flag;
    }
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);
        if (this.rand.nextInt(7) == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.DIAMOND_PICKAXE));
        } else if (this.rand.nextInt(5) == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_PICKAXE));
        } else if (this.rand.nextInt(3) == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.STONE_PICKAXE));
        } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.WOODEN_PICKAXE));
        }
    }

    public void livingTick() {
        if (this.isAlive()) {
            boolean flag = true && this.isInDaylight();
            if (flag) {
                ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
                if (!itemstack.isEmpty()) {
                    if (itemstack.isDamageable()) {
                        itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
                        if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
                            this.sendBreakAnimation(EquipmentSlotType.HEAD);
                            this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                        }
                    }

                    flag = false;
                }

                if (flag) {
                    this.setFire(8);
                }
            }
        }

        super.livingTick();
    }

    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        setEquipmentBasedOnDifficulty(difficultyIn);
        setEnchantmentBasedOnDifficulty(difficultyIn);
        return spawnDataIn;
    }

}