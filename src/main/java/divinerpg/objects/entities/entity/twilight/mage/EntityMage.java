package divinerpg.objects.entities.entity.twilight.mage;

import divinerpg.enums.BulletType;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityMage extends EntityMageBase {

    public EntityMage(World worldIn) {
        super(worldIn, BulletType.MAGE_SHOT);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_MAGE;
    }
}