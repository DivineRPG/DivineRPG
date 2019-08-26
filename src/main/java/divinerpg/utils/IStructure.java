package divinerpg.utils;

import divinerpg.Config;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by LiteWolf101 on Jan
 * /27/2019
 */
public interface IStructure {
    WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(Config.iceikaDimensionId);
    PlacementSettings settings = (new PlacementSettings()).setChunk(null).setIgnoreEntities(false).setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
}
