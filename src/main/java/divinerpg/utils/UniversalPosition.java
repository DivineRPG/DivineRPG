package divinerpg.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public record UniversalPosition(ResourceKey<Level> dimension, Vec3 pos) {
    public UniversalPosition(Level level, Vec3 pos) {
        this(level.dimension(), pos);
    }
    public UniversalPosition(ResourceKey<Level> dimension, BlockPos pos) {
        this(dimension, toVec3(pos));
    }
    public UniversalPosition(Level level, BlockPos pos) {
        this(level.dimension(), toVec3(pos));
    }
    public BlockPos blockPos() {
        return new BlockPos((int)pos.x, (int)pos.y, (int)pos.z);
    }
    public Vec3 blockPosVec() {
        return new Vec3(Math.floor(pos.x), Math.floor(pos.y), Math.floor(pos.z));
    }
    public ChunkPos chunkPos() {
        return new ChunkPos((int)pos.x >> 4, (int)pos.z >> 4);
    }
    public ServerLevel level(MinecraftServer server) {
        return server.getLevel(dimension);
    }
    @Override
    public boolean equals(Object o) {
        return o != null && (o == this || (o instanceof UniversalPosition(ResourceKey<Level> dimension1, Vec3 pos1) && dimension1 == dimension && pos1.equals(pos)));
    }
    public static BlockPos toBlockPos(Vec3 v) {
        return new BlockPos((int)v.x, (int)v.y, (int)v.z);
    }
    public static Vec3 toVec3(BlockPos p) {return new Vec3(p.getX(), p.getY(), p.getZ());}

    @Override
    public String toString() {
        return dimension.identifier().getPath() + ", " + pos;
    }
}