package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemModShovel extends ShovelItem {
    public ItemModShovel(Tier tier, Rarity rarity) {super(tier, 0, -3, new Properties().rarity(rarity));}
    public ItemModShovel(Tier tier) {super(tier, 0, -3, new Properties());}
    public ItemModShovel(Tier tier, Properties properties) {super(tier, 0, -3, properties);}
    @SuppressWarnings("deprecation")
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)speed));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}