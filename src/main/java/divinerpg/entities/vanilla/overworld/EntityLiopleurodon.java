package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityLiopleurodon extends EntityDivineWaterMob {
    public EntityLiopleurodon(EntityType<? extends EntityLiopleurodon> type, Level worldIn) {
        super(type, worldIn);
        moveControl = new SmoothSwimmingMoveControl(this, 85, 10, .3F, .1F, true);
        lookControl = new SmoothSwimmingLookControl(this, 10);
    }
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
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