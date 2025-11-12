package divinerpg.compat.farmersdelight;

import divinerpg.enums.ToolStats;
import net.minecraft.world.item.*;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class CookingKnife extends KnifeItem {
    public ToolStats sword;
    public CookingKnife(Tier tier) {
        super(tier, new Properties().attributes(SwordItem.createAttributes(tier, 1, -2.4F)));
        sword = (ToolStats)tier;
    }
}