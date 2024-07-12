package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemModShovel extends ShovelItem {
    public ItemModShovel(Tier tier, Rarity rarity) {super(tier, 0, -3, new Properties().rarity(rarity));}
    public ItemModShovel(Tier tier) {super(tier, 0, -3, new Properties());}
    public ItemModShovel(Tier tier, Properties properties) {super(tier, 0, -3, properties);}
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)speed));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
        if(!stack.isDamageableItem()) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
}