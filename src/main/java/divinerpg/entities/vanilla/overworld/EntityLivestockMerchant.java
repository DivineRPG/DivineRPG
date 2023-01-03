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

public class EntityLivestockMerchant extends EntityDivineMerchant {
    public EntityLivestockMerchant(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public String[] getChatMessages() {
        return new String[] {
                "message.livestock.hi",
                "message.livestock.sell",
                "message.livestock.snapper",
                "message.livestock.travel"
        };
    }
    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        DivineTrades[] tradetrades = new DivineTrades[] {
                new EntityDivineMerchant.DivineTrades(new ItemStack(BlockRegistry.divineLog.get(), 16), new ItemStack(ItemRegistry.shadow_coins.get(), 4), new ItemStack(ItemRegistry.ehu_egg.get(), 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(BlockRegistry.divineLog.get(), 64), new ItemStack(ItemRegistry.shadow_coins.get(), 7), new ItemStack(ItemRegistry.husk_egg.get(), 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.STONE, 64), new ItemStack(ItemRegistry.shadow_coins.get(), 3), new ItemStack(ItemRegistry.stone_golem_egg.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Blocks.NETHER_BRICKS, 32), new ItemStack(ItemRegistry.shadow_coins.get(), 5), new ItemStack(ItemRegistry.smelter_egg.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.jungle_stone.get(), 2), new ItemStack(ItemRegistry.shadow_coins.get(), 4), new ItemStack(ItemRegistry.snapper_egg.get(), 3), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadow_coins.get(), 8), new ItemStack(ItemRegistry.white_grizzle_egg.get(), 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(Items.LEATHER, 10), new ItemStack(ItemRegistry.shadow_coins.get(), 8), new ItemStack(ItemRegistry.brown_grizzle_egg.get(), 2), random.nextInt(7), 5)
                };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LIVESTOCK_MERCHANT_HURT.get();
    }

    public static boolean rules(EntityType<? extends Mob> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        BlockPos blockpos = pos.below();
        List<EntityLivestockMerchant> entityList = level.getEntitiesOfClass(EntityLivestockMerchant.class, new AABB(pos).inflate(32));
        return spawnType == MobSpawnType.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && entityList.isEmpty();
    }
}