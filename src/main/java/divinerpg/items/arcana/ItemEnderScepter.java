package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

public class ItemEnderScepter extends ItemMod {
    public ItemEnderScepter(Properties properties) {
        super(properties.stacksTo(1).component(DataComponents.UNBREAKABLE, Unit.INSTANCE));
    arcanaConsumedUse = 75;
    cooldown = 10;
    }

    @Override
    protected InteractionResult arcanicUse(Level level, Player player, InteractionHand hand) {
        int blockReachDistance = 40;
        Vec3 vec3Eye = player.getEyePosition(1);
        Vec3 vec3View = player.getViewVector(1);
        Vec3 vec3 = vec3Eye.add(vec3View.x * blockReachDistance, vec3View.y * blockReachDistance, vec3View.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3Eye, vec3, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        player.resetFallDistance();
        if(player.isPassenger()) player.stopRiding();
        for(int i = 0; i < 5; i++) level.addParticle(ParticleTypes.PORTAL, player.getX() + player.getRandom().nextDouble() - .5, player.getY(), player.getZ() + player.getRandom().nextDouble() - .5, 0, 0, 0);
        player.moveOrInterpolateTo(pos.getLocation());
        for(int i = 0; i < 5; i++) level.addParticle(ParticleTypes.PORTAL, player.getX() + player.getRandom().nextDouble() - .5, player.getY(), player.getZ() + player.getRandom().nextDouble() - .5, 0, 0, 0);
        player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1, 1);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.i18n("ender_scepter"));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}
