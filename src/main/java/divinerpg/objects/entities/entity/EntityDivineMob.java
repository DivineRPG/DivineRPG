package divinerpg.objects.entities.entity;

import divinerpg.config.Config;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public abstract class EntityDivineMob extends EntityMob {

    public EntityDivineMob(World par1World) {
        super(par1World);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27D);

        Config.initEntityAttributes(this);
    }

    @Override
    protected void initEntityAI() {
        if (!needsSpecialAI()) {
            addBasicAI();
        }
    }

    public boolean needsSpecialAI() {
        return false;
    }

    protected void addBasicAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    }

    protected void addAttackingAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1, true));
        this.targetTasks.addTask(1,
                new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, false, null));
    }

    @Override
    public boolean getCanSpawnHere() {
        return (this.world.getDifficulty() != EnumDifficulty.PEACEFUL) && this.isValidLightLevel();
    }
}