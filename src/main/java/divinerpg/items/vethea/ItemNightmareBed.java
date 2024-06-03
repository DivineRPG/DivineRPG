package divinerpg.items.vethea;

import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemNightmareBed extends BlockItem {
    public ItemNightmareBed() {super(BlockRegistry.nightmareBed.get(), new Properties().stacksTo(1));}
    protected boolean placeBlock(BlockPlaceContext context, BlockState state) {return context.getLevel().setBlock(context.getClickedPos(), state, 26);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("nightmare_bed"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}