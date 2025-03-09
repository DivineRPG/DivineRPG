package divinerpg.items.iceika;

import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;

public class ItemIceStone extends ItemMod {
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), Blocks.FIRE, BlockRegistry.icyFire.get().defaultBlockState())) {
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundRegistry.FREEZE.get(), SoundSource.BLOCKS, 1F, 1F);
        }
    }
}