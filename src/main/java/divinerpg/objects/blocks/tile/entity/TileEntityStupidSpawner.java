package divinerpg.objects.blocks.tile.entity;

import divinerpg.DivineRPG;
import divinerpg.enums.ParticleType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.Random;

public class TileEntityStupidSpawner extends TileEntity implements ITickable {
    private String entityName;
    private int spawnTimer;
    private boolean spawnParticles = false;
    private Random rand = new Random();

    public TileEntityStupidSpawner() {
        spawnParticles = false;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.entityName = tag.getString("EntityName");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setString("EntityName", this.entityName);
        return tag;
    }

    @Override
    public void update() {
        if (this.world.isRemote) {
            if (this.spawnParticles) {
                for (int n = 0; n < 3; n++) {
                    double x = this.pos.getX() + 0.5 + (this.rand.nextDouble() - this.rand.nextDouble());
                    double y = this.pos.getY() + 0.5 + (this.rand.nextDouble() - this.rand.nextDouble());
                    double z = this.pos.getZ() + 0.5 + (this.rand.nextDouble() - this.rand.nextDouble());
                    DivineRPG.proxy.spawnParticle(this.world, ParticleType.BLACK_FLAME, x, y, z, 0, 0, 0);
                }
            }
        } else if (this.world.getClosestPlayer(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D,
                16D, false) != null) {
            if (this.spawnTimer > 0)
                this.spawnTimer--;
            if (this.spawnTimer == 0) {
                int c = this.world
                        .getEntitiesWithinAABB(Entity.class,
                                new AxisAlignedBB(this.pos.getX(), this.pos.getY(), this.pos.getZ(),
                                        this.pos.getX() + 1, this.pos.getY() + 1, this.pos.getZ() + 1).expand(8, 6, 8))
                        .size();
                if (c < 8) {
                    ResourceLocation mobLoc = new ResourceLocation(DivineRPG.MODID, this.entityName);
                    for (int i = 0; i < 4; i++) {
                        Entity e = EntityList.createEntityByIDFromName(mobLoc, this.world);
                        if (e != null && e instanceof EntityLiving) {
                            EntityLiving entity = (EntityLiving) e;
                            int x = this.pos.getX() + this.rand.nextInt(9) - 4;
                            int y = this.pos.getY() + this.rand.nextInt(3) - 1;
                            int z = this.pos.getZ() + this.rand.nextInt(9) - 4;
                            AxisAlignedBB boundingBox = new AxisAlignedBB(x + e.getEntityBoundingBox().minX,
                                    y + e.getEntityBoundingBox().minY, z + e.getEntityBoundingBox().minZ,
                                    x + e.getEntityBoundingBox().maxX, y + e.getEntityBoundingBox().maxY,
                                    z + e.getEntityBoundingBox().maxZ);
                            if (this.world.checkNoEntityCollision(boundingBox)
                                    && this.world.getCollisionBoxes(e, boundingBox).isEmpty()
                                    && !this.world.containsAnyLiquid(boundingBox)) {
                                entity.setLocationAndAngles(x, y, z, this.rand.nextInt(360), 0);
                                this.world.spawnEntity(entity);
                            }
                        }
                    }
                }
                this.spawnTimer = 300;
            }
        }
    }

    public void setEntityName(String name) {
        this.entityName = name;
    }

    public void setSpawnParticles(boolean spawnParticles) {
        this.spawnParticles = spawnParticles;
    }
}