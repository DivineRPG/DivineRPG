package divinerpg.items.iceika;

import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemMusicShooter extends ItemModRanged {

    public ItemMusicShooter(String name, SoundEvent event, EntityType type) {
        super(name, type, null, event, SoundCategory.MASTER, 4000, 0,
                () -> null,
                0);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (this == ItemRegistry.soundOfCarols) {
            tooltip.add(LocalizeUtils.rangedDam(16));
        } else {
            tooltip.add(LocalizeUtils.rangedDam(10));
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
