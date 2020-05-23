package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.ItemRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityBunny extends EntityDivineRPGTameable {

    private static final DataParameter<Boolean> TAMED_AND_ANGRY = EntityDataManager.createKey(EntityBunny.class,
            DataSerializers.BOOLEAN);

    public EntityBunny(World worldIn) {
        super(worldIn);
        this.setSize(0.5F, 0.7F);
        this.experienceValue = 40;
    }

    @Override
    public float getEyeHeight() {
        return 0.5F;
    }

    @Override
    public void entityInit() {
        super.entityInit();
        dataManager.register(TAMED_AND_ANGRY, false);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        increaseHealthIfTimable();
    }

    @Override
    protected boolean canDespawn() {
        return !this.isTamed();
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.world.isRemote && !this.isTamed()) {
            this.transform();
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        if (this.isTamed()) {
            this.dataManager.set(TAMED_AND_ANGRY, true);
        }

        return super.attackEntityAsMob(target);
    }

    public boolean isTamedAndAngry() {
        return this.dataManager.get(TAMED_AND_ANGRY);
    }

    @Override
    public EntityLivingBase getAttackTarget() {
        EntityLivingBase entity = super.getAttackTarget();
        if (entity != null && ((this.isTamed() && this.getDistanceSq(entity) < 144) || !this.isTamed()))
            return entity;
        return null;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            if (this.isTamed() && this.getAttackTarget() == null) {
                this.dataManager.set(TAMED_AND_ANGRY, false);
            }
        }
    }

    private void transform() {
        if (!this.world.isRemote) {
            EntityAngryBunny e = new EntityAngryBunny(this.world);
            e.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.world.spawnEntity(e);
            this.setDead();
        }
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack held = player.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (held != null && held.getItem() instanceof ItemFood) {
                ItemFood food = (ItemFood) held.getItem();
                if (food.isWolfsFavoriteMeat() && this.getHealth() < 20) {
                    if (!player.capabilities.isCreativeMode) {
                        held.shrink(1);
                    }
                    this.heal((float) food.getHealAmount(held));
                    return true;
                }
            } else if (isOwner(player)) {
                if (!this.world.isRemote) {
                    this.aiSit.setSitting(!this.isSitting());
                    this.isJumping = false;
                }
                return true;
            }
        } else if (held != null && held.getItem() == ItemRegistry.edenSparkles) {
            if (!player.capabilities.isCreativeMode) {
                held.shrink(1);
            }
            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    setTamedBy(player);
                    this.setAttackTarget(null);
                    this.aiSit.setSitting(true);

                    this.setHealth(20);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BUNNY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.BUNNY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.BUNNY_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_BUNNY;
    }
}