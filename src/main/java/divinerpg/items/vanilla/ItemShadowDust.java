package divinerpg.items.vanilla;

import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;

public class ItemShadowDust extends ItemMod {
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), BlockRegistry.hellFire.get(), Blocks.AIR.defaultBlockState())) {
            itemEntity = itemEntity.copy();
            itemEntity.setItem(ItemRegistry.hellstone_ingot.toStack(itemEntity.getItem().getCount()));
            itemEntity.level().addFreshEntity(itemEntity);
            itemEntity.level().playSound(null, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS);
        }
    }
}