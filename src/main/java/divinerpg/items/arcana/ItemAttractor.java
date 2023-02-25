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

public class ItemAttractor extends ItemModRanged {

    public ItemAttractor() {
        super("attractor", null, () -> SoundRegistry.REFLECTOR.get(), SoundSource.PLAYERS, -1, 0, null, 20, DivineRPG.tabs.utilities);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.i18n("tooltip.arcanium_attractor"));
    }
}
