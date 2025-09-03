package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.*;

import javax.annotation.Nullable;

import static net.minecraft.world.entity.EquipmentSlot.MAINHAND;
import static net.minecraft.world.item.BowItem.getPowerForTime;

public class EntityWildfire extends EntityDivineMonster implements RangedAttackMob {
    public EntityWildfire(EntityType<? extends EntityWildfire> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new RangedBowAttackGoal<>(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 40, 32));
    }
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(random, difficulty);
        ItemStack stack = new ItemStack(ItemRegistry.inferno_bow.get());
        stack.enchant(registryAccess().holderOrThrow(Enchantments.VANISHING_CURSE), 1);
        setItemSlot(MAINHAND, stack);
    }
    @SuppressWarnings("deprecation")
    @Override public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data) {
        RandomSource random = level.getRandom();
        populateDefaultEquipmentSlots(random, difficulty);
        populateDefaultEquipmentEnchantments(level, random, difficulty);
        return data;
    }
    @Override public void tick() {
        super.tick();
        getItemBySlot(MAINHAND).inventoryTick(level(), this, 0, true);
    }
    @Override public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if(isAlive() && getTarget() != null) {
            float f = getPowerForTime((int)(72000 * distanceFactor));
            if(f >= .1F) {
                ItemStack stack = getItemBySlot(MAINHAND);
                stack.set(DataComponentRegistry.weaponAbility, 9);
                stack.set(DataComponentRegistry.weaponPower, f);
            }
        }
    }
    @Override public boolean fireImmune() {return true;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.WILDFIRE.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.WILDFIRE_HURT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.WILDFIRE_HURT.get();}
}