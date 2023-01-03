package divinerpg.entities.boss;

import divinerpg.entities.base.*;

import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityVamacheron extends EntityDivineBoss {
    public EntityVamacheron(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.0F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public BossBarColor getBarColor() {
        return BossBarColor.RED;
    }

}
