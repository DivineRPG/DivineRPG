package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import static divinerpg.registries.ItemRegistry.liopleurodon_teeth;

public class EntityLiopleurodon extends EntityDivineWaterMob {
    private int attackTick;
    public EntityLiopleurodon(EntityType<? extends EntityLiopleurodon> type, Level worldIn) {
        super(type, worldIn);
        moveControl = new SmoothSwimmingMoveControl(this, 85, 10, .3F, .1F, true);
        lookControl = new SmoothSwimmingLookControl(this, 10);
    }
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        //TODO: maybe making it hunting stuff like axolotls do (with a cooldown) + configurable with tags
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, AbstractFish.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Squid.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Dolphin.class, true));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Axolotl.class, true, false));
        targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Turtle.class, true, false));
    }
    @Override public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("AttackTick", attackTick);
    }
    @Override public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        attackTick = tag.getInt("AttackTick");
    }
    @Override public void aiStep() {
        super.aiStep();
        if(isAlive() && attackTick > 0) --attackTick;
    }
    @Override public void handleEntityEvent(byte b) {
        if(b == 4) attackTick = 10;
        super.handleEntityEvent(b);
    }
    public int getAttackTick() {return attackTick;}
    @Override public boolean doHurtTarget(Entity target) {
        attackTick = 10;
        level().broadcastEntityEvent(this, (byte)4);
        if(!level().isClientSide && level().getRandom().nextInt(100) == 0) spawnAtLocation(liopleurodon_teeth);
        return super.doHurtTarget(target);
    }
    //TODO: is this gonna be used anymore?
//	public static boolean liopleurodonSpawnRule(EntityType<? extends Mob> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
//		List<Entity> entities = worldIn.getEntities(null, new AABB(-48, -48, -48, 48, 48, 48));
//		List<EntityLiopleurodon> liopleurodon = new ArrayList<>();
//		for(int i = 0; i < entities.size(); i++) {
//			if(entities.get(i) instanceof EntityLiopleurodon) {
//				EntityLiopleurodon liopleurodonMob = (EntityLiopleurodon) entities.get(i);
//				liopleurodon.add(liopleurodonMob);
//			}
//		} return liopleurodon.size() < 2;
//    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.LIOPLEURODON.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.LIOPLEURODON_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.LIOPLEURODON_DEATH.get();}
}