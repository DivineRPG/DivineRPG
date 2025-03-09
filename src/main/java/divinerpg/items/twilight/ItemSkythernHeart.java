package divinerpg.items.twilight;

import com.jcraft.jorbis.Block;
import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.BlockRegistry;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;

public class ItemSkythernHeart extends ItemMod {
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), BlockRegistry.skyFire.get(), BlockRegistry.mortumEmbers.get().defaultBlockState())) {
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1F, 1F);
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1F, 1F);
        }
    }
}