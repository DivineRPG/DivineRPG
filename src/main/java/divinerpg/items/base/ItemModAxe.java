package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemModAxe extends AxeItem {
    public ItemModAxe(Tier tier, float attackSpeed, Rarity rarity) {super(tier, 0, attackSpeed, new Properties().rarity(rarity));}
    public ItemModAxe(Tier tier, float attackSpeed) {super(tier, 0, attackSpeed, new Properties());}
    public ItemModAxe(Tier tier, Properties properties) {super(tier, 0, -2.9F, properties);}
    @SuppressWarnings("deprecation")
	@OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency((int)speed));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));
        if(!canBeDepleted()) stack.getOrCreateTag().putBoolean("Unbreakable", true);
    }
}