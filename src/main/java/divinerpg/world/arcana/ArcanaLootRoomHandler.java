package divinerpg.world.arcana;

import divinerpg.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class ArcanaLootRoomHandler extends ArcanaStructureHandler {
    public ArcanaLootRoomHandler(String name) {
        super(name);
    }

    public void handleDataMarkers(World world, Random random, Iterator iterator) {
        while(iterator.hasNext()) {
            Map.Entry<BlockPos, String> entry = (Map.Entry)iterator.next();
            BlockPos pos = entry.getKey();

            switch(entry.getValue()) {
                case "BanquetHallLoot":
                    Utils.populateLootChestBelow(world, pos, random, LootTableRegistry.BANQUET_HALL_LOOT);
                    break;
                case "UtilityHallwayLoot":
                    Utils.populateLootChestBelow(world, pos, random, LootTableRegistry.UTILITY_HALLWAY_LOOT);
                    break;
                default:
                    DivineRPG.LOGGER.warn("Unexpected data marker: " + entry.getValue() + " in a structure, please report this.");
                    break;
            }

            if(world.getBlockState(pos).getBlock() == Blocks.STRUCTURE_BLOCK) {
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
            }
        }
    }
}
