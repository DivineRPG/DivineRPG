package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.*;

import javax.annotation.*;
import java.util.*;

public class ItemSerenadeStriker extends ItemMod {
    public ItemSerenadeStriker() {
        super(new Properties().tab(DivineRPG.tabs.ranged).durability(100));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_striker"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int blockReachDistance = 32;
        Vec3 vec3d = player.getEyePosition(1);
        Vec3 vec3d1 = player.getViewVector(1);
        Vec3 vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockHitResult pos = player.level.clip(new ClipContext(vec3d, vec3d2, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        if (world.getBlockState(pos.getBlockPos()) != null) {
            LightningBolt bolt1 = new LightningBolt(EntityType.LIGHTNING_BOLT, world), bolt2 = new LightningBolt(EntityType.LIGHTNING_BOLT, world), bolt3 = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
            bolt1.moveTo(pos.getLocation());
            bolt2.moveTo(pos.getLocation());
            bolt3.moveTo(pos.getLocation());
            world.addFreshEntity(bolt1);
            world.addFreshEntity(bolt2);
            world.addFreshEntity(bolt3);
            if (!player.isCreative()) {
                stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                    p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }

        return new InteractionResultHolder<ItemStack>(InteractionResult.SUCCESS, stack);
    }
}
