package divinerpg.entities.base;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;

public abstract class EntityDivineMonster extends Monster {
    public boolean followingTarget = true;
    public EntityDivineMonster(EntityType<? extends EntityDivineMonster> type, Level worldIn) {super(type, worldIn);}
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        if(!(this instanceof RangedAttackMob)) goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, followingTarget));
        if(!(this instanceof EntityDivineFlyingMonster)) goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6));
        goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        if(!(this instanceof NeutralMob)) {
            targetSelector.addGoal(0, new HurtByTargetGoal(this));
            targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        }
    }
    @Override public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return !(level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM) || level.getBiome(blockPosition()).is(Biomes.DEEP_DARK));
    }
}