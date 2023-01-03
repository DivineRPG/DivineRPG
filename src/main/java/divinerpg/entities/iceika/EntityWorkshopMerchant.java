package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.*;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EntityWorkshopMerchant extends EntityDivineMerchant {
    public EntityWorkshopMerchant(EntityType<? extends EntityDivineMerchant> type, Level worldIn) {
        super(type, worldIn);
    }
    public String[] getChatMessages() {
        return new String[] {
                "message.merchant.burr",
                "message.merchant.ho",
                "message.merchant.in",
                "message.merchant.out"
        };
    }
    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();

        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_helmet.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_chestplate.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_leggings.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 6), new ItemStack(ItemRegistry.seng_fur_boots.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.egg_nog.get(), 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.chocolate_log.get(), 5), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.peppermints.get(), 15), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(ItemRegistry.fruit_cake.get(), 3), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.snowflake.get(), 20), new ItemStack(ItemRegistry.icicle_bane.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.greenFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.redFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.blueFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.yellowFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.purpleFairyLights.get(), 16), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 9), new ItemStack(BlockRegistry.presentBox.get(), 1), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.blueCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.greenCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.pinkCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.redCandyCane.get(), 4), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.ice_stone.get(), 3), new ItemStack(BlockRegistry.yellowCandyCane.get(), 4), random.nextInt(7), 5)
        };
        this.addOffersFromItemListings(merchantoffers, tradetrades, 5);
    }

    public static boolean rules(EntityType<? extends Mob> type, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        BlockPos blockpos = pos.below();
        List<EntityWorkshopMerchant> entityList = level.getEntitiesOfClass(EntityWorkshopMerchant.class, new AABB(pos).inflate(32));
        return spawnType == MobSpawnType.SPAWNER || level.getBlockState(blockpos).isValidSpawn(level, blockpos, type) && entityList.isEmpty();
    }
}