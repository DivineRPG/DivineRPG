package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.Utils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Blocks;

public class ItemTorriditeChunk extends ItemMod {
    public static final ResourceLocation ADVANCEMENT = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "nether/tormented_souls");
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), Blocks.SOUL_FIRE, BlockRegistry.hellFire.get().defaultBlockState()) && itemEntity.level() instanceof ServerLevel s) {
            s.sendParticles(ParticleTypes.SOUL, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 4, .2, .2, .2, 0);
            s.playSound(null, itemEntity.blockPosition(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, .6F, 1.5F);
            //TODO: wait till someone would get the crash
            ServerPlayer player = (ServerPlayer) s.getNearestPlayer(itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 100, false);
            Utils.awardAdvancement(((ServerLevel) itemEntity.level()).getServer(), player, ADVANCEMENT, "look_into_the_eye");
        }
    }
}