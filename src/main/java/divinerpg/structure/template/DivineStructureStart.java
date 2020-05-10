package divinerpg.structure.template;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public class DivineStructureStart extends StructureStart {


    /**
     * NBT creating ctor
     */
    public DivineStructureStart() {
    }

    /**
     * Generates large structure from 16*16 parts.
     * For linking each part together user relative chunk coords in file name ( [0;0].nbt )
     * Simple square generation is presented below. It's splitted in 4 parts with names:
     * [0;0].nbt
     * [1;0].nbt
     * [0;1].nbt
     * [1;1].nbt
     * <p>
     * OX is increased there ->
     * __________________________       OZ increased there
     * |           |            |       |
     * |   [0;0]   |   [1;0]    |       |
     * |           |            |      \/
     * ____________|____________|
     * |           |            |
     * | [1;0]     |   [1;1]    |
     * --------------------------
     *
     * @param location - folder location of giant structure.
     * @param manager  - Template loader manager
     * @param chunkX   - chunk X cord
     * @param y        - height of structure
     * @param chunkZ   - chunk Z cord
     */
    public DivineStructureStart(ResourceLocation location, TemplateManager manager, int chunkX, int y, int chunkZ, int structureSizeX, int structureSizeZ) {
        super(chunkX, chunkZ);

        for(int x = 0; x < structureSizeX; x++) {
            for(int z = 0; z < structureSizeZ; z++) {
                String fileName = "[" + x + ", " + z + "]";
                ResourceLocation partLocation = new ResourceLocation(location.getResourceDomain(), location.getResourcePath() + "/" + fileName);
                BlockPos pos = fromString(fileName, chunkX, chunkZ).getBlock(0, y, 0);
                components.add(new DivineStructureComponentTemplate(manager, partLocation, pos));
            }
        }

        this.updateBoundingBox();
    }

    /**
     * Parse from ChunkPos.ToString
     *
     * @param chunkPosRaw - raw string
     * @return
     */
    private ChunkPos fromString(String chunkPosRaw, int xOffset, int zOffset) {
        chunkPosRaw = chunkPosRaw.replaceAll("[\\[\\] ]", "");
        String[] numbers = chunkPosRaw.split("[,]");

        return new ChunkPos(xOffset + Integer.parseInt(numbers[0]), zOffset + Integer.parseInt(numbers[1]));
    }

    /**
     * Tries to load resource folder
     *
     * @param structureFolder - location of folder with structures
     * @param result          - result reference
     * @return - Is loaded successfullt
     */
    private boolean tryGetFile(ResourceLocation structureFolder, AtomicReference<File> result) {
        // Find URL of resource
        URL folder = this.getClass().getResource("/assets/" + structureFolder.getResourceDomain() + "/structures/" + structureFolder.getResourcePath());
        File dir;
        try {
            // creating File
            dir = new File(folder.toURI());
            // checking if it is a directory
            if (!dir.isDirectory())
                return false;

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }

        result.set(dir);
        return true;
    }
}
