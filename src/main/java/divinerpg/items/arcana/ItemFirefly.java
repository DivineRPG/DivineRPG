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

public class ItemFirefly extends ItemModRanged {
    public ItemFirefly() {
        super("firefly", EntityRegistry.FIREFLY, null, SoundRegistry.FIREFLY, SoundCategory.PLAYERS, -1, 0, null, 5);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.homingShots());
        tooltip.add(LocalizeUtils.rangedDam(15));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
