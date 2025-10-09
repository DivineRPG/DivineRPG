package divinerpg.items.vanilla;

import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;

import java.util.List;

import static net.minecraft.core.Direction.DOWN;

public class AquaTorch extends StandingAndWallBlockItem {
    public AquaTorch() {super(BlockRegistry.aquaTorch.get(), BlockRegistry.aquaWallTorch.get(), new Properties(), DOWN);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("burns_underwater"));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}