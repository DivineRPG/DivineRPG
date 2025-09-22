package divinerpg.entities.vanilla.overworld;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;

import javax.annotation.Nullable;

import static divinerpg.registries.SoundRegistry.JUNGLE_SPIDER;
import static net.minecraft.world.effect.MobEffects.POISON;

public class EntityJungleSpider extends Spider {
    public EntityJungleSpider(EntityType<? extends EntityJungleSpider> type, Level worldIn) {super(type, worldIn);}
    protected void registerGoals() {
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Armadillo.class, 6, 1, 1.2, (entity) -> !((Armadillo)entity).isScared()));
        goalSelector.addGoal(3, new LeapAtTargetGoal(this, .4F));
        goalSelector.addGoal(4, new MeleeAttackGoal(this, 1, true));
        goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, .8));
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8));
        goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }
    @Nullable
    @Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @Nullable SpawnGroupData data) {
        return data;
    }
    @Override public boolean doHurtTarget(Entity target) {
        boolean attack = super.doHurtTarget(target);
        if(attack) ((LivingEntity)target).addEffect(new MobEffectInstance(POISON, 2 * 20, 3, true, false));
        return attack;
    }
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return JUNGLE_SPIDER.get();}
}