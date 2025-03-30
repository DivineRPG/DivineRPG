package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FireStock extends ItemMod {
    @Override
    public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        BlockState state;
        Level level = itemEntity.level();
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && (state = itemEntity.getInBlockState()).is(BlockTags.FIRE)) {
            RandomSource random = itemEntity.getRandom();
            for(int i = 0; i < itemEntity.getItem().getCount(); i++) {
                BlockPos pos = itemEntity.blockPosition().offset(random.nextInt(3) - 1, random.nextInt(2) - 1, random.nextInt(3) - 1);
                if(level.getBlockState(pos).isAir() && level.getBlockState(pos = pos.below()).isFaceSturdy(level, pos, Direction.UP)) {
                    level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS);
                    level.setBlock(pos.above(), state, 3);
                    return;
                }
            }
        } level.playSound(null, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL);
    }
}