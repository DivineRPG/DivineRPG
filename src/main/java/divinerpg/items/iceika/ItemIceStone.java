package divinerpg.items.iceika;

import divinerpg.DivineRPG;
import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.util.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;

import static divinerpg.registries.BlockRegistry.icyFire;
import static divinerpg.registries.SoundRegistry.FREEZE;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.level.block.Blocks.FIRE;

public class ItemIceStone extends ItemMod {
    public static final ResourceLocation ADVANCEMENT = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/freezing_fire");
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), FIRE, icyFire.get().defaultBlockState())) {
            itemEntity.level().playSound(null, itemEntity.blockPosition(), FREEZE.get(), BLOCKS, 1, 1);
            ServerPlayer player = (ServerPlayer) itemEntity.level().getNearestPlayer(itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 100, false);
            Utils.awardAdvancement(((ServerLevel) itemEntity.level()).getServer(), player, ADVANCEMENT, "create_icy_fire");
        }
    }
}