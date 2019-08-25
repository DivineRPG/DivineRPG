package divinerpg.objects.entities.entity.vanilla.ayeraco;

import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Tuple;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class AyeracoGroup {
    private EntityFinder red;
    private EntityFinder green;
    private EntityFinder blue;
    private EntityFinder purple;
    private EntityFinder yellow;

    /**
     * Initialization when entity is created from NBT
     * @param compound - NBT
     * @param world - world where entity created
     */
    public AyeracoGroup(NBTTagCompound compound, World world){
        initFromNBT(compound, world);
    }

    /**
     * Initializated ayeracos in that order: red, green, blue, yellow, purple
     * @param ayeracos
     */
    public AyeracoGroup(ArrayList<Ayeraco> ayeracos){
        this(ayeracos.get(0),ayeracos.get(1),ayeracos.get(2),ayeracos.get(3),ayeracos.get(4));
    }

    private AyeracoGroup(Ayeraco red, Ayeraco green, Ayeraco blue, Ayeraco yellow, Ayeraco purple){

        this.red = new EntityFinder(red);
        this.green = new EntityFinder(green);
        this.blue = new EntityFinder(blue);
        this.yellow = new EntityFinder(yellow);
        this.purple = new EntityFinder(purple);
    }

    /**
     * For purple always, for anothers if purple health >= 50%
     * @param ayeraco - current ayeraco
     * @return
     */
    public boolean canTeleport(EntityLivingBase ayeraco){
        return purple.sameEntity(ayeraco) || isHealthy(purple.getEntity());
    }

    /**
     * For green - always, for others if green health > 50%
     * @param ayeraco - current ayeraco
     * @return
     */
    public boolean projectileProtected(EntityLivingBase ayeraco){
        return green.sameEntity(ayeraco) || isHealthy(green.getEntity());
    }

    /**
     * Writing the whole team to NBT tags
     * @param compound - NBT
     */
    public void writeToNBT(NBTTagCompound compound){
        red.writeToNBT(compound, "redUUID");
        green.writeToNBT(compound, "greenUUID");
        blue.writeToNBT(compound, "blueUUID");
        purple.writeToNBT(compound, "purpleUUID");
        yellow.writeToNBT(compound, "yellowUUID");
    }

    private void initFromNBT(NBTTagCompound compound, World world) {
        red = new EntityFinder(compound, "redUUID", world);
        green = new EntityFinder(compound, "greenUUID", world);
        blue = new EntityFinder(compound, "blueUUID", world);
        purple = new EntityFinder(compound, "purpleUUID", world);
        yellow = new EntityFinder(compound, "yellowUUID", world);
    }

    /**
     * Trying to process special abilities for each of the group
     * @param ayeraco
     */
    public void processSpecialAbilities(EntityLivingBase ayeraco){

        List<Ayeraco> ayeracos = getAllLivingAyeracos();

        // Yellow adding speed
        if (yellow.sameEntity(ayeraco)  && isAngry(ayeraco)){
            PotionEffect effect = new PotionEffect(MobEffects.SPEED, 1, 1);
            ayeracos.forEach(x -> x.addPotionEffect(effect));
        }

        // Read is healing others
        if (red.sameEntity(ayeraco) && isAngry(ayeraco) ){
            ayeracos.forEach(x -> x.heal(0.3F));
        }

        // The blue one adding strength
        if (blue.sameEntity(ayeraco) && isAngry(ayeraco)){
            PotionEffect effect = new PotionEffect(MobEffects.STRENGTH, 1, 2);
            ayeracos.forEach(x -> x.addPotionEffect(effect));
        }
    }


    /**
     * Writes only leaving entity in NBT
     * @param compound - NBT of entity
     * @param entity - one og the ayeraco group
     * @param key - ID of each color
     */
    private void writeEntity(NBTTagCompound compound, Entity entity, String key){
        if (checkNotDead(entity))
            compound.setUniqueId(key, entity.getPersistentID());
    }

    /**
     * Should call on not remote worlds!
     * @param compound - NBT
     * @param key - string key name of entity UUID
     * @param world - Not remote world!!!
     * @return
     */
    private <T extends Entity> Tuple<UUID, T> readEntity(NBTTagCompound compound, String key, World world) {

        if (key == null || key.isEmpty())
            return null;

        UUID uuid = compound.getUniqueId(key);
        if (uuid == null){
            return null;
        }

        return new Tuple<>(uuid, find(uuid, world));
    }

    private boolean checkNotDead(Entity e){
        return e != null && !e.isDead;
    }

    /**
     * Health of entity is more 50%
     * @param e - mob
     * @return
     */
    private boolean isHealthy(EntityLivingBase e){
        return checkNotDead(e) && e.getHealth() / e.getMaxHealth() > 0.5F;
    }

    /**
     * Health of entity equals or less 50%, it is anrgy and can use special ability
     * @param e - mob
     * @return
     */
    private boolean isAngry(EntityLivingBase e){
        return checkNotDead(e) && e.getHealth() / e.getMaxHealth() <= 0.5F;
    }

    /**
     * Returns all living ayeracos
     * @return
     */
    private List<Ayeraco> getAllLivingAyeracos(){
        return Lists.newArrayList(red, green, blue, yellow, purple)
                .stream().map(EntityFinder::<Ayeraco>getEntity).filter(this::checkNotDead).collect(Collectors.toList());
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
                .filter(x -> uuid.equals(x.getPersistentID())).findFirst();

        return (T) first.orElse(null);
    }
}
