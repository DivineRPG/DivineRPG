package divinerpg.objects.entities.entity.twilight;

import divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import divinerpg.registry.ModItems;
import divinerpg.registry.ModSounds;
import divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
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

public class Bunny extends EntityDivineRPGTameable {
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/bunny");
    private static final DataParameter<Boolean> TAMED_AND_ANGRY = EntityDataManager.<Boolean>createKey(Bunny.class,
            DataSerializers.BOOLEAN);

    public Bunny(World worldIn) {
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
        if (!this.isTamed())
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
        else
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
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
        return target.attackEntityFrom(DamageSource.causeMobDamage(this), 1);
    }

    public boolean isTamedAndAngry() {
        return ((Boolean) this.dataManager.get(TAMED_AND_ANGRY)).booleanValue();
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
            AngryBunny e = new AngryBunny(this.world);
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
        } else if (held != null && held.getItem() == ModItems.edenSparkles) {
            if (!player.capabilities.isCreativeMode) {
                held.shrink(1);
            }
            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    setTamedBy(player);
                    this.setAttackTarget((EntityLiving) null);
                    this.aiSit.setSitting(true);
                    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
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
        return ModSounds.BUNNY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BUNNY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BUNNY_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }
}