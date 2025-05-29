package divinerpg.items.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;

public class ItemApalachiaHeart extends ItemMod {
    public static final ResourceLocation ADVANCEMENT = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "twilight/sky_fall");
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), BlockRegistry.enchantedFlame.get(), BlockRegistry.skyFire.get().defaultBlockState())) {
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, 1);
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1, 1);
            ServerPlayer player = (ServerPlayer) itemEntity.level().getNearestPlayer(itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 100, false);
            Utils.awardAdvancement(((ServerLevel) itemEntity.level()).getServer(), player, ADVANCEMENT, "create_sky_fire");
        }
    }
}