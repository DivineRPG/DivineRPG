package divinerpg.items.arcana;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.BlockRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class ItemStaffEnrichment extends ItemMod {
    public ItemStaffEnrichment(Properties properties) {
        super(properties.durability(100));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Block block = level.getBlockState(pos).getBlock();
        if(block == BlockRegistry.arcaniteDirt.get()){
            level.levelEvent(1505, pos, 0);
            level.setBlock(pos, BlockRegistry.arcaniteGrass.get().defaultBlockState(), 0);
            player.getItemInHand(hand).hurtAndBreak(1, player, hand);
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.i18n("staff_of_enrichment"));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}
