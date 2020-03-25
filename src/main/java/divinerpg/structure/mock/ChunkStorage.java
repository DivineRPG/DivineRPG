package divinerpg.structure.mock;

import divinerpg.structure.mock.interfaces.IChunkPrimer;
import divinerpg.structure.mock.interfaces.IChunkStorage;
import divinerpg.utils.NbtUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChunkStorage implements IChunkStorage {
    private final IChunkPrimer primer = new ChunkPrimer();
    private final Map<BlockPos, NBTTagCompound> tiles = new HashMap<>();
    private final Map<BlockPos, NBTTagCompound> entities = new HashMap<>();

    private ChunkPos pos;

    public ChunkStorage(ChunkPos pos) {
        this.pos = pos;
    }

    /**
     * NBT ctor
     */
    public ChunkStorage() {
    }

    @Override
    public ChunkPos getPos() {
        return pos;
    }

    @Override
    public Map<BlockPos, NBTTagCompound> getTiles() {
        return tiles;
    }

    @Override
    public Map<BlockPos, NBTTagCompound> getEntities() {
        return entities;
    }

    @Override
    public Map<BlockPos, IBlockState> getBlocks() {
        LinkedHashMap<BlockPos, IBlockState> map = new LinkedHashMap<>();

        ChunkPos chunkPos = getPos();

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 256; y++) {
                for (int z = 0; z < 16; z++) {
                    IBlockState state = primer.getBlockState(x, y, z);
                    if (state == null)
                        continue;

                    map.put(chunkPos.getBlock(x, y, z), state);
                }
            }
        }

        return map;
    }

    @Override
    public void addEntity(Entity e) {
        if (e != null) {
            entities.put(e.getPosition(), e.serializeNBT());
        }
    }

    @Override
    public void setBlockState(BlockPos pos, IBlockState state, @Nullable TileEntity entity) {
        if (pos != null && state != null)
            primer.setBlockStateFromAbsolute(pos, state);

        if (entity != null) {
            tiles.put(entity.getPos(), entity.serializeNBT());
        }
    }

    @Nullable
    @Override
    public IBlockState getBlockStateFromAbsolute(BlockPos pos) {
        return primer.getBlockStateFromAbsolute(pos);
    }

    @Override
    public StructureBoundingBox getSize() {
        List<BlockPos> poses = Stream.concat(getBlocks().keySet().stream(), tiles.keySet().stream())
                .distinct()
                .collect(Collectors.toList());

        return new StructureBoundingBox(
                poses.stream().map(Vec3i::getX).min(Integer::compareTo).orElse(0),
                poses.stream().map(Vec3i::getY).min(Integer::compareTo).orElse(0),
                poses.stream().map(Vec3i::getZ).min(Integer::compareTo).orElse(0),

                poses.stream().map(Vec3i::getX).max(Integer::compareTo).orElse(0),
                poses.stream().map(Vec3i::getY).max(Integer::compareTo).orElse(0),
                poses.stream().map(Vec3i::getZ).max(Integer::compareTo).orElse(0)
        );
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound result = new NBTTagCompound();

        NbtUtil.writeChunkPos(result, getPos());
        result.setTag("Primer", primer.serializeNBT());
        NbtUtil.tryWrite(result, "TileEntities", new ArrayList<>(tiles.values()));
        NbtUtil.tryWrite(result, "Entities", new ArrayList<>(entities.values()));

        return result;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        if (nbt == null)
            return;

        if (nbt.hasKey("Primer")) {
            NBTBase raw = nbt.getTag("Primer");
            if (raw instanceof NBTTagCompound) {
                primer.deserializeNBT((NBTTagCompound) raw);
            }
        }

        pos = NbtUtil.readChunkPos(nbt);

        NbtUtil.read(nbt, "TileEntities").forEach(x -> {
            tiles.put(NbtUtil.readPos(x), x);
        });

        NbtUtil.read(nbt, "Entities").forEach(x -> {
            entities.put(NbtUtil.readPos(x), x);
        });
    }
}
