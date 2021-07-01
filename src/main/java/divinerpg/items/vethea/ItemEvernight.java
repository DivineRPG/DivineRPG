package divinerpg.items.vethea;

import divinerpg.items.vanilla.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemEvernight extends ItemStaff {
    public ItemEvernight(int dam, int arcana, String name) {
        super(dam, arcana, name);
    }

    @Override
    protected void doPreUsageEffects(World world, PlayerEntity player) {
        player.hurt(DamageSources.arcanaSource, 20);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.staff.evernight.damage"));
    }
}
