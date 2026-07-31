package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineFireballMob;
import divinerpg.entities.projectile.DivineFireball;
import divinerpg.entities.projectile.fireball.EntityFrostShot;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.level.Level;

public class EntityFrost extends EntityDivineFireballMob {
	public EntityFrost(EntityType<? extends EntityFrost> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 40, 50, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        super.registerGoals();
    }
    @Override protected DivineFireball getProjectile() {return new EntityFrostShot(level(), this, 0, 0, 0);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.FROST.get();}
}