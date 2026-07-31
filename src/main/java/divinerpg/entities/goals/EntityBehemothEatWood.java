package divinerpg.entities.goals;

import divinerpg.entities.wildwood.EntityBehemoth;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.goal.Goal;

public class EntityBehemothEatWood extends Goal {
    EntityBehemoth mob;
    public EntityBehemothEatWood(EntityBehemoth behemoth) {
        mob = behemoth;
    }
    @Override public boolean canUse() {
        return mob.getHealth() < mob.getMaxHealth();
    }
    @Override public boolean canContinueToUse() {
        return mob.getHealth() < mob.getMaxHealth();
    }
    int eatingCooldown;
    @Override
    public void tick() {
        if(eatingCooldown > 0) eatingCooldown--;
        else{
            BlockPos pos = mob.blockPosition().offset(mob.getRandom().nextInt(5) - 2, mob.getRandom().nextInt(5) - 2, mob.getRandom().nextInt(5) - 2);
            if(mob.level().getBlockState(pos).is(BlockTags.LOGS)) {
                mob.level().destroyBlock(pos, false, mob);
                mob.heal(5F);
                mob.playSound(SoundEvents.AXE_STRIP);
                eatingCooldown = 40;
            }
        }
    }
}