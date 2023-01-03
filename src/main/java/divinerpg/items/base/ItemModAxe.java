package divinerpg.items.base;

import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemModAxe extends AxeItem {
    public ItemModAxe(Tier tier, Rarity rarity) {
        super(tier, 0, -3.4F, new Item.Properties().rarity(rarity));
    }

    public ItemModAxe(Tier tier) {
        super(tier, 0, -3.4F, new Item.Properties());
    }
    public ItemModAxe(Tier tier, Properties properties) {
        super(tier, 0, -3.4F, properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        }
    }
}
