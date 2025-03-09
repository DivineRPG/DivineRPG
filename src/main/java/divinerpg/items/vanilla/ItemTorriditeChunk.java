package divinerpg.items.vanilla;

import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.BlockRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;

public class ItemTorriditeChunk extends ItemMod {
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), Blocks.SOUL_FIRE, BlockRegistry.hellFire.get().defaultBlockState()) && itemEntity.level() instanceof ServerLevel s) {
            s.sendParticles(ParticleTypes.SOUL, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 4, .2, .2, .2, 0);
            s.playSound(null, itemEntity.blockPosition(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, 0.6F, 1.5F);
        }
    }
}