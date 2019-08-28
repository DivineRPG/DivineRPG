package divinerpg.utils;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

/**
 * Created by LiteWolf101 on Feb
 * /18/2019
 */
public class DRPGLootTables extends LootTableList {
    public static final ResourceLocation ICEIKA_CHEST_DUNGEON = register("chests/iceika_chest_dungeon");
    public static final ResourceLocation ICEIKA_CHEST_HUT = register("chests/iceika_chest_hut");

    private static ResourceLocation register(String id) {
        return register(new ResourceLocation("divinerpg", id));
    }
}
