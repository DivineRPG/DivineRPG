package divinerpg.entities.base;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

public abstract class EntityDivineRangedMob extends EntityDivineMonster implements RangedAttackMob {
    public EntityDivineRangedMob(EntityType<? extends EntityDivineRangedMob> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        super.registerGoals();
    }
}