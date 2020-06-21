package divinerpg.structure.base;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.template.TemplateManager;

public abstract class DivineStructureStart extends StructureStart {

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
     * @param altitude        - height of structure
     * @param chunkZ   - chunk Z cord
     */
    public DivineStructureStart(ResourceLocation location, TemplateManager manager, Rotation rotation, int chunkX, int altitude, int chunkZ, int structureSizeX, int structureSizeZ) {
        super(chunkX, chunkZ);
        this.setupComponents(location, manager, rotation, chunkX, altitude, chunkZ, structureSizeX, structureSizeZ);
        this.updateBoundingBox();
    }

    private void setupComponents(ResourceLocation location, TemplateManager manager, Rotation rotation, int chunkX, int y, int chunkZ, int structureSizeX, int structureSizeZ) {
        for(int x = 0; x < structureSizeX; x++) {
            for(int z = 0; z < structureSizeZ; z++) {
                String fileName = "[" + x + ", " + z + "]";
                ResourceLocation partLocation = new ResourceLocation(location.getResourceDomain(), location.getResourcePath() + "/" + fileName);

                int rotationXOffset = x;
                int rotationZOffset = z;
                if(rotation == Rotation.NONE) {
                    rotationXOffset = x;
                    rotationZOffset = z;
                }
                else if(rotation == Rotation.CLOCKWISE_90) {
                    rotationXOffset = -z;
                    rotationZOffset = x;
                }
                else if(rotation == Rotation.CLOCKWISE_180) {
                    rotationXOffset = -x;
                    rotationZOffset = -z;
                }
                else if(rotation == Rotation.COUNTERCLOCKWISE_90) {
                    rotationXOffset = z;
                    rotationZOffset = -x;
                }

                BlockPos pos = new ChunkPos(chunkX + rotationXOffset, chunkZ + rotationZOffset).getBlock(0, y, 0);
                components.add(this.getComponent(manager, partLocation, rotation, pos));
            }
        }
    }

    protected abstract StructureComponentTemplate getComponent(TemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos pos);
}
