package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemSerenadeStriker extends ItemMod {
    public ItemSerenadeStriker() {
        super("serenade_striker", new Properties().tab(DivineRPG.tabs.ranged).durability(100));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_striker"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int blockReachDistance = 32;
        Vector3d vec3d = player.getEyePosition(1);
        Vector3d vec3d1 = player.getViewVector(1);
        Vector3d vec3d2 = vec3d.add(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        BlockRayTraceResult pos = player.level.clip(new RayTraceContext(vec3d, vec3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, player));

        if (world.getBlockState(pos.getBlockPos()) != null) {
            LightningBoltEntity bolt1 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world), bolt2 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world), bolt3 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
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

        return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
    }
}
