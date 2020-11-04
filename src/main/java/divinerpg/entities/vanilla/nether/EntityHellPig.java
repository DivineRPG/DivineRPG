package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityHellPig extends EntityDivineTameable {
    private static final DataParameter<Float> HEALTH = EntityDataManager.createKey(EntityHellPig.class,
            DataSerializers.FLOAT);
    private static final DataParameter<Boolean> ANGRY = EntityDataManager.createKey(EntityHellPig.class,
            DataSerializers.BOOLEAN);

    protected EntityHellPig(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
    }

    public <T extends Entity> EntityHellPig(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }

    @Override
    public boolean isImmuneToFire() {
        return true;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.8F;
    }
    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(HEALTH, this.getHealth());
        dataManager.register(ANGRY, Boolean.FALSE);
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        this.dataManager.set(HEALTH, this.getHealth());
    }

    @Override
    public void setAttackTarget(LivingEntity attackTarget) {
        super.setAttackTarget(attackTarget);
        if (attackTarget == null)
            this.setAngry(false);
        else if (!this.isTamed())
            this.setAngry(true);
    }
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
        }
            if (item == Items.BLAZE_POWDER && !isAngry()) {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((LivingEntity)null);
                    this.world.setEntityState(this, (byte)7);
                    this.heal(item.getFood().getHealing());
                } else {
                    this.world.setEntityState(this, (byte)6);
                    this.heal(item.getFood().getHealing());
                }
            } else {
                setTamedBy(player);
                this.playTameEffect(true);
            }
        }
        return super.func_230254_b_(player, hand);
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        increaseHealthIfTimable();
    }


    @Override
    public void writeAdditional(CompoundNBT tag) {
        super.writeAdditional(tag);
        tag.putBoolean("Angry", this.isAngry());
    }

    @Override
    public void readAdditional(CompoundNBT tag) {
        super.readAdditional(tag);
        setAngry(tag.getBoolean("Angry"));
    }

    public boolean isAngry() {
        return this.dataManager.get(ANGRY);
    }

    public void setAngry(boolean angry) {
        this.dataManager.set(ANGRY, angry);
        MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.hellPigTamedHealth);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_HELL_PIG;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.hellPigHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, 5).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.hellPigSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.hellPigRange);
    }
}