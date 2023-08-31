package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineBoss;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityVamacheron extends EntityDivineBoss {
    public EntityVamacheron(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.1875F;
    }

    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.RED;
    }

}
