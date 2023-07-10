package divinerpg.entities.base;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.Tags;

public abstract class EntityDivineMonster extends Monster {
    public EntityDivineMonster(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        if(isAggressive()) {
            goalSelector.addGoal(0, new MeleeAttackGoal(this, 1, true));
            targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        }
        if(!isAggressive() && !(this instanceof EntityPeacefulUntilAttacked)){
            goalSelector.addGoal(3, new PanicGoal(this, 1.25D));
        }
    }
    @Override
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
    	return !level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM);
    }
}
