package divinerpg.objects.entities.entity.twilight;

import divinerpg.enums.BulletType;
import divinerpg.registry.DRPGLootTables;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySpellbinder extends EntityMage {

    public EntitySpellbinder(World worldIn) {
        super(worldIn, BulletType.SPELLBINDER_SHOT);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(95);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_SPELLBINDER;
    }
}