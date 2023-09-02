package divinerpg.entities.vanilla.nether;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.Level;

public class EntityHellBat extends Bat {

    public EntityHellBat(EntityType<? extends Bat> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean fireImmune() {
    	return true;
    }

    @Override
    public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    public int getMaxSpawnClusterSize() {
    	return 1;
    }

    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 1;
    }
}
