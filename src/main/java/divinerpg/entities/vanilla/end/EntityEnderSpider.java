package divinerpg.entities.vanilla.end;

import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityEnderSpider extends EndermanEntity {
    public EntityEnderSpider(EntityType<? extends EndermanEntity> type, World worldIn) {
        super(type, worldIn);
        this.experienceValue = 20;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.45F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.enderSpiderHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.enderSpiderDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.enderSpiderSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.enderSpiderFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HELL_SPIDER;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ENDER_SPIDER;
    }
}
