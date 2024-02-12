package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.util.DivineRPGPacketHandler;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.packets.PacketDivineAccumulator;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineAccumulator extends ItemMod {
    public ItemDivineAccumulator() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            int x = (int) player.xo, y = (int) player.yo, z = (int) player.zo;
            player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                if (arcana.getArcana() >= 80) {
                		DivineRPGPacketHandler.INSTANCE.sendToServer(new PacketDivineAccumulator(x, y, z));
                        world.playSound(player, player.blockPosition(), SoundRegistry.DIVINE_ACCUMULATOR.get(), SoundSource.PLAYERS, 1, 1);
                        arcana.consume(player, 80);
                    player.setDeltaMovement(player.getDeltaMovement().x, 2, player.getDeltaMovement().z);
                }
            });
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.launch"));
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.fall"));
        list.add(LocalizeUtils.arcanaConsumed(80));
        list.add(LocalizeUtils.infiniteUses());
    }
}
