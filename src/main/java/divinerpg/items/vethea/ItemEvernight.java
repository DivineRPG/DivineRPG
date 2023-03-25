package divinerpg.items.vethea;

import divinerpg.items.vanilla.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemEvernight extends ItemStaff {
    public ItemEvernight(int dam, int arcana) {
        super(dam, arcana);
    }

    @Override
    protected void doPreUsageEffects(Level world, Player player) {
        player.hurt(DamageSources.source(world, DamageSources.ARCANA), 20);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.staff.evernight.damage"));
    }
}
