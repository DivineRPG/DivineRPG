package divinerpg.utils;

import divinerpg.DivineRPG;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;

import javax.annotation.Nonnull;
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
     * Gets unique Divine tag from player.
     * Should always use that method to store data to prevent overwriting by other mods
     *
     * @param e - entity
     * @return
     */
    public static NBTTagCompound getPersistedDivineTag(@Nonnull EntityPlayer e) {
        NBTTagCompound playerData = e.getEntityData();

        if (!playerData.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
            playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, new NBTTagCompound());
        }

        NBTTagCompound persistantData = playerData.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);

        if (!persistantData.hasKey(DivineRPG.MODID)) {
            persistantData.setTag(DivineRPG.MODID, new NBTTagCompound());
        }

        return persistantData.getCompoundTag(DivineRPG.MODID);
    }

    /**
     * Read position/dimension from NBT tag
     *
     * @param tag    - NBT  tag
     * @param dimKey - dimension tag name
     * @param posKey - position tag name
     * @return
     */
    @Nullable
    public static Tuple<DimensionType, BlockPos> tryReaPosition(NBTTagCompound tag, String dimKey, String posKey) {
        if (tag == null || dimKey == null || posKey == null
                || !tag.hasKey(dimKey) || !tag.hasKey(posKey))
            return null;

        return new Tuple<>(DimensionType.byName(tag.getString(dimKey)),
                BlockPos.fromLong(tag.getLong(posKey)));
    }
}
