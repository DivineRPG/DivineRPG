package divinerpg.entities.skythern;

import divinerpg.entities.base.EntityMageBase;
import divinerpg.registries.LootTableRegistry;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityMystic extends EntityMageBase {
    public EntityMystic(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        //TODO - BulletType.MYSTIC_SHOT
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_MYSTIC;
    }
}