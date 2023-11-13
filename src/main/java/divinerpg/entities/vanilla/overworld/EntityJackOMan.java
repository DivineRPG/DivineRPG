package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EntityJackOMan extends EntityDivineMerchant {
    public EntityJackOMan(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.25F;
    }

    @Override
    public String[] getChatMessages() {
        return new String[] {
                "message.jackoman.boo",
                "message.jackoman.lost",
                "message.jackoman.hurah",
                "message.jackoman.seen"
        };
    }

    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 15), new ItemStack(Items.SPIDER_EYE, 5), new ItemStack(ItemRegistry.skeleman_helmet.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 20), new ItemStack(Items.SPIDER_EYE, 10), new ItemStack(ItemRegistry.skeleman_chestplate.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 20), new ItemStack(Items.SPIDER_EYE, 10), new ItemStack(ItemRegistry.skeleman_leggings.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 15), new ItemStack(Items.SPIDER_EYE, 5), new ItemStack(ItemRegistry.skeleman_boots.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 10), new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(ItemRegistry.jack_o_man_helmet.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 15), new ItemStack(Items.ENDER_PEARL, 2), new ItemStack(ItemRegistry.jack_o_man_chestplate.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 15), new ItemStack(Items.ENDER_PEARL, 2), new ItemStack(ItemRegistry.jack_o_man_leggings.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.PUMPKIN, 10), new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(ItemRegistry.jack_o_man_boots.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 1), new ItemStack(ItemRegistry.wither_reaper_helmet.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 1), new ItemStack(ItemRegistry.wither_reaper_chestplate.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 1), new ItemStack(ItemRegistry.wither_reaper_leggings.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.SKELETON_SKULL, 1), new ItemStack(ItemRegistry.wither_reaper_boots.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.BONE, 25), new ItemStack(Items.ENDER_PEARL, 4), new ItemStack(ItemRegistry.scythe.get()), random.nextInt(7), 5)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.JACKOMAN.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.JACKOMAN.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.JACKOMAN.get();
    }

    public static boolean rules(EntityType<? extends Mob> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        List<EntityJackOMan> entityList = level.getEntitiesOfClass(EntityJackOMan.class, new AABB(pos).inflate(32));
        return entityList.isEmpty();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEAD;
    }
}
