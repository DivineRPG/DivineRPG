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

public class ItemCaptainsSparkler extends ItemModRanged {

    public ItemCaptainsSparkler() {
        super("captains_sparkler", EntityRegistry.SPARKLER, null, SoundRegistry.SPARKLER, SoundCategory.MASTER, -1, 4, null, 7);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(20));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
