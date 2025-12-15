package divinerpg.entities.wildwood;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;

import static divinerpg.registries.TagRegistry.PET_FOODS_MOON_WOLF;

public class EntityMoonWolf extends Wolf {
    public EntityMoonWolf(EntityType<? extends EntityMoonWolf> type, Level worldIn) {super(type, worldIn);}
    @Override public void applyTamingSideEffects() {
        if(isTame()) {
            getAttribute(Attributes.MAX_HEALTH).setBaseValue(getMaxHealth());
            setHealth(getMaxHealth());
        } else getAttribute(Attributes.MAX_HEALTH).setBaseValue(getMaxHealth());
    }
    @Override public boolean isFood(ItemStack stack) {return stack.is(PET_FOODS_MOON_WOLF);}
    //TODO: to maybe add baby moon wolves
    // fix the issue related to them being breedable with the regular ones (or add a compat)
    @Override public EntityMoonWolf getBreedOffspring(ServerLevel level, AgeableMob mob) {return null;}
    @Override public boolean canMate(Animal animal) {return false;}
    @Override public float getWalkTargetValue(BlockPos pos, LevelReader world) {return 0;}
    @Override public int getMaxSpawnClusterSize() {return 4;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 3;}
}