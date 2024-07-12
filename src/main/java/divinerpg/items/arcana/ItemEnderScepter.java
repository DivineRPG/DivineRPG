package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemEnderScepter extends ItemMod {
    public ItemEnderScepter() {
        super(new Properties().stacksTo(1));
        arcanaConsumedUse = 75;
        cooldown = 10;
    }
    @Override
    protected InteractionResultHolder<ItemStack> arcanicUse(Level level, Player player, InteractionHand hand) {
        int blockReachDistance = 40;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level().clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
    	player.resetFallDistance();
        if(player.isPassenger()) player.stopRiding();
        for(int i = 0; i < 5; i++) level.addParticle(ParticleTypes.PORTAL, player.getX() + player.getRandom().nextDouble() - .5, player.getY(), player.getZ() + player.getRandom().nextDouble() - .5, 0, 0, 0);
        player.moveTo(pos.getLocation());
        for(int i = 0; i < 5; i++) level.addParticle(ParticleTypes.PORTAL, player.getX() + player.getRandom().nextDouble() - .5, player.getY(), player.getZ() + player.getRandom().nextDouble() - .5, 0, 0, 0);
        player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1, 1);
    	return InteractionResultHolder.success(player.getItemInHand(hand));
    }
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("ender_scepter"));
        super.appendHoverText(stack, context, tooltip, flagIn);
        stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
}