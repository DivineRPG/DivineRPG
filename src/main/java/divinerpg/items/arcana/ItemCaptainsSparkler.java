package divinerpg.items.arcana;

import divinerpg.items.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.sounds.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemCaptainsSparkler extends ItemModRanged {

    public ItemCaptainsSparkler() {
        super("sparkler", null, () -> SoundRegistry.SPARKLER.get(), SoundSource.MASTER, -1, 4, null, 7);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.rangedDam(20));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}
