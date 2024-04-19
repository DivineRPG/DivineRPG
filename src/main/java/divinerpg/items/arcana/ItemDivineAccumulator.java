package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.*;
import divinerpg.util.packets.PacketDivineAccumulator;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class ItemDivineAccumulator extends ItemMod {
    public ItemDivineAccumulator() {
        super(new Properties().stacksTo(1));
        arcanaConsumed = 80;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        int x = (int) player.xo, y = (int) player.yo, z = (int) player.zo;
        return player.getCapability(ArcanaProvider.ARCANA).map(arcana -> {
            if(arcana.getArcana() >= arcanaConsumed) {
                arcana.consume(player, arcanaConsumed);
                player.awardStat(Stats.ITEM_USED.get(this));
                //To fix: doesn't work when you use it the moment you jump
                DivineRPGPacketHandler.INSTANCE.sendToServer(new PacketDivineAccumulator(x, y, z));
                player.setDeltaMovement(player.getDeltaMovement().x, 2, player.getDeltaMovement().z);
                player.playSound(SoundRegistry.DIVINE_ACCUMULATOR.get(), 1, 1);
                player.getCooldowns().addCooldown(this, 10);
                return InteractionResultHolder.success(player.getItemInHand(hand));
            } return super.use(world, player, hand);
        }).orElse(null);
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> list, TooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.launch"));
        list.add(LocalizeUtils.i18n("tooltip.divine_accumulator.fall"));
        super.appendHoverText(stack, worldIn, list, flagIn);
    }
}