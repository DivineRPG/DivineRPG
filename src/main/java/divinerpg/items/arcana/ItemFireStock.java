package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.core.Direction.UP;
import static net.minecraft.tags.BlockTags.FIRE;

public class ItemFireStock extends ItemMod {
    @Override public void onDestroyed(ItemEntity item, DamageSource damageSource) {
        Level level = item.level();
        BlockState state = item.getInBlockState();
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && state.is(FIRE)) {
            RandomSource random = item.getRandom();
            for(int i = 0; i < item.getItem().getCount(); i++) {
                BlockPos pos = item.blockPosition().offset(random.nextInt(3) - 1, random.nextInt(2) - 1, random.nextInt(3) - 1);
                if(level.getBlockState(pos).isAir() && level.getBlockState(pos = pos.below()).isFaceSturdy(level, pos, UP)) {
                    level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, .6F, (random.nextFloat() - random.nextFloat()) * .2F + 1);
                    level.setBlock(pos.above(), state, 3);
                }
            } if(!state.is(TagRegistry.FIRE_BLOCK)) level.playSound(null, item.getX(), item.getY(), item.getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, .6F, 1.3F);
        }
    }
}