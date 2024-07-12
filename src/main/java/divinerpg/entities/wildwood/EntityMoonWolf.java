package divinerpg.entities.wildwood;

import divinerpg.enums.EntityStats;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.level.*;

public class EntityMoonWolf extends Wolf {

    public EntityMoonWolf(EntityType<? extends Wolf> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public void setTame(boolean bool) {
        super.setTame(bool);
        if (bool) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(EntityStats.MOON_WOLF.getHealth());
            this.setHealth((float)EntityStats.MOON_WOLF.getHealth());
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(EntityStats.MOON_WOLF.getHealth());
        }

        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(EntityStats.MOON_WOLF.getAttackDamage());
    }

    @Override
    public Wolf getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    @Override
    public boolean canMate(Animal animal) {
        return false;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !isTame();
    }
}
