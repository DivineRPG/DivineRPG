package divinerpg.objects.entities.entity;

import com.google.common.base.Optional;
import divinerpg.objects.entities.ai.AIDivineFireballAttack;
import divinerpg.objects.entities.ai.AIDivineLookAround;
import divinerpg.objects.entities.ai.AIDivineRandomFly;
import divinerpg.objects.entities.ai.GhastLikeMoveHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFindEntityNearestPlayer;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

public abstract class EntityDivineGhast extends EntityFlying implements IMob {
    private static DataParameter<Optional<UUID>> TargetData = EntityDataManager.createKey(EntityDivineGhast.class, DataSerializers.OPTIONAL_UNIQUE_ID);

    protected EntityDivineGhast(World world) {
        super(world);

        this.moveHelper = new GhastLikeMoveHelper(this);
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();

        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64);
    }

    @Override
    protected void entityInit() {
        super.entityInit();

        getDataManager().register(TargetData, Optional.absent());
    }

    @Nullable
    @Override
    public EntityLivingBase getAttackTarget() {
        EntityLivingBase target = super.getAttackTarget();
        EntityDataManager manager = getDataManager();

        // is manager wisn't changed, return super method result
        if (!manager.isDirty()) {
            return target;
        }

        Optional<UUID> optional = manager.get(TargetData);

        // empty target
        if (target == null && !optional.isPresent()) {
            return target;
        }

        // same target ID return
        if (target != null && Objects.equals(target.getUniqueID(), optional.get())) {
            return target;
        }

        // optimizing search on servers
        if (world.getMinecraftServer() != null) {
            Entity possibleTarget = world.getMinecraftServer().getEntityFromUuid(optional.get());
            if (possibleTarget instanceof EntityLivingBase) {
                target = ((EntityLivingBase) possibleTarget);
            }
        } else {
            target = world.getLoadedEntityList().stream().filter(x -> Objects.equals(x.getUniqueID(), optional.get()) && x instanceof EntityLivingBase)
                    .map(x -> ((EntityLivingBase) x))
                    .findFirst().orElse(null);
        }

        // set here new target
        setAttackTarget(target);
        // returning it
        return target;
    }

    @Override
    public void setAttackTarget(@Nullable EntityLivingBase e) {
        super.setAttackTarget(e);

        Optional<UUID> value = e == null || e.getUniqueID() == null
                ? Optional.absent()
                : Optional.of(e.getUniqueID());

        getDataManager().set(TargetData, value);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();

        this.tasks.addTask(5, new AIDivineRandomFly(this));
        this.tasks.addTask(7, new AIDivineLookAround(this));

        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));

        AIDivineFireballAttack attack = createShootAI();
        if (attack != null) {
            this.tasks.addTask(7, attack);
        }

    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }

    /**
     * AI to perform attack players.
     * Null for not attacking mob
     *
     * @return
     */
    @Nullable
    protected abstract AIDivineFireballAttack createShootAI();

    /**
     * This ranged mob will hit player because we are not that simple!!!
     *
     * @param par1EntityPlayer
     */
    @Override
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
        this.attackEntityAsMob(par1EntityPlayer);
    }
}