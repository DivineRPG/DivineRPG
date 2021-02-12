package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityMageBase;
import divinerpg.registries.LootTableRegistry;
import net.minecraft.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityMage extends EntityMageBase {
    public EntityMage(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

//    public EntityMage(World worldIn) {
//        super(worldIn, BulletType.MAGE_SHOT);
//    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_MAGE;
    }
}