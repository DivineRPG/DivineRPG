package divinerpg.structure.mock;

import divinerpg.structure.mock.interfaces.IChunkPrimer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraftforge.registries.GameData;

import javax.annotation.Nullable;
import java.util.Arrays;

public class ChunkPrimer implements IChunkPrimer {
    private static final ObjectIntIdentityMap<IBlockState> map = GameData.getBlockStateIDMap();
    private final int[] data = new int[65536];

    public ChunkPrimer() {
        // if 0 getBlockState will return Blocks.AIR
        // But it needs to return null
        Arrays.fill(data, -1);
    }

    // Stolen from original ChunkPrimer
    private static int getBlockIndex(int x, int y, int z) {
        return x << 12 | z << 8 | y;
    }

    @Override
    public void setBlockState(int x, int y, int z, IBlockState state) {
        if (!checkBounds(x, y, z))
            return;

        this.data[getBlockIndex(x, y, z)] = map.get(state);
    }

    @Nullable
    @Override
    public IBlockState getBlockState(int x, int y, int z) {
        if (!checkBounds(x, y, z))
            return null;

        return map.getByValue(this.data[getBlockIndex(x, y, z)]);
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound result = new NBTTagCompound();
        result.setIntArray("Blocks", data);
        return result;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("Blocks")) {
            int[] blocks = nbt.getIntArray("Blocks");
            System.arraycopy(blocks, 0, data, 0, Math.min(blocks.length, data.length));
        }
    }
}
