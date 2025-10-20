package divinerpg.items.vanilla;

import divinerpg.registries.BlockRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.minecraft.core.Direction.DOWN;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class AquaTorch extends StandingAndWallBlockItem {
    public AquaTorch() {super(BlockRegistry.aquaTorch.get(), BlockRegistry.aquaWallTorch.get(), new Properties(), DOWN);}
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("burns_underwater"));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}