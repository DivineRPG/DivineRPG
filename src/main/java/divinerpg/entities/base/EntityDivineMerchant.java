package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.npc.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;

public abstract class EntityDivineMerchant extends AbstractVillager {
	public EntityDivineMerchant(EntityType<? extends EntityDivineMerchant> type, Level level) {
		super(type, level);
        ((GroundPathNavigation) getNavigation()).setCanOpenDoors(true);
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
	@Override public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {return null;}
	@Override protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtTradingPlayerGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }
	@Override public SoundEvent getNotifyTradeSound() {return SoundEvents.VILLAGER_TRADE;}
	@Override protected float getStandingEyeHeight(Pose p_35297_, EntityDimensions p_35298_) {return 1.62F;}
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
        if (!getOffers().isEmpty()) {
        	if(needsToRestock()) this.restock();
            updateSpecialPrices(player);
            setTradingPlayer(player);
            openTradingScreen(player, getDisplayName(), 1);
            String[] messages = getChatMessages();
            if(messages.length > 0) player.displayClientMessage(Component.translatable(messages[player.random.nextInt(getChatMessages().length)]), true);
        } else setUnhappy();
        return InteractionResult.SUCCESS;
    }
    @Override public boolean canRestock() {return true;}
    @Override public boolean showProgressBar() {return false;}
    @Override public boolean removeWhenFarAway(double distance) {return false;}
    public void restock() {
        for(MerchantOffer merchantoffer : this.getOffers()) {
        	merchantoffer.updateDemand();
        	merchantoffer.resetUses();
        }
    }
    private boolean needsToRestock() {
        for(MerchantOffer merchantoffer : this.getOffers()) if (merchantoffer.needsRestock()) return true;
        return false;
    }
    protected void updateSpecialPrices(Player player) {if (player != this.lastHurtByPlayer) for(MerchantOffer offer : getOffers()) offer.addToSpecialPriceDiff(-Mth.floor(offer.getPriceMultiplier()));}
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
        @Override public MerchantOffer getOffer(Entity tradeEnt, RandomSource rand) {return new MerchantOffer(input1, input2, output, stock, xp, 0F);}
    }
    public static class DivineMapTrades extends DivineTrades {
    	private final String displayName;
    	private final TagKey<Structure> destination;
    	private final MapDecoration.Type destinationType;
        public DivineMapTrades(ItemStack input1, ItemStack input2, String displayName, TagKey<Structure> destination, MapDecoration.Type destinationType, int xp) {
            super(input1, input2, null, 1, xp);
            this.displayName = displayName;
            this.destination = destination;
            this.destinationType = destinationType;
        }
        public DivineMapTrades(ItemStack input1, String displayName, TagKey<Structure> destination, MapDecoration.Type destinationType, int xp) {this(input1, ItemStack.EMPTY, displayName, destination, destinationType, xp);}
        @Override
        public MerchantOffer getOffer(Entity entity, RandomSource random) {
        	if(!(entity.level() instanceof ServerLevel)) return null;
        	else {
        		ServerLevel serverlevel = (ServerLevel)entity.level();
                BlockPos blockpos = serverlevel.findNearestMapStructure(destination, entity.blockPosition(), 100, true);
                if(blockpos != null) {
                   ItemStack itemstack = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
                   MapItem.renderBiomePreviewMap(serverlevel, itemstack);
                   MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", this.destinationType);
                   itemstack.setHoverName(Component.translatable(this.displayName));
                   return new MerchantOffer(input1, input2, itemstack, 1, xp, 0F);
                } else return null;
            }
        }
    }
    @Override
    public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return !(level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM) || level.getBiome(blockPosition()).is(Biomes.DEEP_DARK));
    }
}
