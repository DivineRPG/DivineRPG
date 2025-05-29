package divinerpg.items.vanilla;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import static divinerpg.registries.BlockRegistry.shadowBlock;
import static divinerpg.registries.DamageRegistry.TAR;
import static divinerpg.registries.FluidRegistry.SMOLDERING_TAR;
import static divinerpg.registries.ItemRegistry.shadow_stone;
import static net.minecraft.sounds.SoundEvents.LAVA_EXTINGUISH;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.item.Rarity.COMMON;

public class ItemShadowBlock extends BlockItem {
    public ItemShadowBlock() {super(shadowBlock.get(), new Properties().rarity(COMMON));}
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE) || damageSource.is(TAR.getKey()) || damageSource.is(DamageTypes.LAVA)) && itemEntity.isInFluidType(SMOLDERING_TAR.get())) {
            itemEntity.level().setBlock(itemEntity.blockPosition(), Blocks.AIR.defaultBlockState(), 3);
            itemEntity.level().playSound(null, itemEntity.blockPosition(), LAVA_EXTINGUISH, BLOCKS, 1, 1);
            itemEntity = itemEntity.copy();
            itemEntity.setItem(shadow_stone.toStack(itemEntity.getItem().getCount()));
            itemEntity.level().addFreshEntity(itemEntity);
            Vec3 pos = itemEntity.position();
            if(itemEntity.level() instanceof ServerLevel s) s.sendParticles(ParticleTypes.SMOKE, pos.x, pos.y, pos.z, 25, .5, .5, .5, .01);
        }
    }
}