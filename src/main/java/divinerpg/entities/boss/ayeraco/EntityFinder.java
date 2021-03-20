package divinerpg.entities.boss.ayeraco;

import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.util.*;

import java.util.*;

public class EntityFinder<T extends Entity> implements INBTSerializable<CompoundNBT> {
    private static String IdKey = "EntityId";
    private final Class<T> clazz;
    private final ServerWorld world;
    private UUID id;

    public EntityFinder(Class<T> clazz, ServerWorld world, UUID id) {
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
        this(clazz, ((ServerWorld) entity.level), entity.getUUID());
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();

        if (id != null)
            compound.putUUID(IdKey, id);


        return compound;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (nbt.contains(IdKey))
            id = nbt.getUUID(IdKey);
    }

    public boolean sameEntity(Entity e) {
        if (id == null || e == null)
            return false;

        return id.equals(e.getUUID());
    }

    /**
     * Attempts to find entity from world
     *
     * @return
     */
    public T get() {
        if (world != null && id != null) {
            Entity entity = world.getEntity(id);
            if (clazz.isInstance(entity)) {
                return (T) entity;
            }
        }

        return null;
    }
}
