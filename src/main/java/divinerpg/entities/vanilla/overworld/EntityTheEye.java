package divinerpg.entities.vanilla.overworld;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static divinerpg.registries.SoundRegistry.*;

public class EntityTheEye extends EntityDivineMonster {
	public static final Identifier ADVANCEMENT = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "adventure/eye_of_evil");
    public EntityTheEye(EntityType<? extends EntityTheEye> type, Level level) {super(type, level);}
	@Override protected SoundEvent getAmbientSound() {return THE_EYE.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return THE_EYE_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return THE_EYE_HURT.get();}
    @Override protected void playStepSound(BlockPos pos, BlockState state) {}
    @Override public boolean isSteppingCarefully() {return true;}

    @Override protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 64));
    }

    @Override public void tick() {
        super.tick();
        LivingEntity entity = this.getTarget();
        if(entity instanceof ServerPlayer s && (isLookingAt(this, entity) || isLookingAt(entity, this))) {
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120, 0, false, true));
            Utils.awardAdvancement(((ServerLevel) level()).getServer(), s, ADVANCEMENT, "look_into_the_eye");
        }
    }

    boolean isLookingAt(LivingEntity target, LivingEntity looking) {
            Vec3 vec3 = looking.getViewVector(64.0F).normalize();
            Vec3 vec31 = new Vec3(target.getX() - looking.getX(), target.getEyeY() - looking.getEyeY(), target.getZ() - looking.getZ());
            double d0 = vec31.length();
            vec31 = vec31.normalize();
            double d1 = vec3.dot(vec31);
            return d1 > 1.0D - 0.025D / d0 && looking.hasLineOfSight(target);
    }
}