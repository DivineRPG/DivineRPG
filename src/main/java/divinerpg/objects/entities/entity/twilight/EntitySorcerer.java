package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.BulletType;
import divinerpg.registry.DRPGLootTables;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySorcerer extends EntityMage {

    public EntitySorcerer(World worldIn) {
        super(worldIn, BulletType.SORCERER_SHOT);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_SORCERER;
    }
}