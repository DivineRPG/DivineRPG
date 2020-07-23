package divinerpg.objects.entities.entity.boss.ayeraco;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AyeracoGroup implements INBTSerializable<NBTTagCompound> {
    private EntityFinder<EntityAyeracoRed> red;
    private EntityFinder<EntityAyeracoGreen> green;
    private EntityFinder<EntityAyeracoBlue> blue;
    private EntityFinder<EntityAyeracoPurple> purple;
    private EntityFinder<EntityAyeracoYellow> yellow;

    public AyeracoGroup(WorldServer world) {
        this(world, null, null, null, null, null);
    }

    public AyeracoGroup(WorldServer world, UUID red, UUID green, UUID blue, UUID yellow, UUID purple) {
        this.red = new EntityFinder<>(EntityAyeracoRed.class, world, red);
        this.green = new EntityFinder<>(EntityAyeracoGreen.class, world, green);
        this.blue = new EntityFinder<>(EntityAyeracoBlue.class, world, blue);
        this.purple = new EntityFinder<>(EntityAyeracoPurple.class, world, purple);
        this.yellow = new EntityFinder<>(EntityAyeracoYellow.class, world, yellow);
    }

    /**
     * Should call only on server side
     *
     * @param ayeracos
     */
    public AyeracoGroup(List<EntityAyeraco> ayeracos) {
        this(((WorldServer) ayeracos.get(0).world),
                ayeracos.get(0).getUniqueID(),
                ayeracos.get(1).getUniqueID(),
                ayeracos.get(2).getUniqueID(),
                ayeracos.get(3).getUniqueID(),
                ayeracos.get(4).getUniqueID());
    }

    /**
     * Is purple ayeraco provides teleport ability
     *
     * @param ayeraco - current ayeraco
     * @return
     */
    public boolean canTeleport(EntityLivingBase ayeraco) {
        EntityAyeraco superAyeraco = this.purple.get();
        return superAyeraco == ayeraco || isHealthy(superAyeraco);
    }

    /**
     * Is green ayeraco provides projectile potection
     *
     * @param ayeraco - current ayeraco
     * @return
     */
    public boolean projectileProtected(EntityLivingBase ayeraco) {
        EntityAyeraco superAyeraco = this.green.get();
        return superAyeraco == ayeraco || isHealthy(superAyeraco);
    }

    /**
     * Trying to process special abilities for each of the group
     *
     * @param ayeraco
     */
    public void tick(EntityAyeraco ayeraco) {

        // works only with angry entities
        if (!isAngry(ayeraco))
            return;

        List<? extends EntityAyeraco> livingAyeracos = Stream.of(red, green, blue, purple, yellow)
                .map(EntityFinder::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // entity is not ayeraco
        if (!livingAyeracos.contains(ayeraco))
            return;

        // Yellow adding speed
        if (yellow.sameEntity(ayeraco)) {
            PotionEffect effect = new PotionEffect(MobEffects.SPEED, 1, 1);
            livingAyeracos.forEach(x -> x.addPotionEffect(effect));
        }

        // Read is healing others
        if (red.sameEntity(ayeraco)) {
            livingAyeracos.forEach(x -> x.heal(0.3F));
        }

        // The blue one adding strength
        if (blue.sameEntity(ayeraco) && isAngry(ayeraco)) {
            PotionEffect effect = new PotionEffect(MobEffects.STRENGTH, 1, 2);
            livingAyeracos.forEach(x -> x.addPotionEffect(effect));
        }
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setTag("red", red.serializeNBT());
        compound.setTag("green", green.serializeNBT());
        compound.setTag("blue", blue.serializeNBT());
        compound.setTag("purple", purple.serializeNBT());
        compound.setTag("yellow", yellow.serializeNBT());
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        red.deserializeNBT(nbt.getCompoundTag("red"));
        green.deserializeNBT(nbt.getCompoundTag("green"));
        blue.deserializeNBT(nbt.getCompoundTag("blue"));
        purple.deserializeNBT(nbt.getCompoundTag("purple"));
        yellow.deserializeNBT(nbt.getCompoundTag("yellow"));
    }


    /**
     * Health of entity is more 50%
     *
     * @param e - mob
     * @return
     */
    private boolean isHealthy(EntityLivingBase e) {
        return checkNotDead(e) && e.getHealth() / e.getMaxHealth() > 0.5F;
    }

    /**
     * Health of entity equals or less 50%, it is anrgy and can use special ability
     *
     * @param e - mob
     * @return
     */
    private boolean isAngry(EntityLivingBase e) {
        return checkNotDead(e) && e.getHealth() / e.getMaxHealth() <= 0.5F;
    }

    private boolean checkNotDead(Entity e) {
        return e != null && !e.isDead;
    }
}
