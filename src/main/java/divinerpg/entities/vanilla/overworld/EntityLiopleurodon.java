package divinerpg.entities.vanilla.overworld;

import java.util.ArrayList;
import java.util.List;

import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;

public class EntityLiopleurodon extends EntityDivineWaterMob {

    public EntityLiopleurodon(EntityType<? extends EntityLiopleurodon> type, Level worldIn) {
        super(type, worldIn);
                                                                //Entity, maxTurnX, maxTurnY, inWaterSpeedModifier, outsideWaterSpeedModifier
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.3F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }
    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LIOPLEURODON.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LIOPLEURODON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LIOPLEURODON_HURT.get();
    }

	public static boolean liopleurodonSpawnRule(EntityType<? extends Mob> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
		List<Entity> entities = worldIn.getEntities(null, new AABB(-48, -48, -48, 48, 48, 48));
		List<EntityLiopleurodon> liopleurodon = new ArrayList<>();
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof EntityLiopleurodon) {
				EntityLiopleurodon liopleurodonMob = (EntityLiopleurodon) entities.get(i);
				liopleurodon.add(liopleurodonMob);
			}
		}
		if (liopleurodon.size() < 2) {
			return true;
		}
		return false;
	}
}