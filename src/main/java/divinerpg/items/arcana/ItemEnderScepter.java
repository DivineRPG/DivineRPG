package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemEnderScepter extends ItemMod {

    public ItemEnderScepter() {
        super("ender_scepter", new Properties().tab(DivineRPG.tabs.melee).stacksTo(1));
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        Arcana arcana = player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
        if (!world.isClientSide && arcana.getArcana() >= 75) {
            Vector3d start  = player.getEyePosition(1);
            Vector3d vec31 = player.getViewVector(1);
            Vector3d end = start.add(vec31.x * 32, vec31.y * 32, vec31.z * 32);
            RayTraceContext pos = new RayTraceContext(start, end, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, player);

            player.fallDistance = 0;
            player.ejectPassengers();
            player.moveTo(pos.getTo());
            player.playSound(SoundEvents.PORTAL_TRAVEL, 1, 1);
            arcana.consume(player, 75);
            return super.use(world, player, hand);
        }
        return super.use(world, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaConsumed(75));
        tooltip.add(LocalizeUtils.i18n("tooltip.ender_scepter"));
        tooltip.add(LocalizeUtils.infiniteUses());
    }
}