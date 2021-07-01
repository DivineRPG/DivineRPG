package divinerpg.items.iceika;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemSerenadeOfIce extends ItemModRanged {
    public ItemSerenadeOfIce() {
        super("serenade_of_ice",
                EntityRegistry.SERENADE_OF_ICE,
                null,
                SoundRegistry.SERENADE,
                SoundCategory.MASTER,
                100,
                0,
                null,
                0, DivineRPG.tabs.utilities);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.serenade_of_ice"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
