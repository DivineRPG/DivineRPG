package divinerpg.objects.entities.entity.twilight;

import divinerpg.registry.DRPGLootTables;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

// TODO fix moving
public class EntityAdvancedCori extends EntityWeakCori {

    public EntityAdvancedCori(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.5F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(100);
    }


    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_ADVANCED_CORI;
    }
}