package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.entities.projectile.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemSerenadeOfDeath extends ItemMod {

    public ItemSerenadeOfDeath() {
        super("serenade_of_death", new Properties().tab(DivineRPG.tabs.ranged).durability(500));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_death"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
        tooltip.add(LocalizeUtils.rangedDam(14));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            world.playSound(null, player.blockPosition(), SoundRegistry.SERENADE, SoundCategory.MASTER, 1, 1);
            ThrowableEntity bullet = new EntitySerenadeOfDeath(EntityRegistry.SERENADE_OF_DEATH, player, world);
            bullet.moveTo(player.getX(), player.getEyeY(), player.getZ());
            bullet.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(bullet);
            if (!player.isCreative()) {
                stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                    p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }
}
