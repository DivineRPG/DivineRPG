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

public class ItemGeneralsStaff extends ItemModRanged {

    public ItemGeneralsStaff() {
        super("generals_staff", EntityRegistry.GENERALS_STAFF, null, SoundRegistry.STARLIGHT, SoundCategory.MASTER, -1, 12,
                null, 20);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(18));
        tooltip.add(LocalizeUtils.i18n("tooltip.generals_staff.split"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
