package divinerpg.entities.apalachia;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import javax.annotation.Nullable;

public class EntityEnchantedWarrior extends EntityDivineMonster {
    public EntityEnchantedWarrior(EntityType<? extends Monster> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean isAggressive() {return true;}
    @Override public int getArmorValue() {return 10;}
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemRegistry.apalachia_blade.get()));
        super.populateDefaultEquipmentSlots(random, difficulty);
    }
    @Nullable
    @Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data) {
        RandomSource random = level.getRandom();
        populateDefaultEquipmentSlots(random, difficulty);
        populateDefaultEquipmentEnchantments(level, getRandom(), difficulty);
        return data;
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.HISS.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GROWL_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GROWL_HURT.get();}
}