package divinerpg.entities.vanilla.end;

import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.*;

public class EntityEnderWatcher extends EndermanEntity {
    public EntityEnderWatcher(EntityType<? extends EndermanEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.5F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.enderWatcherHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.enderWatcherDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.enderWatcherSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.enderWatcherFollowRange);
    }
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_ENDER_WATCHER;
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.THE_END;
    }
}
