package divinerpg.objects.entities.entity;

import com.google.common.base.Optional;
import divinerpg.config.Config;
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
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

public abstract class EntityDivineFlyingMob extends EntityFlying implements IMob {
    private static DataParameter<Optional<UUID>> TargetData = EntityDataManager.createKey(EntityDivineFlyingMob.class, DataSerializers.OPTIONAL_UNIQUE_ID);

    protected EntityDivineFlyingMob(World world) {
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
        Config.initEntityAttributes(this);
    }

    @Override
    protected void entityInit() {
        super.entityInit();

        getDataManager().register(TargetData, Optional.absent());
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

        if (!this.world.isRemote) {
            this.setAttackTarget(this.world.getNearestAttackablePlayer(this, 22.0D, 22.0D));
        if(this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }}}

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