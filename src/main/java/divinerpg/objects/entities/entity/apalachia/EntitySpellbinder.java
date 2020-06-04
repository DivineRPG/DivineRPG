package divinerpg.objects.entities.entity.apalachia;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityMageBase;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySpellbinder extends EntityMageBase {

    public EntitySpellbinder(World worldIn) {
        super(worldIn, BulletType.SPELLBINDER_SHOT);
    }


    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SPELLBINDER;
    }
}