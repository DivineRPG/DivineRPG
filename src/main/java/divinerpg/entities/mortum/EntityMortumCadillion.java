package divinerpg.entities.mortum;

import divinerpg.entities.base.EntityCadillion;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityMortumCadillion extends EntityCadillion {

    public EntityMortumCadillion(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public int getArmorValue() {
        return 10;
    }
}
