package divinerpg.entities.vanilla;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import java.util.Random;

public class EntityEnthralledDramcryx extends EntityDivineMob {

    public EntityEnthralledDramcryx(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.25F;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.corruptedDramcryxHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.corruptedDramcryxDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.corruptedDramcryxSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.corruptedDramcryxFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DRAMCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DRAMCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DRAMCRYX_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ENTHRALLED_DRAMCRYX;
    }
}