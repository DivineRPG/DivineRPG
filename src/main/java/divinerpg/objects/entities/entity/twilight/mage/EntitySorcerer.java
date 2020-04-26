package divinerpg.objects.entities.entity.twilight.mage;

import divinerpg.enums.BulletType;
import divinerpg.registry.DRPGLootTables;
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
        return DRPGLootTables.ENTITIES_SORCERER;
    }
}