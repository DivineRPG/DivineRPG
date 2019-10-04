package divinerpg.utils;

import divinerpg.config.Config;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by LiteWolf101 on Jan
 * /27/2019
 */
public interface IStructure {
    /**
     * Getting current world server
     * @param world - world in current dimention
     */
    WorldServer getWorldServer(World world);

    /**
     * Default preset of placement settings
     * @param pos - template pos
     */
    PlacementSettings getSettings(BlockPos pos);
}
