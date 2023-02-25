package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemReflector extends ItemModRanged {
    public ItemReflector() {
        super("reflector",
                null,
                () -> SoundRegistry.REFLECTOR.get(),
                SoundSource.MASTER,
                -1,
                0,
                null,
                20, DivineRPG.tabs.utilities);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.refector.push"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
