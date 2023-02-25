package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemSerenadeOfDeath extends ItemMod {

    public ItemSerenadeOfDeath() {
        super(new Properties().tab(DivineRPG.tabs.ranged).durability(500));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_death"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
        tooltip.add(LocalizeUtils.rangedDam(14));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            world.playSound(null, player.blockPosition(), SoundRegistry.SERENADE.get(), SoundSource.MASTER, 1, 1);
            ThrowableProjectile bullet = new EntitySerenadeOfDeath(EntityRegistry.SERENADE_OF_DEATH.get(), player, world);
            bullet.moveTo(player.getX(), player.getEyeY(), player.getZ());
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(bullet);
            if (!player.isCreative()) {
                stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                    p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, stack);
    }
}
