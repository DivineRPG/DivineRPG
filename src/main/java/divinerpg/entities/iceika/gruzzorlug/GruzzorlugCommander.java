package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.maps.MapDecoration.Type;

public class GruzzorlugCommander extends Gruzzorlug implements RangedAttackMob {
	public GruzzorlugCommander(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 8);
		important = true;
	}
	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new AggressiveRangedAttackGoal(25));
	}
	@Override public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.FRACTITE_CANNON_SHOT);
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(SoundRegistry.FRACTITE_CANNON.get());
        }
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
		DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 1), new ItemStack(ItemRegistry.ice_shards.get(), 12), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineMapTrades(new ItemStack(ItemRegistry.olivine.get(), 25), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get(), 5), "filled_map.whale_skull", WHALE_SKULL, Type.MONUMENT, 25),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 8), new ItemStack(BlockRegistry.icyBricks.get(), 4), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 10), new ItemStack(BlockRegistry.frostedGlass.get(), 4), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 12), new ItemStack(BlockRegistry.chiseledIcyBricks.get(), 4), random.nextInt(7), 1)
        };
        addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}