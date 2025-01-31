package divinerpg.entities.vanilla.nether;

import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.*;

public class EntityHellSpider extends Spider {
    public EntityHellSpider(EntityType<? extends EntityHellSpider> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean fireImmune() {return true;}
    @Override public boolean doHurtTarget(Entity target) {
        boolean attack = super.doHurtTarget(target);
        if(attack) target.setRemainingFireTicks(3 * 20);
        return attack;
    }
    @Override public boolean onClimbable() {return false;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader reader) {return 0;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.HELL_SPIDER.get();}
}