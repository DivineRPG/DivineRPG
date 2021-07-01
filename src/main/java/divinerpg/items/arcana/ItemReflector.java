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

public class ItemReflector extends ItemModRanged {
    public ItemReflector() {
        super("arcanium_reflector",
                EntityRegistry.REFLECTOR,
                null,
                SoundRegistry.REFLECTOR,
                SoundCategory.MASTER,
                -1,
                0,
                null,
                20,
                DivineRPG.tabs.utilities);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.refector.push"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
