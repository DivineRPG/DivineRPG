package divinerpg.items.arcana;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemStaffEnrichment extends ItemMod {


    public ItemStaffEnrichment() {
        super("staff_of_enrichment", new Properties().tab(DivineRPG.tabs.tools).durability(100));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        ItemStack stack = player.getItemInHand(hand);
        if (!world.mayInteract(player, pos)) {
            return ActionResultType.FAIL;
        } else {
            Block var11 = world.getBlockState(pos).getBlock();

            if (var11 == BlockRegistry.arcaniteDirt) {
                Block var13 = BlockRegistry.arcaniteGrass;
                player.playSound(SoundEvents.METAL_STEP, 0.8f, 0.8f);
                if (world.isClientSide) {
                    return ActionResultType.PASS;
                } else {
                    world.setBlock(pos, var13.defaultBlockState(), 0);
                    stack.hurtAndBreak(1, player, (ctx) -> {
                        ctx.broadcastBreakEvent(player.getUsedItemHand());
                    });
                    return ActionResultType.PASS;
                }
            }
        }
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.staff_of_enrichment"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }
}
