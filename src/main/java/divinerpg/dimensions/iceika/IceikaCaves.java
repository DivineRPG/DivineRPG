package divinerpg.dimensions.iceika;

import java.util.Random;

import divinerpg.registry.BlockRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenBase;

public class IceikaCaves extends MapGenBase {
    protected static final IBlockState BLOCK_AIR = Blocks.AIR.getDefaultState();

    protected void generateLargeCaveNode(long seed, int chunkX, int chunkZ, ChunkPrimer primer, double xx, double yy, double zz) {
        generateCaveNode(seed, chunkX, chunkZ, primer, xx, yy, zz, 1F + rand.nextFloat() * 3F, 0F, 0F, -1, -1, rand.nextDouble() * 0.5D + 0.3D);
    }

    @Override
    public void generate(World worldIn, int x, int z, ChunkPrimer primer) {
        int i = this.range;
        this.world = worldIn;
        this.rand.setSeed(worldIn.getSeed());
        long j = this.rand.nextLong();
        long k = this.rand.nextLong();

        for (int l = x - i; l <= x + i; ++l) {
            for (int i1 = z - i; i1 <= z + i; ++i1) {
                long j1 = (long) l * j;
                long k1 = (long) i1 * k;
                this.rand.setSeed(j1 ^ k1 ^ worldIn.getSeed());
                this.recursiveGenerate(worldIn, l, i1, x, z, primer);
            }
        }
    }

    protected void generateCaveNode(long seed, int chunkX, int chunkZ, ChunkPrimer primer, double xx, double yy, double zz, float innerSize, float xzAngle, float yAngle, int par15, int par16, double heightMp) {
        double centerX = chunkX * 16 + 8;
        double centerZ = chunkZ * 16 + 8;
        float f3 = 0F;
        float f4 = 0F;
        Random rand = new Random(seed);

        if (par16 <= 0) {
            int j1 = range * 16 - 16;
            par16 = j1 - rand.nextInt(j1 / 4);
        }

        boolean flag = false;

        if (par15 == -1) {
            par15 = par16 / 2;
            flag = true;
        }

        int k1 = rand.nextInt(par16 / 2) + par16 / 4;

        for (boolean steep = rand.nextInt(6) == 0; par15 < par16; ++par15) {
            double xzRange = 1.5D + MathHelper.sin(par15 * (float) Math.PI / par16) * innerSize * 1F;
            double yRange = xzRange * heightMp;
            float f5 = MathHelper.cos(yAngle);
            float f6 = MathHelper.sin(yAngle);
            xx += MathHelper.cos(xzAngle) * f5;
            yy += f6;
            zz += MathHelper.sin(xzAngle) * f5;

            if (steep)
                yAngle *= 0.92F;
            else
                yAngle *= 0.7F;

            yAngle += f4 * 0.1F;
            xzAngle += f3 * 0.1F;
            f4 *= 0.9F;
            f3 *= 0.75F;
            f4 += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * 2F;
            f3 += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * 4F;

            if (!flag && par15 == k1 && innerSize > 1F) {
                generateCaveNode(rand.nextLong(), chunkX, chunkZ, primer, xx, yy, zz, rand.nextFloat() * 0.5F + 0.5F, xzAngle - (float) Math.PI / 2F, yAngle / 3F, par15, par16, 1D);
                generateCaveNode(rand.nextLong(), chunkX, chunkZ, primer, xx, yy, zz, rand.nextFloat() * 0.5F + 0.5F, xzAngle + (float) Math.PI / 2F, yAngle / 3F, par15, par16, 1D);
                return;
            }

            if (flag || rand.nextInt(4) != 0) {
                double diffX = xx - centerX;
                double diffZ = zz - centerZ;
                double d10 = par16 - par15;
                double radius = innerSize + 2F + 16F;

                if (diffX * diffX + diffZ * diffZ - d10 * d10 > radius * radius)
                    return;

                if (xx >= centerX - 16D - xzRange * 2D && zz >= centerZ - 16D - xzRange * 2D && xx <= centerX + 16D + xzRange * 2D && zz <= centerZ + 16D + xzRange * 2D) {
                    int minX = MathHelper.floor(xx - xzRange) - chunkX * 16 - 1;
                    int maxX = MathHelper.floor(xx + xzRange) - chunkX * 16 + 1;
                    int minY = MathHelper.floor(yy - yRange) - 1;
                    int maxY = MathHelper.floor(yy + yRange) + 1;
                    int minZ = MathHelper.floor(zz - xzRange) - chunkZ * 16 - 1;
                    int maxZ = MathHelper.floor(zz + xzRange) - chunkZ * 16 + 1;

                    if (minX < 0)
                        minX = 0;
                    if (maxX > 16)
                        maxX = 16;
                    if (minY < 6)
                        minY = 6;
                    if (maxY > 124)
                        maxY = 124;
                    if (minZ < 0)
                        minZ = 0;
                    if (maxZ > 16)
                        maxZ = 16;

                    boolean preventGeneration = false;

                    for (int px = minX; !preventGeneration && px < maxX; ++px)
                        for (int pz = minZ; !preventGeneration && pz < maxZ; ++pz)
                            for (int py = maxY + 1; !preventGeneration && py >= minY - 1; --py)
                                if (py >= 0 && py < 128)
                                    if (py != minY - 1 && px != minX && px != maxX - 1 && pz != minZ && pz != maxZ - 1)
                                        py = minY;

                    if (!preventGeneration) {
                        for (int px = minX; px < maxX; ++px) {
                            double xDiff = (px + chunkX * 16 + 0.5D - xx) / xzRange;

                            for (int pz = minZ; pz < maxZ; ++pz) {
                                double zDiff = (pz + chunkZ * 16 + 0.5D - zz) / xzRange;

                                if (xDiff * xDiff + zDiff * zDiff < 1D)
                                    for (int py = maxY - 1; py >= minY; --py) {
                                        double yDiff = (py + 0.5D - yy) / yRange;

                                        if (yDiff > -0.7D && xDiff * xDiff + yDiff * yDiff + zDiff * zDiff < 1D) {
                                            IBlockState state = primer.getBlockState(px, py, pz);
                                            if (state.getBlock() == BlockRegistry.frozenStone || state.getBlock() == BlockRegistry.frozenDirt || state.getBlock() == BlockRegistry.frozenGrass)
                                                primer.setBlockState(px, py, pz, BLOCK_AIR);
                                        }
                                    }
                            }
                        }

                        if (flag)
                            break;
                    }
                }
            }
        }
    }

    @Override
    protected void recursiveGenerate(World worldIn, int chunkX, int chunkZ, int localX, int localZ, ChunkPrimer primer) {
        int caveAmount = rand.nextInt(rand.nextInt(25) + 1);
        if (rand.nextInt(10) != 0)
            caveAmount = 0;

        for (int iter = 0; iter < caveAmount; ++iter) {
            double xx = chunkX * 16 + rand.nextInt(16);
            double yy = 68 + rand.nextGaussian() * 48D;
            double zz = chunkZ * 16 + rand.nextInt(16);
            int smallCaves = rand.nextBoolean() && rand.nextBoolean() ? 2 : 1;

            if (rand.nextInt(8) == 0) {
                generateLargeCaveNode(rand.nextLong(), localX, localZ, primer, xx, yy, zz);
                smallCaves += rand.nextInt(3);
            }

            for (int cave = 0; cave < smallCaves; ++cave) {
                float xzAngle = rand.nextFloat() * (float) Math.PI * 2F;
                float yAngle = (rand.nextFloat() - 0.5F) * 2F / 8F;
                float innerSize = rand.nextFloat() * 2.5F + rand.nextFloat();

                if (rand.nextInt(10) == 0)
                    innerSize *= rand.nextFloat() * rand.nextFloat() + 1F;

                generateCaveNode(rand.nextLong(), localX, localZ, primer, xx, yy, zz, innerSize, xzAngle, yAngle, 0, 0, 1D);
            }
        }
    }
}