package divinerpg.objects.entities.entity.mortum;

import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.EntityMageBase;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySorcerer extends EntityMageBase {

    public EntitySorcerer(World worldIn) {
        super(worldIn, BulletType.SORCERER_SHOT);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SORCERER;
    }
}