package divinerpg.entities.vanilla.end;

import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;

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

    @Override
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return !(level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM) || level.getBiome(blockPosition()).is(Biomes.DEEP_DARK));
    }
}
