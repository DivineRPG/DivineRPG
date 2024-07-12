package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFireballMob;
import divinerpg.entities.projectile.*;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.level.*;

public class EntityFrost extends EntityDivineFireballMob {
	public EntityFrost(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 40, 50, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override
    protected DivineFireball getProjectile() {
    	return new EntityFrostShot(level(), this, 0, 0, 0);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROST.get();
    }
}
