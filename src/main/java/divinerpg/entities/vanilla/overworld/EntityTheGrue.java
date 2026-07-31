package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import static divinerpg.registries.SoundRegistry.*;

public class EntityTheGrue extends EntityDivineMonster {
	private int attackTick;
	public EntityTheGrue(EntityType<? extends EntityTheGrue> type, Level level) {super(type, level);}
	@Override
    protected SoundEvent getAmbientSound() {return DEATHCRYX.get();}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return DEATHCRYX_HURT.get();}
    @Override
    protected SoundEvent getDeathSound() {return DEATHCRYX_HURT.get();}
    @Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(0, new LeapAtTargetGoal(this, 0.6F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putInt("AttackTick", attackTick);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		attackTick = input.getIntOr("AttackTick", 0);
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
	public boolean doHurtTarget(ServerLevel level, Entity target) {
		this.attackTick = 10;
		this.level().broadcastEntityEvent(this, (byte)4);
		return super.doHurtTarget(level, target);
	}
}
