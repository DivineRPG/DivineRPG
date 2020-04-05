package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.BulletType;
import divinerpg.registry.DRPGLootTables;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityMystic extends EntityMage {

    public EntityMystic(World worldIn) {
        super(worldIn, BulletType.MYSTIC_SHOT);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_MYSTIC;
    }
}