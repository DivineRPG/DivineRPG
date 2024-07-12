package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemModAxe extends AxeItem {
    public ItemModAxe(Tier tier, float attackSpeed, Rarity rarity) {super(tier, 0, attackSpeed, new Properties().rarity(rarity));}
    public ItemModAxe(Tier tier, float attackSpeed) {super(tier, 0, attackSpeed, new Properties());}
    public ItemModAxe(Tier tier, Properties properties) {super(tier, 0, -2.9F, properties);}
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)speed));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
        if(!stack.isDamageableItem()) stack.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
}