package divinerpg.entities.vanilla.overworld;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.level.Level;

public class EntityJungleBat extends Bat {

    public EntityJungleBat(EntityType<? extends Bat> type, Level level) {
        super(type, level);
    }

    public float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }
}
