package divinerpg.entities.vanilla;

import divinerpg.entities.IAttackTimer;
import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntitySmelter extends EntityDivineTameable implements IAttackTimer {
    private static final DataParameter<Integer> ATTACK_TIMER = EntityDataManager.createKey(EntitySmelter.class,
            DataSerializers.VARINT);

    public <T extends Entity> EntitySmelter(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
    protected EntitySmelter(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
    }


    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.2F;
    }

    @Override
    protected void registerData() {
        super.registerData();
        dataManager.register(ATTACK_TIMER, Integer.valueOf(0));
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (getAttackTimer() > 0) {
            this.dataManager.set(ATTACK_TIMER, Integer.valueOf(getAttackTimer() - 1));
        }
    }

    @Override
    public int getAttackTimer() {
        return this.dataManager.get(ATTACK_TIMER).intValue();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.smelterHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.smelterDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.smelterSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.smelterFollowRange);
    }

    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (item == Items.FLINT && this.getHealth() < this.getMaxHealth()) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((LivingEntity)null);
                    this.world.setEntityState(this, (byte)7);
                    this.heal(4.0F);
                } else {
                    this.world.setEntityState(this, (byte)6);
                    this.heal(4.0F);
                }
            } else {
                setTamedBy(player);
                this.playTameEffect(true);
            }
        }
        return super.func_230254_b_(player, hand);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean attack = super.attackEntityAsMob(entity);
        if (attack) {
            entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F), 0.1D,
                    MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F));
            entity.setFire(5);
            this.dataManager.set(ATTACK_TIMER, 10);
        }
        return attack;
    }

}