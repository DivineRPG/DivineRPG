package divinerpg.entities.skythern;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntitySkythernFiend extends EntityDivineMob {

    public EntitySkythernFiend(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.skythernFiendHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.skythernFiendDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.skythernFiendSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.skythernFiendFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.SKYTHERN_WORLD;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT;
    }

}