package divinerpg.structure.legacy;

import divinerpg.structure.mock.WorldStorage;
import divinerpg.structure.mock.interfaces.IChunkStorage;
import divinerpg.structure.mock.interfaces.IWorldStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DivineStructureComponent extends StructureComponent {
    private IWorldStorage storage;

    /**
     * NBT ctor
     */
    public DivineStructureComponent() {
        boundingBox = StructureBoundingBox.getNewBoundingBox();
    }

    public DivineStructureComponent(IWorldStorage storage) {
        this();
        this.storage = storage;

        storage.getChunks().forEach(x -> boundingBox.expandTo(x.getSize()));
    }

    @Override
    protected void writeStructureToNBT(NBTTagCompound nbtTagCompound) {
        if (storage != null) {
            nbtTagCompound.setTag("Data", storage.serializeNBT());
        }
    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound nbtTagCompound, TemplateManager templateManager) {
        storage = new WorldStorage();
        storage.deserializeNBT(nbtTagCompound.getCompoundTag("Data"));
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox box) {
        if (storage == null)
            return false;

        List<IChunkStorage> chunks = storage.getChunks(box).collect(Collectors.toList());

        chunks.forEach(chunk -> {

            chunk.getBlocks().forEach((pos, state) -> setBlockState(world, state, pos.getX(), pos.getY(), pos.getZ(), box));

            chunk.createTilesForWorld(world).forEach((pos, entity) -> {
                if (box.isVecInside(pos))
                    world.addTileEntity(entity);
            });

            chunk.createEntitiesForWorld(world).forEach((pos, e) -> {
                if (box.isVecInside(pos))
                    world.spawnEntity(e);
            });
        });


        return true;
    }
}
