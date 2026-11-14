package divinerpg.items.base;

import divinerpg.registries.TagRegistry;
import divinerpg.utils.ToolStats;


public class ItemShickaxe extends ItemMod {
    public ItemShickaxe(ToolStats stats,Properties properties) {
        super(properties.hoe(stats.getMaterial(), 1.0F, -2.4F).pickaxe(stats.getMaterial(), 1.0F, -2.4F).shovel(stats.getMaterial(), 1.0F, -2.4F).axe(stats.getMaterial(), 1.0F, -2.4F).tool(stats.getMaterial(), TagRegistry.MINEABLE_WITH_SHICKAXE, 1.0F, -2.4F, 0));
    }
}
