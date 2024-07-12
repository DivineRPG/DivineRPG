package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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
	private int attackTick;
	public EntityTheGrue(EntityType<? extends Monster> type, Level level) {super(type, level);}
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
	@Override
	public void addAdditionalSaveData(CompoundTag p_33353_) {
		super.addAdditionalSaveData(p_33353_);
		p_33353_.putInt("AttackTick", this.attackTick);
	}
	@Override
	public void readAdditionalSaveData(CompoundTag p_33344_) {
		super.readAdditionalSaveData(p_33344_);
		this.attackTick = p_33344_.getInt("AttackTick");
	}
	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAlive()) {
			if (this.attackTick > 0) {
				--this.attackTick;
			}
		}
	}
	@Override
	public void handleEntityEvent(byte p_33335_) {
		if (p_33335_ == 4) {
			this.attackTick = 10;
		}

		super.handleEntityEvent(p_33335_);
	}
	public int getAttackTick() {
		return this.attackTick;
	}
	@Override
	public boolean doHurtTarget(Entity p_33328_) {
		this.attackTick = 10;
		this.level().broadcastEntityEvent(this, (byte)4);
		return super.doHurtTarget(p_33328_);
	}
	public static boolean theGrueSpawnRule(EntityType<? extends Monster> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		return pos.getY() < 0 && checkMonsterSpawnRules(typeIn, worldIn, reason, pos, randomIn);
	}
}
