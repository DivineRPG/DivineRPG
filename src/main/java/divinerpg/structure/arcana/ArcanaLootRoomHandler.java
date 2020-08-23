package divinerpg.structure.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.npc.*;
import divinerpg.registry.LootTableRegistry;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

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
                    WorldGenUtils.populateLootChestBelow(world, pos, random, LootTableRegistry.BANQUET_HALL_LOOT);
                    break;
                case "UtilityHallwayLoot":
                    WorldGenUtils.populateLootChestBelow(world, pos, random, LootTableRegistry.UTILITY_HALLWAY_LOOT);
                    break;
                default:
                    DivineRPG.logger.warn("Unexpected data marker: " + entry.getValue() + " in a structure, please report this.");
                    break;
            }

            if(world.getBlockState(pos).getBlock() == Blocks.STRUCTURE_BLOCK) {
                world.setBlockToAir(pos);
            }
        }
    }
}
