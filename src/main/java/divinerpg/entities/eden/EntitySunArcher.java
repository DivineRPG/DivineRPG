package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.Nullable;

import static net.minecraft.sounds.SoundEvents.SKELETON_SHOOT;

public class EntitySunArcher extends EntityDivineMonster implements RangedAttackMob {
    public EntitySunArcher(EntityType<? extends EntitySunArcher> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new RangedBowAttackGoal<>(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 30, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemRegistry.eden_bow.get()));
    }
    @SuppressWarnings("deprecation")
    @Override public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data) {
        RandomSource random = level.getRandom();
        populateDefaultEquipmentSlots(random, difficulty);
        populateDefaultEquipmentEnchantments(level, random, difficulty);
        return data;
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null) {
            ItemStack weapon = getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, (item) -> item instanceof BowItem));
            ItemStack itemstack1 = ItemRegistry.eden_arrow.toStack();
            AbstractArrow abstractarrow = ProjectileUtil.getMobArrow(this, itemstack1, distanceFactor, weapon);
            abstractarrow.setBaseDamage(1.5);
            Item var7 = weapon.getItem();
            if(var7 instanceof ProjectileWeaponItem weaponItem) abstractarrow = weaponItem.customArrow(abstractarrow, itemstack1, weapon);
            double d0 = target.getX() - getX(), d1 = target.getY(.3333333333333333) - abstractarrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractarrow.shoot(d0, d1 + d3 * .2, d2, 1.6F, 14 - (level().getDifficulty().getId() << 2));
            playSound(SKELETON_SHOOT, 1, 1 / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(abstractarrow);
        }
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundEvents.ALLAY_HURT;}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.SHULKER_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.ZOMBIE_VILLAGER_CONVERTED;}
}