package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.tags.TagKey;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.*;
import net.neoforged.neoforge.common.Tags;

import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nullable;

public abstract class EntityDivineMerchant extends Villager {
    VillagerProfession profession;
	public EntityDivineMerchant(EntityType<? extends EntityDivineMerchant> type, Level level, VillagerProfession profession) {
		super(type, level);
        ((GroundPathNavigation) getNavigation()).setCanOpenDoors(true);
        this.profession = profession;
	}

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData) {
        SpawnGroupData data = super.finalizeSpawn(world, difficulty, reason, spawnData);
        setVillagerData(getVillagerData().setProfession(profession));
        return data;
    }
	public abstract String[] getChatMessages();
	@Override protected void rewardTradeXp(MerchantOffer offer) {
	      int i = 3 + this.random.nextInt(4);
	      this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0));
	      if(offer.shouldRewardExp()) this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY() + 0.5D, this.getZ(), i));
	}
	@Override
	public boolean isMaxGroupSizeReached(int i) {
		return i > 2;
	}
	@Override
	public int getMaxSpawnClusterSize() {
		return 2;
	}
	@Override protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Monster.class, 8f, 0.8d, 1.2d));
        this.goalSelector.addGoal(1, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtTradingPlayerGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }
	@Override public SoundEvent getNotifyTradeSound() {return SoundEvents.VILLAGER_TRADE;}
    @Override protected SoundEvent getAmbientSound() {
    	return switch(this.random.nextInt(3)) {
    	case 0 -> SoundRegistry.MERCHANT_3.get();
    	case 2 -> SoundRegistry.MERCHANT_2.get();
    	default -> SoundRegistry.MERCHANT_1.get();
    	};
    }
    @Override public int getAmbientSoundInterval() {return 160;}
    @Override protected SoundEvent getHurtSound(DamageSource p_35498_) {return SoundRegistry.MERCHANT_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.MERCHANT_HURT.get();}
    @Override public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!level().isClientSide && !getOffers().isEmpty()) {
            updateSpecialPrices(player);
            setTradingPlayer(player);
            openTradingScreen(player, Objects.requireNonNull(getDisplayName()), getVillagerData().getLevel());
        }
        return InteractionResult.SUCCESS;
    }
    @Override public boolean canRestock() {return true;}
    @Override public boolean showProgressBar() {return false;}
    @Override public boolean removeWhenFarAway(double distance) {return false;}

    protected void updateSpecialPrices(Player player) {int reputation = getPlayerReputation(player); if (reputation != 0) {for(MerchantOffer offer : getOffers()) {offer.addToSpecialPriceDiff(-Mth.floor((float)reputation * offer.getPriceMultiplier()));}}}
    @Override public void tick() {
        super.tick();
        if (this.getUnhappyCounter() > 0) {
           this.setUnhappyCounter(this.getUnhappyCounter() - 1);
        }
    }
    @Override public boolean hurt(DamageSource source, float amount) {
    	if(source.getDirectEntity() instanceof Player || source.getEntity() instanceof Player) level().broadcastEntityEvent(this, (byte) 13);
    	setUnhappy();
    	return super.hurt(source, amount);
    }
    @Override public void handleEntityEvent(byte type) {
        if (type == 12) this.addParticlesAroundSelf(ParticleTypes.HEART);
        else if (type == 13) this.addParticlesAroundSelf(ParticleTypes.ANGRY_VILLAGER);
        else if (type == 14) this.addParticlesAroundSelf(ParticleTypes.HAPPY_VILLAGER);
        else if (type == 42) this.addParticlesAroundSelf(ParticleTypes.SPLASH);
        else super.handleEntityEvent(type);
    }
    @Override public void setTradingPlayer(@Nullable Player player) {
        boolean flag = this.getTradingPlayer() != null && player == null;
        super.setTradingPlayer(player);
        if (flag) this.stopTrading();
    }
    private void setUnhappy() {
        this.setUnhappyCounter(40);
    }
    @Override protected void stopTrading() {
        super.stopTrading();
        this.resetSpecialPrices();
    }
    private void resetSpecialPrices() {for(MerchantOffer merchantoffer : this.getOffers()) merchantoffer.resetSpecialPriceDiff();}
    
    public static class DivineTrades implements VillagerTrades.ItemListing {
		protected ItemStack input1, input2;
		private ItemStack output;
        protected int xp, stock;
        public DivineTrades(ItemStack input1, ItemStack input2, ItemStack output, int stock, int xp) {
            this.xp = xp;
            this.stock = stock + 1;
            this.output = output;
            this.input1 = input1;
            this.input2 = input2;
        }
        public DivineTrades(ItemStack input1, ItemStack output, int stock, int xp) {this(input1, ItemStack.EMPTY, output, stock, xp);}
        @Override public MerchantOffer getOffer(Entity tradeEnt, RandomSource rand) {return new MerchantOffer(new ItemCost(input1.getItem(), input1.getCount()), Optional.of(new ItemCost(input1.getItem(), input1.getCount())), output, stock, xp, 0F);}
    }
    public static class DivineMapTrades extends DivineTrades {
    	private final String displayName;
    	private final TagKey<Structure> destination;
    	private final Holder<MapDecorationType> destinationType;
        public DivineMapTrades(ItemStack input1, ItemStack input2, String displayName, TagKey<Structure> destination, Holder<MapDecorationType> destinationType, int xp) {
            super(input1, input2, null, 1, xp);
            this.displayName = displayName;
            this.destination = destination;
            this.destinationType = destinationType;
        }
        public DivineMapTrades(ItemStack input1, String displayName, TagKey<Structure> destination, Holder<MapDecorationType> destinationType, int xp) {
            this(input1, ItemStack.EMPTY, displayName, destination, destinationType, xp);
        }
        @Nullable
        @Override
        public MerchantOffer getOffer(Entity trader, RandomSource rand) {
            MerchantOffer offer;
            ItemStack itemstack = MapItem.create(trader.level(), trader.blockPosition().getX(), trader.blockPosition().getZ(), (byte)2, true, true);

            if (input2 != null) {
                offer = new MerchantOffer(new ItemCost(input1.getItem(), input1.getCount()), Optional.of(new ItemCost(input2.getItem(), input2.getCount())), itemstack, stock, xp, 0f);
            }
            else if (input1 != null) {
                offer = new MerchantOffer(new ItemCost(input1.getItem(), input1.getCount()), itemstack, stock, xp, 0f);
            }
            else {
                return null;
            }

            return offer;
        }
    }
    @Override
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return !(level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM) || level.getBiome(blockPosition()).is(Biomes.DEEP_DARK));
    }
}
