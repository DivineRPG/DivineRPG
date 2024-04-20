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
import net.minecraft.world.phys.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemEnderScepter extends ItemMod {
    public ItemEnderScepter() {
        super(new Properties().stacksTo(1));
        arcanaConsumedUse = 75;
        cooldown = 10;
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        int blockReachDistance = 40;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() >= arcanaConsumedUse) {
                player.resetFallDistance();
                if(player.isPassenger()) player.stopRiding();
                player.moveTo(pos.getLocation());
                //TODO: add teleport particles (just like those when eating a chorus fruit)
                player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1, 1);
            }
        }); return super.use(level, player, hand);
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.ender_scepter"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.infiniteUses());
    }
}