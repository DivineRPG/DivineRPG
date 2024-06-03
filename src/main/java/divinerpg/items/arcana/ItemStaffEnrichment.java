package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import javax.annotation.Nullable;
import java.util.List;

public class ItemStaffEnrichment extends ItemMod {
    public ItemStaffEnrichment() {super(new Properties().durability(100));}
    @Override public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Block block = level.getBlockState(pos).getBlock();
        if(block == BlockRegistry.arcaniteDirt.get()) {
            //TODO: to improve the particles or the item's functionality I guess,
            // this levelEvent adds particles on other blocks around when possible, just like bone meal does
            level.levelEvent(1505, pos, 0);
            level.setBlock(pos, BlockRegistry.arcaniteGrass.get().defaultBlockState(), 0);
            player.getItemInHand(hand).hurtAndBreak(1, player, (ctx) -> ctx.broadcastBreakEvent(player.getUsedItemHand()));
            return InteractionResult.SUCCESS;
        } return super.useOn(context);
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("staff_of_enrichment"));
        super.appendHoverText(stack, level, tooltip, flagIn);
    }
}