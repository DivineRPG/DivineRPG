package divinerpg.tiles.spawner;

import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.*;
import net.minecraft.world.server.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class TileEntitySingleMobSpawner extends TileEntity implements ITickableTileEntity {
    private String entityName;
    private int spawnTimer;
    private boolean spawnParticles = false;
    private Random rand = new Random();
    private ResourceLocation type;

    public TileEntitySingleMobSpawner(ResourceLocation type) {
        super(TileRegistry.ARCANA_SPAWNER);
        spawnParticles = false;
        this.type = type;
        this.entityName = type.getPath();
    }

    public TileEntitySingleMobSpawner() {
        super(TileRegistry.ARCANA_SPAWNER);
    }

    @Override
    public void load(BlockState state, CompoundNBT tag) {
        super.load(state, tag);
        this.entityName = tag.getString("EntityName");
    }

    @Override
    public CompoundNBT save(CompoundNBT tag) {
        super.save(tag);
        tag.putString("EntityName", entityName);
        return tag;
    }

    @Override
    public void tick() {
        if(type != null){
        if (this.level.isClientSide) {
            if (this.spawnParticles) {
                for (int n = 0; n < 3; n++) {
                    double x = this.worldPosition.getX() + 0.5 + (this.rand.nextDouble() - this.rand.nextDouble());
                    double y = this.worldPosition.getY() + 0.5 + (this.rand.nextDouble() - this.rand.nextDouble());
                    double z = this.worldPosition.getZ() + 0.5 + (this.rand.nextDouble() - this.rand.nextDouble());
                    level.addParticle(ParticleRegistry.BLACK_FLAME.get(), x, y, z, 0, 0, 0);
                }
            }
        } else if (this.level.getNearestPlayer(this.worldPosition.getX() + 0.5D, this.worldPosition.getY() + 0.5D, this.worldPosition.getZ() + 0.5D,
                48D, false) != null) {
            if (this.spawnTimer > 0)
                this.spawnTimer--;
            if (this.spawnTimer == 0) {
                int c = this.level
                        .getEntitiesOfClass(ForgeRegistries.ENTITIES.getValue(type).create(level).getClass(),
                                new AxisAlignedBB(this.worldPosition.getX(), this.worldPosition.getY() + 8, this.worldPosition.getZ(),
                                        this.worldPosition.getX() + 1, this.worldPosition.getY() - 8, this.worldPosition.getZ() + 1).expandTowards(8, 6, 8))
                        .size();
                if (c < 1) {
                    for (int i = 0; i < 1; i++) {
                            Entity e = ForgeRegistries.ENTITIES.getValue(type).create(level);
                            if (e != null && e instanceof LivingEntity) {
                                LivingEntity entity = (LivingEntity) e;
                                int x = this.worldPosition.getX() + this.rand.nextInt(9) - 4;
                                int y = this.worldPosition.getY() + this.rand.nextInt(3) - 1;
                                int z = this.worldPosition.getZ() + this.rand.nextInt(9) - 4;
                                AxisAlignedBB boundingBox = new AxisAlignedBB(x + e.getBoundingBox().minX,
                                        y + e.getBoundingBox().minY, z + e.getBoundingBox().minZ,
                                        x + e.getBoundingBox().maxX, y + e.getBoundingBox().maxY,
                                        z + e.getBoundingBox().maxZ);
                                if (this.level.noCollision(boundingBox)
                                        && !this.level.getBlockCollisions(e, boundingBox).findAny().isPresent()
                                        && !this.level.containsAnyLiquid(boundingBox)) {
                                    if(ForgeRegistries.ENTITIES.getValue(type) == EntityRegistry.THE_HUNGER){
                                        entity.moveTo(x, y+1, z, rand.nextInt(360), 0);
                                        worldPosition = new BlockPos(x, y+1, z);
                                    }else {
                                        worldPosition = new BlockPos(x, y-3, z);
                                    }
                                    if (ForgeRegistries.ENTITIES.getValue(type).spawn((ServerWorld)level, null, null, worldPosition, SpawnReason.SPAWN_EGG, false, false) == null) {
                                    }
                                }
                            }
                        }
                    }
                }
                this.spawnTimer = 180;
            }
        }
    }
}
