package divinerpg.entities.vanilla.end;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.level.*;

import static divinerpg.registries.SoundRegistry.HELL_SPIDER;
import static net.minecraft.world.level.biome.Biomes.DEEP_DARK;
import static net.neoforged.neoforge.common.Tags.Biomes.IS_MUSHROOM;

public class EntityEnderSpider extends EntityEnderWatcher {
    public EntityEnderSpider(EntityType<? extends EntityEnderSpider> type, Level worldIn) {super(type, worldIn);}
    protected void registerGoals() {
        goalSelector.addGoal(0, new AvoidEntityGoal<>(this, Armadillo.class, 6, 1, 1.2, (entity) -> !((Armadillo)entity).isScared()));
        goalSelector.addGoal(1, new LeapAtTargetGoal(this, .4F));
        super.registerGoals();
    }
    @Override protected SoundEvent getAmbientSound() {return HELL_SPIDER.get();}
    @Override public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return !(level.getBiome(blockPosition()).is(IS_MUSHROOM) || level.getBiome(blockPosition()).is(DEEP_DARK));
    }
}