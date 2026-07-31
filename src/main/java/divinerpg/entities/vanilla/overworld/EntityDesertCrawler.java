package divinerpg.entities.vanilla.overworld;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityDesertCrawler extends EntityCrawler {
    public EntityDesertCrawler(EntityType<? extends EntityDesertCrawler> type, Level level) {super(type, level);}
    @Override public void tick() {
        if(!isAggressive()) getNavigation().setSpeedModifier(0);
        super.tick();
    }
}