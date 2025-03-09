package divinerpg.items.vanilla;

import divinerpg.registries.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class ShadowBlockItem extends BlockItem {
    public ShadowBlockItem() {
        super(BlockRegistry.shadowBlock.get(), new Item.Properties().rarity(Rarity.COMMON));
    }
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE) || damageSource.is(DamageRegistry.TAR.getKey()) || damageSource.is(DamageTypes.LAVA)) && itemEntity.isInFluidType(FluidRegistry.SMOLDERING_TAR.get())) {
            itemEntity.level().setBlock(itemEntity.blockPosition(), Blocks.AIR.defaultBlockState(), 3);
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1F, 1F);
            itemEntity = itemEntity.copy();
            itemEntity.setItem(ItemRegistry.shadow_stone.toStack(itemEntity.getItem().getCount()));
            itemEntity.level().addFreshEntity(itemEntity);
            Vec3 pos = itemEntity.position();
            if(itemEntity.level() instanceof ServerLevel s) s.sendParticles(ParticleTypes.SMOKE, pos.x, pos.y, pos.z, 25, .5, .5, .5, .01);
        }
    }
}