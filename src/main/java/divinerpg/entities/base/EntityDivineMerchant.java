package divinerpg.entities.base;

import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.merchant.*;
import net.minecraft.entity.merchant.villager.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public abstract class EntityDivineMerchant extends CreatureEntity implements INPC, IMerchant {


    //TODO - merchants have no GUI yet
    private static final DataParameter<Integer> SHAKE_HEAD_TICKS = EntityDataManager.defineId(EntityDivineMerchant.class, DataSerializers.INT);
    @Nullable
    private PlayerEntity customer;
    @Nullable
    protected MerchantOffers offers;
    private final Inventory villagerInventory = new Inventory(8);

    protected EntityDivineMerchant(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.27D);
    }

    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        if (spawnDataIn == null) {
            spawnDataIn = new AgeableEntity.AgeableData(false);
        }

        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        BlockPos blockpos = pos.below();
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(blockpos).isValidSpawn(worldIn, blockpos, typeIn);
    }
    public int getUnhappyCounter() {
        return this.entityData.get(SHAKE_HEAD_TICKS);
    }

    public void setUnhappyCounter(int p_213720_1_) {
        this.entityData.set(SHAKE_HEAD_TICKS, p_213720_1_);
    }

    public int getVillagerXp() {
        return 0;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isBaby() ? 0.81F : 1.62F;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHAKE_HEAD_TICKS, 0);
    }

    public void setCustomer(@Nullable PlayerEntity player) {
        this.customer = player;
    }

    @Nullable
    public PlayerEntity getTradingPlayer() {
        return this.customer;
    }

    public boolean isTrading() {
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
    public void overrideOffers(@Nullable MerchantOffers offers) {
    }

    public void overrideXp(int xpIn) {
    }

    public void notifyTrade(MerchantOffer offer) {
        offer.increaseUses();
        this.ambientSoundTime = -this.getAmbientSoundInterval();
        this.onVillagerTrade(offer);

    }

    protected abstract void onVillagerTrade(MerchantOffer offer);

    public boolean showProgressBar() {
        return true;
    }

    /**
     * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
     * being played depending if the suggested itemstack is not null.
     */
    public void notifyTradeUpdated(ItemStack stack) {
        if (!this.level.isClientSide && this.ambientSoundTime > -this.getAmbientSoundInterval() + 20) {
            this.ambientSoundTime = -this.getAmbientSoundInterval();
            this.playSound(this.getVillagerYesNoSound(!stack.isEmpty()), this.getSoundVolume(), this.getVoicePitch());
        }

    }

    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.VILLAGER_YES;
    }

    protected SoundEvent getVillagerYesNoSound(boolean getYesSound) {
        return getYesSound ? SoundEvents.VILLAGER_YES : SoundEvents.VILLAGER_NO;
    }

    public void playCelebrateSound() {
        this.playSound(SoundEvents.VILLAGER_CELEBRATE, this.getSoundVolume(), this.getVoicePitch());
    }

    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        MerchantOffers merchantoffers = this.getOffers();
        if (!merchantoffers.isEmpty()) {
            compound.put("Offers", merchantoffers.createTag());
        }

        compound.put("Inventory", this.villagerInventory.createTag());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Offers", 10)) {
            this.offers = new MerchantOffers(compound.getCompound("Offers"));
        }

        this.villagerInventory.fromTag(compound.getList("Inventory", 10));
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
    public void die(DamageSource cause) {
        super.die(cause);
        this.resetCustomer();
    }

    @OnlyIn(Dist.CLIENT)
    protected void addParticlesAroundSelf(IParticleData particleData) {
        for (int i = 0; i < 5; ++i) {
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            this.level.addParticle(particleData, this.getRandomX(1.0D), this.getRandomY() + 1.0D, this.getRandomZ(1.0D), d0, d1, d2);
        }

    }

    public boolean canBeLeashed(PlayerEntity player) {
        return false;
    }

    public Inventory getInventory() {
        return this.villagerInventory;
    }

    public boolean setSlot(int inventorySlot, ItemStack itemStackIn) {
        if (super.setSlot(inventorySlot, itemStackIn)) {
            return true;
        } else {
            int i = inventorySlot - 300;
            if (i >= 0 && i < this.villagerInventory.getContainerSize()) {
                this.villagerInventory.setItem(i, itemStackIn);
                return true;
            } else {
                return false;
            }
        }
    }

    public World getWorld() {
        return this.level;
    }

    protected abstract void populateTradeData();

    protected void addOffersFromItemListings(MerchantOffers givenMerchantOffers, VillagerTrades.ITrade[] newTrades, int maxNumbers) {
        Set<Integer> set = Sets.newHashSet();
        if (newTrades.length > maxNumbers) {
            while (set.size() < maxNumbers) {
                set.add(this.random.nextInt(newTrades.length));
            }
        } else {
            for (int i = 0; i < newTrades.length; ++i) {
                set.add(i);
            }
        }

        for (Integer integer : set) {
            VillagerTrades.ITrade villagertrades$itrade = newTrades[integer];
            MerchantOffer merchantoffer = villagertrades$itrade.getOffer(this, this.random);
            if (merchantoffer != null) {
                givenMerchantOffers.add(merchantoffer);
            }
        }

    }

    @OnlyIn(Dist.CLIENT)
    public Vector3d getRopeHoldPosition(float partialTicks) {
        float f = MathHelper.lerp(partialTicks, this.yBodyRotO, this.yBodyRot) * ((float)Math.PI / 180F);
        Vector3d vector3d = new Vector3d(0.0D, this.getBoundingBox().getYsize() - 1.0D, 0.2D);
        return this.getPosition(partialTicks).add(vector3d.yRot(-f));
    }
    protected abstract int getGuiId ();
    public abstract MerchantOffers getRecipeList ();
}
