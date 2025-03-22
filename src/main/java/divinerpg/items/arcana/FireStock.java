package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FireStock extends ItemMod {
    @Override
    public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        BlockState state;
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && (state = itemEntity.getInBlockState()).is(BlockTags.FIRE)) {
            BlockPos pos = itemEntity.blockPosition().offset(itemEntity.getRandom().nextInt(3) - 1, itemEntity.getRandom().nextInt(2) - 1, itemEntity.getRandom().nextInt(3) - 1);
            if(itemEntity.level().getBlockState(pos).isAir() && itemEntity.level().getBlockState(pos = pos.below()).isFaceSturdy(itemEntity.level(), pos, Direction.UP)) {
                itemEntity.level().playSound(null, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL);
                itemEntity.level().setBlock(pos.above(), state, 3);
                return;
            }
        } itemEntity.level().playSound(null, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL);
    }
}