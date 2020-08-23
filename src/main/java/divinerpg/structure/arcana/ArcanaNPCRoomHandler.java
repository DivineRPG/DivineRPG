package divinerpg.structure.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.npc.*;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ArcanaNPCRoomHandler extends ArcanaStructureHandler {

    public ArcanaNPCRoomHandler(String name) {
        super(name);
    }

    @Override
    public void handleDataMarkers(World world, Random random, Iterator iterator) {
        while(iterator.hasNext()) {
            Map.Entry<BlockPos, String> entry = (Map.Entry)iterator.next();
            BlockPos pos = entry.getKey();

            switch(entry.getValue()) {
                case "CaptainMerik":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityCaptainMerik(world));
                    break;
                case "Datticon":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityDatticon(world));
                    break;
                case "Kazari":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityKazari(world));
                    break;
                case "Leorna":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityLeorna(world));
                    break;
                case "LordVatticus":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityLordVatticus(world));
                    break;
                case "WarGeneral":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityWarGeneral(world));
                    break;
                case "Zelus":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityZelus(world));
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
