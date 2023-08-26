package divinerpg.items.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEnderScepter extends ItemMod {

    public ItemEnderScepter() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if (arcana.getArcana() >= 75) {
                Vec3 start = player.getEyePosition(1);
                Vec3 vec31 = player.getViewVector(1);
                Vec3 end = start.add(vec31.x * 32, vec31.y * 32, vec31.z * 32);
                ClipContext pos = new ClipContext(start, end, ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, player);

                player.fallDistance = 0;
                player.ejectPassengers();
                player.moveTo(pos.getTo());
                player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1, 1);
                arcana.consume(player, 75);
            }
        });

        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaConsumed(75));
        tooltip.add(LocalizeUtils.i18n("tooltip.ender_scepter"));
        tooltip.add(LocalizeUtils.infiniteUses());
    }
}