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
        Vector3d start  = player.getEyePosition(1);
        Vector3d vec31 = player.getViewVector(1);
        Vector3d end = start.add(vec31.x * 100, vec31.y * 100, vec31.z * 100);
        RayTraceContext pos = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, player);

        double i = pos.getTo().x;
        double j = pos.getTo().y;
        double k = pos.getTo().z;

        if (world.getBlockState(new BlockPos(i, j, k)) != null) {
            LightningBoltEntity bolt1 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world), bolt2 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world), bolt3 = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
            bolt1.moveTo(i,j,k);
            bolt2.moveTo(i,j,k);
            bolt3.moveTo(i,j,k);
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
