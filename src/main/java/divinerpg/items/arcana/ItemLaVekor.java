package divinerpg.items.arcana;

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

public class ItemLaVekor extends ItemModRanged {

    public ItemLaVekor() {
        super("la_vekor", EntityRegistry.GRENADE, null, SoundRegistry.LA_VEKOR, SoundCategory.MASTER, -1, 0, () -> ItemRegistry.grenade,
                5);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.explosiveShots());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
