package divinerpg.entities.vanilla.overworld;

import static divinerpg.registries.SoundRegistry.*;

import divinerpg.entities.base.EntityDivineMonster;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class EntityRotatick extends EntityDivineMonster {
	public EntityRotatick(EntityType<? extends Monster> type, Level level) {super(type, level);}
	@Override
	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {return 0.5F;}
	@Override
    protected SoundEvent getAmbientSound() {return ROTATICK.get();}
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return ROTATICK_HURT.get();}
    @Override
    protected SoundEvent getDeathSound() {return ROTATICK_HURT.get();}
    @Override public boolean isAggressive() {return true;}
    public static boolean rotatickSpawnRule(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return worldIn.getLightEmission(pos) < 8 && pos.getY() < 0;
    }
}