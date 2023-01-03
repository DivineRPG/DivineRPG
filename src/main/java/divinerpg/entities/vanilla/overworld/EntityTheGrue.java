package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;

import static divinerpg.registries.SoundRegistry.*;

public class EntityTheGrue extends EntityDivineMonster {
	public EntityTheGrue(EntityType<? extends Monster> type, Level level) {super(type, level);}
	@Override
	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {return 1.4F;}
	@Override
    protected SoundEvent getAmbientSound() {return DEATHCRYX.get();}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return DEATHCRYX_HURT.get();}
    @Override
    protected SoundEvent getDeathSound() {return DEATHCRYX_HURT.get();}
	@Override public boolean isAggressive() {return true;}
    @Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(0, new LeapAtTargetGoal(this, 0.6F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	public static boolean theGrueSpawnRule(EntityType<? extends Monster> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		return pos.getY() < 0 && checkMonsterSpawnRules(typeIn, worldIn, reason, pos, randomIn);
	}
}