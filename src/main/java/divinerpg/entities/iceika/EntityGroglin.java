package divinerpg.entities.iceika;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.*;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.*;
import net.minecraft.world.level.storage.loot.parameters.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class EntityGroglin extends EntityDivineMonster implements RangedAttackMob {
    protected static final EntityDataAccessor<Integer> ITEM = SynchedEntityData.defineId(EntityGroglin.class, EntityDataSerializers.INT);

    public EntityGroglin(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ITEM, 0);
    }
    public int heldItem() {
        return this.entityData.get(ITEM);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.18F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, EntityGruzzorlug.class, true));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true){
            @Override
            public boolean canUse() {
                if (this.target instanceof Player player) {
                    int gruzzorlugFavor = getFavor(player, "gruzzorlug_favor");
                    int groglinFavor = getFavor(player, "groglin_favor");
                    return gruzzorlugFavor <= groglinFavor;
                }
                return super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                if (this.target instanceof Player player) {
                    int gruzzorlugFavor = getFavor(player, "gruzzorlug_favor");
                    int groglinFavor = getFavor(player, "groglin_favor");
                    return gruzzorlugFavor <= groglinFavor;
                }
                return super.canContinueToUse();
            }
        });
    }
    int tickCounter;
    @Override
    public void tick() {
        super.tick();
        tickCounter++;
        if(tickCounter < 300){
            entityData.set(ITEM, 0);
        }
        if(tickCounter == 300){
            entityData.set(ITEM, 1);
        }
        if(tickCounter == 600){
            entityData.set(ITEM, 2);
        }
        if(tickCounter == 900){
            tickCounter = 0;
        }
        if(entityData.get(ITEM) == 2) {
            goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float) getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        }

    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("tickCounter", tickCounter);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        tickCounter = tag.getInt("tickCounter");
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (isTradeItem(itemStack)) {
            Item tradedItem = getTradedItem(player);
            if (tradedItem != null) {
                player.getInventory().add(tradedItem.getDefaultInstance());
                itemStack.shrink(1);

                adjustFavor(player, "gruzzorlug_favor", -1); // Decrease Gruzzorlug favor
                adjustFavor(player, "groglin_favor", 1);     // Increase Groglin favor

                return InteractionResult.SUCCESS;
            }
        }

        return super.mobInteract(player, hand);
    }

    private void adjustFavor(Player player, String favorTag, int amount) {
        int favor = getFavor(player, favorTag);
        favor += amount;
        setFavor(player, favorTag, favor);
    }

    private int getFavor(Player player, String favorTag) {
        CompoundTag playerData = getPlayerData(player);
        if (playerData != null && playerData.contains(favorTag, CompoundTag.TAG_INT)) {
            return playerData.getInt(favorTag);
        }
        return 0;
    }

    private void setFavor(Player player, String favorTag, int favor) {
        CompoundTag playerData = getPlayerData(player);
        playerData.putInt(favorTag, favor);
        setPlayerData(player, playerData);
    }

    private CompoundTag getPlayerData(Player player) {
        CompoundTag persistentData = player.getPersistentData();
        CompoundTag entityData;
        if (persistentData.contains(Player.PERSISTED_NBT_TAG)) {
            entityData = persistentData.getCompound(Player.PERSISTED_NBT_TAG);
        } else {
            entityData = new CompoundTag();
            persistentData.put(Player.PERSISTED_NBT_TAG, entityData);
        }
        return entityData;
    }

    private void setPlayerData(Player player, CompoundTag playerData) {
        player.getPersistentData().put(Player.PERSISTED_NBT_TAG, playerData);
    }

    private boolean isTradeItem(ItemStack itemStack) {
        TagKey<Item> tradeTag = TagKey.create(Registries.ITEM, new ResourceLocation(DivineRPG.MODID, "groglin_trades"));
        return itemStack.is(tradeTag);
    }

    private Item getTradedItem(Player player) {
        if (player.level.isClientSide) {
            return null;
        }

        ResourceLocation lootTableLocation = new ResourceLocation(DivineRPG.MODID, "trades/groglin");
        LootTable tradeLootTable = player.getServer().getLootTables().get(lootTableLocation);

        if (tradeLootTable != null) {
            LootContext.Builder lootContextBuilder = new LootContext.Builder((ServerLevel) player.level)
                    .withParameter(LootContextParams.ORIGIN, player.position())
                    .withParameter(LootContextParams.THIS_ENTITY, player)
                    .withRandom(player.getRandom());

            List<ItemStack> tradedItems = tradeLootTable.getRandomItems(lootContextBuilder.create(LootContextParamSets.GIFT));
            if (!tradedItems.isEmpty()) {
                ItemStack tradedItemStack = tradedItems.get(0);
                return tradedItemStack.getItem();
            }
        }
        return null;
    }



    @Override
    public void performRangedAttack(LivingEntity target, float distance) {
        if (isAlive() && getTarget() != null && !level.isClientSide && entityData.get(ITEM) == 2) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level, ArrowType.FROST_ARCHER_ARROW, this, target, 1.6F, 1.2F);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 1.2F);
            this.level.addFreshEntity(projectile);
        }
    }

    @Override
    public void die(DamageSource source) {
            if (entityData.get(ITEM) == 1 && level.random.nextBoolean()) {
                level.addFreshEntity(new ItemEntity(level, getX(), getY(), getZ(), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icine_sword")))));
            }
            if (entityData.get(ITEM) == 2 && level.random.nextBoolean()) {
                level.addFreshEntity(new ItemEntity(level, getX(), getY(), getZ(), new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle_bow")))));
            }
        super.die(source);
    }
}
