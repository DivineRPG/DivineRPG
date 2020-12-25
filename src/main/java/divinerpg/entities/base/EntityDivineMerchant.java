package divinerpg.entities.base;

import com.google.common.collect.Sets;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.merchant.villager.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.*;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.Set;

public abstract class EntityDivineMerchant extends CreatureEntity implements INPC, IMerchant {


    //TODO - merchants have no GUI yet
    private static final DataParameter<Integer> SHAKE_HEAD_TICKS = EntityDataManager.createKey(EntityDivineMerchant.class, DataSerializers.VARINT);
    @Nullable
    private PlayerEntity customer;
    @Nullable
    protected MerchantOffers offers;
    private final Inventory villagerInventory = new Inventory(8);

    protected EntityDivineMerchant(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.27D);
    }

    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        if (spawnDataIn == null) {
            spawnDataIn = new AgeableEntity.AgeableData(false);
        }

        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public int getShakeHeadTicks() {
        return this.dataManager.get(SHAKE_HEAD_TICKS);
    }

    public void setShakeHeadTicks(int ticks) {
        this.dataManager.set(SHAKE_HEAD_TICKS, ticks);
    }

    public int getXp() {
        return 0;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? 0.81F : 1.62F;
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(SHAKE_HEAD_TICKS, 0);
    }

    public void setCustomer(@Nullable PlayerEntity player) {
        this.customer = player;
    }

    @Nullable
    public PlayerEntity getCustomer() {
        return this.customer;
    }

    public boolean hasCustomer() {
        return this.customer != null;
    }

    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.populateTradeData();
        }

        return this.offers;
    }

    @OnlyIn(Dist.CLIENT)
    public void setClientSideOffers(@Nullable MerchantOffers offers) {
    }

    public void setXP(int xpIn) {
    }

    public void onTrade(MerchantOffer offer) {
        offer.increaseUses();
        this.livingSoundTime = -this.getTalkInterval();
        this.onVillagerTrade(offer);

    }

    protected abstract void onVillagerTrade(MerchantOffer offer);

    public boolean hasXPBar() {
        return true;
    }

    /**
     * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
     * being played depending if the suggested itemstack is not null.
     */
    public void verifySellingItem(ItemStack stack) {
        if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playSound(this.getVillagerYesNoSound(!stack.isEmpty()), this.getSoundVolume(), this.getSoundPitch());
        }

    }

    public SoundEvent getYesSound() {
        return SoundEvents.ENTITY_VILLAGER_YES;
    }

    protected SoundEvent getVillagerYesNoSound(boolean getYesSound) {
        return getYesSound ? SoundEvents.ENTITY_VILLAGER_YES : SoundEvents.ENTITY_VILLAGER_NO;
    }

    public void playCelebrateSound() {
        this.playSound(SoundEvents.ENTITY_VILLAGER_CELEBRATE, this.getSoundVolume(), this.getSoundPitch());
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        MerchantOffers merchantoffers = this.getOffers();
        if (!merchantoffers.isEmpty()) {
            compound.put("Offers", merchantoffers.write());
        }

        compound.put("Inventory", this.villagerInventory.write());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("Offers", 10)) {
            this.offers = new MerchantOffers(compound.getCompound("Offers"));
        }

        this.villagerInventory.read(compound.getList("Inventory", 10));
    }

    @Nullable
    public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        this.resetCustomer();
        return super.changeDimension(server, teleporter);
    }

    protected void resetCustomer() {
        this.setCustomer((PlayerEntity) null);
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        this.resetCustomer();
    }

    @OnlyIn(Dist.CLIENT)
    protected void spawnParticles(IParticleData particleData) {
        for (int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(particleData, this.getPosXRandom(1.0D), this.getPosYRandom() + 1.0D, this.getPosZRandom(1.0D), d0, d1, d2);
        }

    }

    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    public Inventory getVillagerInventory() {
        return this.villagerInventory;
    }

    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
            return true;
        } else {
            int i = inventorySlot - 300;
            if (i >= 0 && i < this.villagerInventory.getSizeInventory()) {
                this.villagerInventory.setInventorySlotContents(i, itemStackIn);
                return true;
            } else {
                return false;
            }
        }
    }

    public World getWorld() {
        return this.world;
    }

    protected abstract void populateTradeData();

    protected void addTrades(MerchantOffers givenMerchantOffers, VillagerTrades.ITrade[] newTrades, int maxNumbers) {
        Set<Integer> set = Sets.newHashSet();
        if (newTrades.length > maxNumbers) {
            while (set.size() < maxNumbers) {
                set.add(this.rand.nextInt(newTrades.length));
            }
        } else {
            for (int i = 0; i < newTrades.length; ++i) {
                set.add(i);
            }
        }

        for (Integer integer : set) {
            VillagerTrades.ITrade villagertrades$itrade = newTrades[integer];
            MerchantOffer merchantoffer = villagertrades$itrade.getOffer(this, this.rand);
            if (merchantoffer != null) {
                givenMerchantOffers.add(merchantoffer);
            }
        }

    }

    @OnlyIn(Dist.CLIENT)
    public Vector3d getLeashPosition(float partialTicks) {
        float f = MathHelper.lerp(partialTicks, this.prevRenderYawOffset, this.renderYawOffset) * ((float) Math.PI / 180F);
        Vector3d vector3d = new Vector3d(0.0D, this.getBoundingBox().getYSize() - 1.0D, 0.2D);
        return this.func_242282_l(partialTicks).add(vector3d.rotateYaw(-f));
    }
    protected abstract int getGuiId ();
    public abstract MerchantOffers getRecipeList ();
}
