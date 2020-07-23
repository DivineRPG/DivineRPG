package divinerpg.objects.entities.entity.boss.ayeraco;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.UUID;

public class EntityFinder<T extends Entity> implements INBTSerializable<NBTTagCompound> {
    private static String IdKey = "EntityId";
    private final Class<T> clazz;
    private final WorldServer world;
    private UUID id;

    public EntityFinder(Class<T> clazz, WorldServer world, UUID id) {
        this.clazz = clazz;
        this.world = world;
        this.id = id;
    }

    /**
     * Only server side constructor
     *
     * @param clazz  - class of entity
     * @param entity - entity instance
     */
    public EntityFinder(Class<T> clazz, T entity) {
        this(clazz, ((WorldServer) entity.world), entity.getUniqueID());
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();

        if (id != null)
            compound.setUniqueId(IdKey, id);


        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        if (nbt.hasKey(IdKey))
            id = nbt.getUniqueId(IdKey);
    }

    public boolean sameEntity(Entity e) {
        if (id == null || e == null)
            return false;

        return id.equals(e.getUniqueID());
    }

    /**
     * Attempts to find entity from world
     *
     * @return
     */
    public T get() {
        if (world != null && id != null) {
            Entity entity = world.getEntityFromUuid(id);
            if (clazz.isInstance(entity)) {
                return (T) entity;
            }
        }

        return null;
    }
}
