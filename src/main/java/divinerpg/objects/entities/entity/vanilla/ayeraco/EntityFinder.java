package divinerpg.objects.entities.entity.vanilla.ayeraco;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.UUID;

public class EntityFinder {

    private UUID uuid;
    private Entity entity;
    private World world;

    public static EntityFinder GetEmpty(World world){
        return new EntityFinder(new UUID(0,0), world);
    }

    /**
     * Init from Unique ID of entity
     * @param uuid - ID of entity
     * @param world - current world
     */
    private EntityFinder(UUID uuid, World world){
        this.uuid = uuid;
        this.world = world;
    }

    /**
     * Init from entity
     * @param entity
     */
    public EntityFinder(Entity entity){
        this(entity.getUniqueID(), entity.world);
        this.entity = entity;
    }

    public EntityFinder(NBTTagCompound compound, String nbtKey, World world) {
        this(compound.getUniqueId(nbtKey), world);
    }


    public <T extends Entity> T getEntity(){
        if (entity == null){
            if (uuid != null) {
                entity = find(uuid, this.world);
            }
        }

        return (T) entity;
    }

    boolean sameEntity(Entity e){
        return e.getUniqueID().equals(uuid);
    }

    public void writeToNBT(NBTTagCompound compound, String nbtKey){
        Entity entity = getEntity();
        if (entity != null && !entity.isDead){
            compound.setUniqueId(nbtKey, entity.getUniqueID());
        }
    }


    /**
     * Searches enriry from current world
     * @param uuid - Unique ID of entity
     * @param world - current world
     * @param <T> - entity type
     * @return
     */
    private <T extends Entity> T find(UUID uuid, World world){
        Optional<Entity> first = world.loadedEntityList.stream()
                .filter(x -> uuid.equals(x.getUniqueID())).findFirst();

        return (T) first.orElse(null);
    }
}
