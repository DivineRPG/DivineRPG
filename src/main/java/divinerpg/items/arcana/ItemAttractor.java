package divinerpg.items.arcana;

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

public class ItemAttractor extends ItemModRanged {

    public ItemAttractor() {
        super("arcanium_attractor", EntityRegistry.ATTRACTOR, null, SoundRegistry.REFLECTOR, SoundCategory.PLAYERS, -1, 0, null, 20, DivineRPG.tabs.utilities);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.i18n("tooltip.arcanium_attractor"));
    }
}
