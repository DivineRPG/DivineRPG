package divinerpg.entities.vanilla.end;

import divinerpg.registries.*;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.*;

public class EntityEnderSpider extends EnderMan {
    public EntityEnderSpider(EntityType<? extends EnderMan> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.36875F;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HELL_SPIDER.get();
    }
}