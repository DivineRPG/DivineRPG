package divinerpg.entities.vanilla.end;

import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.Level;

public class EntityEnderSpider extends EnderMan {

    public EntityEnderSpider(EntityType<? extends EnderMan> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.36875F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HELL_SPIDER.get();
    }
}
