package divinerpg.utils;

import divinerpg.api.java.divinerpg.api.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class NbtUtil {
    /**
     * Reads list of NBTTagCompound
     *
     * @param source - source tag
     * @param name   - name of NBTTagList
     * @return
     */
    public static List<NBTTagCompound> read(NBTTagCompound source, String name) {
        ArrayList<NBTTagCompound> result = new ArrayList<>();

        if (source != null && source.hasKey(name)) {
            NBTBase raw = source.getTag(name);

            if (raw instanceof NBTTagList) {
                ((NBTTagList) raw).iterator().forEachRemaining(x -> {
                    if (x instanceof NBTTagCompound) {
                        result.add((NBTTagCompound) x);
                    }
                });
            }
        }

        return result;
    }

    /**
     * Tries to write list of tags
     *
     * @param source - source NBT
     * @param name   - name of appending tag
     * @param tags   - list of tags
     */
    public static void tryWrite(NBTTagCompound source, String name, List<NBTTagCompound> tags) {
        if (tags == null || tags.isEmpty()) {
            return;
        }

        NBTTagList result = new NBTTagList();
        tags.forEach(result::appendTag);

        source.setTag(name, result);
    }

    /**
     * Store chunk pos in NBT
     *
     * @param source - nbt source
     * @param pos    - current position
     */
    public static void writeChunkPos(NBTTagCompound source, ChunkPos pos) {
        if (source != null && pos != null)
            source.setIntArray("ChunkPositions", new int[]{pos.x, pos.z});
    }

    /**
     * Reads chunk position from NBT
     *
     * @param source - source NBT
     * @return
     */
    public static ChunkPos readChunkPos(NBTTagCompound source) {
        if (source == null || !source.hasKey("ChunkPositions"))
            return new ChunkPos(0, 0);

        int[] poses = source.getIntArray("ChunkPositions");

        if (poses.length != 2)
            return new ChunkPos(0, 0);


        return new ChunkPos(poses[0], poses[1]);
    }

    /**
     * Read entity/Tile entity pos from tag
     *
     * @param tag
     * @return
     */
    public static BlockPos readPos(NBTTagCompound tag) {
        if (tag == null)
            return BlockPos.ORIGIN;

        // Entity format
        if (tag.hasKey("Pos")) {
            NBTBase raw = tag.getTag("Pos");
            if (raw instanceof NBTTagList) {
                NBTTagList list = (NBTTagList) raw;

                return new BlockPos(
                        list.getDoubleAt(0),
                        list.getDoubleAt(1),
                        list.getDoubleAt(2)
                );
            }
        }

        // tile entity format
        if (tag.hasKey("x") && tag.hasKey("y") && tag.hasKey("z")) {
            return new BlockPos(tag.getInteger("x"), tag.getInteger("y"), tag.getInteger("z"));
        }


        return BlockPos.ORIGIN;
    }

    /**
     * Gets tag from persistant data.
     *
     * @param e    - entity
     * @param name - name of tag
     * @return
     */
    @Nullable
    public static <T extends NBTBase> T getFromEntity(Entity e, String name, Class<T> clazz) {
        if (e == null || name == null || name.isEmpty()) {
            return null;
        }

        NBTTagCompound data = e.getEntityData();
        // Creating unique name for entity data to prevent overriding
        name = Reference.MODID + "_" + name;

        NBTBase tag = data.getTag(name);

        if (tag.getClass() == clazz)
            return (T) tag;

        return null;
    }

    /**
     * Writes tag to persistent data.
     *
     * @param e
     * @param tag
     * @param name
     */
    public static void writePersistent(Entity e, NBTBase tag, String name) {
        if (e == null || name == null || name.isEmpty() || tag == null) {
            return;
        }

        // Creating unique name for entity data to prevent overriding
        name = Reference.MODID + "_" + name;
        e.getEntityData().setTag(name, tag);
    }
}
