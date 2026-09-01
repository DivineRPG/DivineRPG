package divinerpg.items.vethea;

import divinerpg.registries.BlockRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.Consumer;

public class ItemNightmareBed extends BlockItem {
    public ItemNightmareBed(Properties properties) {super(BlockRegistry.nightmareBed.get(), properties.stacksTo(1));}
    protected boolean placeBlock(BlockPlaceContext context, BlockState state) {return context.getLevel().setBlock(context.getClickedPos(), state, 26);}

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(LocalizeUtils.i18n("nightmare_bed"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

}