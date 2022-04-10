package divinerpg.entities.base;

import com.mojang.serialization.*;
import divinerpg.entities.ai.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.brain.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.*;
import net.minecraft.entity.merchant.villager.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;

public abstract class EntityDivineMerchant extends VillagerEntity implements IMerchant {

    protected EntityDivineMerchant(EntityType<? extends EntityDivineMerchant> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new SwimGoal(this));
        goalSelector.addGoal(1, new AvoidEntityGoal<MonsterEntity>(this, MonsterEntity.class, 8f, 0.8d, 1d));
        goalSelector.addGoal(1, new TraderAI(this));
        goalSelector.addGoal(2, new OpenDoorGoal(this, true));
        goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 3f, 1f));
        goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.6d));
        goalSelector.addGoal(5, new LookRandomlyGoal(this));
    }

    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
        ILivingEntityData data = super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);

        setVillagerData(getVillagerData().setProfession(TraderProfession.TRADER.get()));

        return data;
    }
    @Override
    protected Brain<?> makeBrain(Dynamic<?> dynamic) {
        return brainProvider().makeBrain(dynamic);
    }

    @Override
    public void refreshBrain(ServerWorld world) {}

    @Override
    protected void ageBoundaryReached() {}

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.27D);
    }


    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return !worldIn.canSeeSky(pos);
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader reader) {
        return 0.0F;
    }

    public abstract String[] getChatMessages();

    @Override
    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.VILLAGER_TRADE;
    }

    @Override
    protected ITextComponent getTypeName() {
        return getType().getDescription();
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if (!getOffers().isEmpty()) {
            if (!level.isClientSide) {
                updateSpecialPrices(player);
                setTradingPlayer(player);
                openTradingScreen(player, getDisplayName(), 1);
                player.sendMessage(new TranslationTextComponent(Arrays.stream(getChatMessages()).iterator().next()), player.getUUID());
            }
        }
        return ActionResultType.sidedSuccess(level.isClientSide);
    }

    protected void updateSpecialPrices(PlayerEntity player) {
        int reputation = getPlayerReputation(player);

        if (reputation != 0) {
            for(MerchantOffer offer : getOffers()) {
                offer.addToSpecialPriceDiff(-MathHelper.floor((float)reputation * offer.getPriceMultiplier()));
            }
        }
    }

    public static class DivineTrades implements VillagerTrades.ITrade {

        private ItemStack input2;
        private ItemStack input1;
        private ItemStack output;

        private int xp;
        private int stock;

        public DivineTrades(ItemStack input1, ItemStack input2, ItemStack output, int stock, int xp) {
            this.xp = xp;
            this.stock = stock + 1;
            this.output = output;
            this.input1 = input1;
            this.input2 = input2;
        }

        public DivineTrades(ItemStack input1, ItemStack output, int stock, int xp) {
            this(input1, ItemStack.EMPTY, output, stock, xp);
        }

        @Override
        public MerchantOffer getOffer(Entity tradeEnt, Random rand) {
            return new MerchantOffer(input1, input2, output, stock, xp, 0F);
        }
    }
}
