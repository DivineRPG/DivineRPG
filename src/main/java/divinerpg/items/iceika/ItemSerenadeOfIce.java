package divinerpg.items.iceika;

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

public class ItemSerenadeOfIce extends ItemModRanged {
    public ItemSerenadeOfIce() {
        super("serenade_of_ice",
                null,
                () -> SoundRegistry.SERENADE.get(),
                SoundSource.MASTER,
                100,
                0,
                null,
                0, DivineRPG.tabs.utilities);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_ice"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
