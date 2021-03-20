package divinerpg.entities.boss.ayeraco;

import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.potion.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AyeracoGroup implements INBTSerializable<CompoundNBT> {
    private EntityFinder<EntityAyeracoRed> red;
    private EntityFinder<EntityAyeracoGreen> green;
    private EntityFinder<EntityAyeracoBlue> blue;
    private EntityFinder<EntityAyeracoPurple> purple;
    private EntityFinder<EntityAyeracoYellow> yellow;

    public AyeracoGroup(ServerWorld world) {
        this(world, null, null, null, null, null);
    }

    public AyeracoGroup(ServerWorld world, UUID red, UUID green, UUID blue, UUID yellow, UUID purple) {
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
        this(((ServerWorld) ayeracos.get(0).level),
                ayeracos.get(0).getUUID(),
                ayeracos.get(1).getUUID(),
                ayeracos.get(2).getUUID(),
                ayeracos.get(3).getUUID(),
                ayeracos.get(4).getUUID());
    }

    /**
     * Is purple ayeraco provides teleport ability
     *
     * @param ayeraco - current ayeraco
     * @return
     */
    public boolean canTeleport(LivingEntity ayeraco) {
        EntityAyeraco superAyeraco = this.purple.get();
        return superAyeraco == ayeraco || isHealthy(superAyeraco);
    }

    /**
     * Is green ayeraco provides projectile potection
     *
     * @param ayeraco - current ayeraco
     * @return
     */
    public boolean projectileProtected(LivingEntity ayeraco) {
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
            EffectInstance effect = new EffectInstance(Effects.MOVEMENT_SPEED, 1, 1);
            livingAyeracos.forEach(x -> x.addEffect(effect));
        }

        // Read is healing others
        if (red.sameEntity(ayeraco)) {
            livingAyeracos.forEach(x -> x.heal(0.3F));
        }

        // The blue one adding strength
        if (blue.sameEntity(ayeraco) && isAngry(ayeraco)) {
            EffectInstance effect = new EffectInstance(Effects.DAMAGE_BOOST, 1, 2);
            livingAyeracos.forEach(x -> x.addEffect(effect));
        }
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        compound.put("red", red.serializeNBT());
        compound.put("green", green.serializeNBT());
        compound.put("blue", blue.serializeNBT());
        compound.put("purple", purple.serializeNBT());
        compound.put("yellow", yellow.serializeNBT());
        return compound;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        red.deserializeNBT(nbt.getCompound("red"));
        green.deserializeNBT(nbt.getCompound("green"));
        blue.deserializeNBT(nbt.getCompound("blue"));
        purple.deserializeNBT(nbt.getCompound("purple"));
        yellow.deserializeNBT(nbt.getCompound("yellow"));
    }


    /**
     * Health of entity is more 50%
     *
     * @param e - mob
     * @return
     */
    private boolean isHealthy(LivingEntity e) {
        return checkNotDead(e) && e.getHealth() / e.getMaxHealth() > 0.5F;
    }

    /**
     * Health of entity equals or less 50%, it is anrgy and can use special ability
     *
     * @param e - mob
     * @return
     */
    private boolean isAngry(LivingEntity e) {
        return checkNotDead(e) && e.getHealth() / e.getMaxHealth() <= 0.5F;
    }

    private boolean checkNotDead(Entity e) {
        return e != null && e.isAlive();
    }
}
