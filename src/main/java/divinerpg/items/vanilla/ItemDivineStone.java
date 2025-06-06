package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.blocks.vanilla.FireBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.util.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.item.ItemEntity;

import java.util.List;

import static divinerpg.registries.BlockRegistry.divineFlame;
import static net.minecraft.world.level.block.Blocks.FIRE;

public class ItemDivineStone extends ItemMod {
    public static final ResourceLocation ADVANCEMENT = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "divine/the_link");
    @Override public void onDestroyed(ItemEntity itemEntity, DamageSource damageSource) {
        if((damageSource.is(DamageTypes.IN_FIRE) || damageSource.is(DamageTypes.ON_FIRE)) && FireBlock.convertFire(itemEntity.level(), itemEntity.blockPosition(), FIRE, divineFlame.get().defaultBlockState())) {
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, 1);
            itemEntity.level().playSound(null, itemEntity.blockPosition(), SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1, 1);
            ServerLevel s = (ServerLevel) itemEntity.level();
            List<ServerPlayer> players = Utils.getNearbyPlayers(s, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), 9);
            for(ServerPlayer player : players) Utils.awardAdvancement(s.getServer(), player, ADVANCEMENT, "create_divine_flame");
        }
    }
}