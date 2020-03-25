package divinerpg.structure.mock;

import divinerpg.structure.mock.interfaces.IChunkStorage;
import divinerpg.structure.mock.interfaces.IWorldStorage;
import divinerpg.utils.NbtUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorldStorage implements IWorldStorage {
    private final Map<ChunkPos, IChunkStorage> chunks = new LinkedHashMap<>();

    public WorldStorage() {

    }

    @Override
    public Stream<IChunkStorage> getChunks() {
        return chunks.values().stream();
    }

    @Override
    public void addEntity(Entity e) {
        getOrCreate(e.getPosition()).addEntity(e);
    }

    @Override
    public void setBlockState(BlockPos pos, IBlockState state) {
        getOrCreate(pos).setBlockState(pos, state);
    }

    @Override
    public void addTileEntity(TileEntity entity) {
        getOrCreate(entity.getPos()).setBlockState(null, null, entity);
    }

    @Override
    public IBlockState getBlockState(BlockPos pos) {
        return getOrCreate(pos).getBlockStateFromAbsolute(pos);
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        NbtUtil.tryWrite(tag, "Chunks", chunks.values().stream().map(INBTSerializable::serializeNBT).collect(Collectors.toList()));
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        NbtUtil.read(nbt, "Chunks").forEach(x -> {
            ChunkStorage storage = new ChunkStorage();
            storage.deserializeNBT(x);
            chunks.put(storage.getPos(), storage);
        });
    }

    private IChunkStorage getOrCreate(BlockPos pos) {
        return chunks.computeIfAbsent(new ChunkPos(pos), ChunkStorage::new);
    }
}
