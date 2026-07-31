package divinerpg.entities.base;

import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.InteractGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.LookAtTradingPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TradeWithPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

import javax.annotation.Nullable;
import java.util.*;

public abstract class EntityDivineMerchant extends AbstractVillager {
    protected String profession;

    public EntityDivineMerchant(EntityType<? extends EntityDivineMerchant> type, Level level, String profession) {
        super(type, level);
        if (getNavigation() instanceof GroundPathNavigation nav) {
            nav.setCanOpenDoors(true);
        }
        this.profession = profession;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zombie.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, AbstractIllager.class, 15.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Vex.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Ravager.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zoglin.class, 10.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new LookAtTradingPlayerGoal(this));
        this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.35D));
        this.goalSelector.addGoal(9, new InteractGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.goalSelector.addGoal(11, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    protected void rewardTradeXp(MerchantOffer offer) {
        int xp = 3 + this.random.nextInt(4);
        if (offer.shouldRewardExp()) {
            this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY() + 0.5D, this.getZ(), xp));
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!(player.getItemInHand(hand).getItem() instanceof SpawnEggItem) && this.isAlive() && !this.isSleeping() && !player.isSecondaryUseActive()) {
            if (!this.level().isClientSide()) {
                boolean hasOffers = !this.getOffers().isEmpty();
                if (hand == InteractionHand.MAIN_HAND) {
                    player.awardStat(Stats.TALKED_TO_VILLAGER);
                    if (hasOffers && this.canTrade(player)) {
                        this.setTradingPlayer(player);
                        this.openTradingScreen(player, Component.translatable("entity.divinerpg." + this.profession), 0);
                        String[] messages = this.getChatMessages();
                        if (messages != null && messages.length > 0 && this.random.nextInt(5) == 1) {
                            player.sendSystemMessage(Component.literal(this.getName().getString() + ": ").append(Component.translatable(messages[this.random.nextInt(messages.length)])));
                        }
                    }
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public void stopTrading() {
        super.stopTrading();
        this.setTradingPlayer(null);
        this.resetSpecialPrices();
    }

    private void resetSpecialPrices() {
        if (this.level() instanceof ServerLevel) {
            for (MerchantOffer offer : this.getOffers()) {
                offer.resetSpecialPriceDiff();
            }
        }
    }

    private boolean canTrade(Player player) {
        return player.isAlive() && !player.isSleeping();
    }

    @Override
    public void setTradingPlayer(@Nullable Player player) {
        if (this.getTradingPlayer() != player) {
            if (player == null || this.canTrade(player)) {
                super.setTradingPlayer(player);
            }
        }
    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override public boolean canRestock() { return true; }
    @Override public boolean showProgressBar() { return false; }
    @Override public boolean removeWhenFarAway(double distance) { return false; }

    public abstract String[] getChatMessages();

    @Override protected SoundEvent getAmbientSound() { return SoundRegistry.MERCHANT.get(); }
    @Override protected SoundEvent getHurtSound(DamageSource source) { return SoundRegistry.MERCHANT_HURT.get(); }
    @Override protected SoundEvent getDeathSound() { return SoundRegistry.MERCHANT_HURT.get(); }
    @Override protected SoundEvent getTradeUpdatedSound(boolean isYesSound) { return SoundRegistry.MERCHANT.get(); }
    @Override public SoundEvent getNotifyTradeSound() { return SoundRegistry.MERCHANT.get(); }
    @Override public void playCelebrateSound() {}

    public void addOffersFromTradeSet(MerchantOffers offers, DivineTrades[] trades, int maxOffers) {
        if (trades == null || trades.length == 0) {
            return;
        }
        List<DivineTrades> tradeList = new ArrayList<>(java.util.Arrays.asList(trades));
        Collections.shuffle(tradeList, new Random(this.random.nextLong()));

        int added = 0;
        for (DivineTrades trade : tradeList) {
            if (added >= maxOffers) {
                break;
            }

            MerchantOffer offer = trade.getOffer(this, this.random);
            if (offer != null) {
                offers.add(offer);
                added++;
            }
        }
    }
    public static class DivineTrades {
        public final ItemStack input1;
        public final ItemStack input2;
        public final ItemStack output;
        protected final int xp;
        protected final int stock;

        public DivineTrades(ItemStack input1, ItemStack input2, ItemStack output, int stock, int xp) {
            this.input1 = input1;
            this.input2 = input2;
            this.output = output;
            this.stock = stock + 1;
            this.xp = xp;
        }

        public DivineTrades(ItemStack input1, ItemStack output, int stock, int xp) {
            this(input1, ItemStack.EMPTY, output, stock, xp);
        }

        @Nullable
        public MerchantOffer getOffer(Entity entity, RandomSource rand) {
            if (this.input1.isEmpty() || this.output.isEmpty()) {
                return null;
            }

            ItemCost cost1 = new ItemCost(this.input1.getItem(), this.input1.getCount());
            Optional<ItemCost> cost2 = (!this.input2.isEmpty())
                    ? Optional.of(new ItemCost(this.input2.getItem(), this.input2.getCount()))
                    : Optional.empty();

            return new MerchantOffer(cost1, cost2, this.output, this.stock, this.xp, 0.0F);
        }
    }

    public static class DivineMapTrades extends DivineTrades {
        public final String displayName;
        private final TagKey<Structure> destination;
        public final Holder<MapDecorationType> destinationType;

        public DivineMapTrades(ItemStack input1, ItemStack input2, String displayName, TagKey<Structure> destination, Holder<MapDecorationType> destinationType, int xp) {
            super(input1, input2, ItemStack.EMPTY, 1, xp);
            this.displayName = displayName;
            this.destination = destination;
            this.destinationType = destinationType;
        }

        public DivineMapTrades(ItemStack input1, String displayName, TagKey<Structure> destination, Holder<MapDecorationType> destinationType, int xp) {
            this(input1, ItemStack.EMPTY, displayName, destination, destinationType, xp);
        }

        @Override
        @Nullable
        public MerchantOffer getOffer(Entity entity, RandomSource rand) {
            if (entity.level() instanceof ServerLevel serverLevel) {
                BlockPos blockpos = serverLevel.findNearestMapStructure(this.destination, entity.blockPosition(), 100, true);
                if (blockpos != null) {
                    ItemStack mapStack = MapItem.create(serverLevel, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);
                    MapItem.renderBiomePreviewMap(serverLevel, mapStack);
                    MapItemSavedData.addTargetDecoration(mapStack, blockpos, "+", this.destinationType);
                    mapStack.set(DataComponents.ITEM_NAME, Component.translatable(this.displayName));

                    ItemCost cost1 = new ItemCost(this.input1.getItem(), this.input1.getCount());
                    Optional<ItemCost> cost2 = (!this.input2.isEmpty())
                            ? Optional.of(new ItemCost(this.input2.getItem(), this.input2.getCount()))
                            : Optional.empty();

                    return new MerchantOffer(cost1, cost2, mapStack, 1, this.xp, 0.0F);
                }
            }
            return null;
        }
    }
}