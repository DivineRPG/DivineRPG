package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static divinerpg.registries.SoundRegistry.*;

public class EntityCrawler extends EntityDivineMonster {
	public EntityCrawler(EntityType<? extends EntityCrawler> type, Level level) {super(type, level);}
	@Override protected SoundEvent getAmbientSound() {return CRAWLER.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return CRAWLER_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return CRAWLER_HURT.get();}
    @Override protected void playStepSound(BlockPos pos, BlockState state) {
    	super.playStepSound(pos, state);
    	if(getType() == EntityRegistry.CAVE_CRAWLER.get()) playSound(CAVE_CRAWLER_STEP.get(), 1, 1);
    }
}