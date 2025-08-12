package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.*;
import net.neoforged.neoforge.common.Tags;

import java.util.Optional;
import javax.annotation.Nullable;

public abstract class EntityDivineMerchant extends AbstractVillager {
    String profession;
    public EntityDivineMerchant(EntityType<? extends EntityDivineMerchant> type, Level level, String profession) {
        super(type, level);
        ((GroundPathNavigation) getNavigation()).setCanOpenDoors(true);
        this.profession = profession;
    }
    @Override protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
        goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zombie.class, 8, .5, .5));
        goalSelector.addGoal(1, new AvoidEntityGoal<>(this, AbstractIllager.class, 15, .5, .5));
        goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Vex.class, 8, .5, .5));
        goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Ravager.class, 12, .5, .5));
        goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zoglin.class, 10, .5, .5));
        goalSelector.addGoal(1, new PanicGoal(this, .5));
        goalSelector.addGoal(1, new LookAtTradingPlayerGoal(this));
        goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, .35));
        goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, .35));
        goalSelector.addGoal(9, new InteractGoal(this, Player.class, 3, 1));
        goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8));
        super.registerGoals();
    }
    @Override protected void rewardTradeXp(MerchantOffer offer) {
        int i = 3 + random.nextInt(4);
        if(offer.shouldRewardExp()) level().addFreshEntity(new ExperienceOrb(level(), getX(), getY() + .5, getZ(), i));
    }
    @Override public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(!(player.getItemInHand(hand).getItem() instanceof SpawnEggItem) && isAlive() && !isSleeping() && !player.isSecondaryUseActive()) {
            if(!level().isClientSide) {
                boolean hasOffers = !getOffers().isEmpty(); //Check if there are offers
                if(hand == InteractionHand.MAIN_HAND) {
                    player.awardStat(Stats.TALKED_TO_VILLAGER); //Award stat for talking to the villager
                    if(hasOffers && canTrade(player)) { //Check if trading can start
                        setTradingPlayer(player); //Set the trading player
                        openTradingScreen(player, Component.translatable("entity.divinerpg." + profession), 0); //Open the trading screen
                        player.displayClientMessage(Component.translatable(getChatMessages()[random.nextInt(getChatMessages().length)]), false);
                    }
                }
            } return InteractionResult.sidedSuccess(level().isClientSide); //Return success based on the client side
        } else return super.mobInteract(player, hand); //Call the superclass method for other interactions
    }
    @Override public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {return null;}
    @Override public boolean canRestock() {return true;}
    @Override public boolean showProgressBar() {return false;}
    @Override public boolean removeWhenFarAway(double distance) {return false;}
    @Override protected void stopTrading() {
        super.stopTrading();
        resetSpecialPrices();
    }
    private void resetSpecialPrices() {
        if(level() instanceof ServerLevel) for(MerchantOffer merchantoffer : getOffers()) merchantoffer.resetSpecialPriceDiff();
    }
    private boolean canTrade(Player player) {return player.isAlive() && !player.isSleeping();}
    @Override public void setTradingPlayer(@Nullable Player player) {
        if(getTradingPlayer() != player) {
            if(player != null && canTrade(player)) super.setTradingPlayer(player);
        }
    }
    public abstract String[] getChatMessages();
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.MERCHANT.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.MERCHANT_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.MERCHANT_HURT.get();}
    @Override protected SoundEvent getTradeUpdatedSound(boolean isYesSound) {return SoundRegistry.MERCHANT.get();}
    @Override public SoundEvent getNotifyTradeSound() {return SoundRegistry.MERCHANT.get();}
    @Override public void playCelebrateSound() {}
    public static class DivineTrades implements VillagerTrades.ItemListing {
        public Component name;
        public final ItemStack input1, input2;
        public final ItemStack output;
        protected int xp, stock;
        public DivineTrades(ItemStack input1, ItemStack input2, ItemStack output, int stock, int xp) {
            this.xp = xp;
            this.stock = stock + 1;
            this.output = output;
            this.input1 = input1;
            this.input2 = input2;
        }
        public DivineTrades(ItemStack input1, ItemStack output, int stock, int xp) {
            this(input1, null, output, stock, xp); //Pass null for input2 if not provided
        }
        @Override public MerchantOffer getOffer(Entity tradeEnt, RandomSource rand) {
            if(input2 != null) return new MerchantOffer(new ItemCost(input1.getItem(), input1.getCount()), Optional.of(new ItemCost(input2.getItem(), input2.getCount())), output, stock, xp, 0F);
            else return new MerchantOffer(new ItemCost(input1.getItem(), input1.getCount()), output, stock, xp, 0F);
        }
    }
    public static class DivineMapTrades extends DivineTrades {
        public final String displayName;
        private final TagKey<Structure> destination;
        public final Holder<MapDecorationType> destinationType;
        public DivineMapTrades(ItemStack input1, ItemStack input2, String displayName, TagKey<Structure> destination, Holder<MapDecorationType> destinationType, int xp) {
            super(input1, input2, null, 1, xp);
            this.displayName = displayName;
            this.destination = destination;
            this.destinationType = destinationType;
        }
        public DivineMapTrades(ItemStack input1, String displayName, TagKey<Structure> destination, Holder<MapDecorationType> destinationType, int xp) {
            this(input1, null, displayName, destination, destinationType, xp);
        }
        @Nullable
        @Override public MerchantOffer getOffer(Entity entity, RandomSource rand) {
            if(entity.level() instanceof ServerLevel serverlevel) {
                BlockPos blockpos = serverlevel.findNearestMapStructure(destination, entity.blockPosition(), 100, true);
                if(blockpos != null) {
                    ItemStack itemstack = MapItem.create(serverlevel, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
                    MapItem.renderBiomePreviewMap(serverlevel, itemstack);
                    MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", destinationType);
                    itemstack.set(DataComponents.ITEM_NAME, Component.translatable(displayName));
                    return new MerchantOffer(new ItemCost(input1.getItem(), input1.getCount()), Optional.of(new ItemCost(input2.getItem(), input2.getCount())), itemstack, 1, xp, 0);
                }
            } return null;
        }
    }
    @Override public boolean checkSpawnRules(LevelAccessor level, MobSpawnType type) {
        return !(level.getBiome(blockPosition()).is(Tags.Biomes.IS_MUSHROOM) || level.getBiome(blockPosition()).is(Biomes.DEEP_DARK));
    }
}