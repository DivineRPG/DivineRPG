package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.entities.ai.FollowLeaderGoal;
import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GruzzorlugCannoneer extends Gruzzorlug implements RangedAttackMob {
	public GruzzorlugCannoneer(EntityType<? extends Gruzzorlug> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 7);
	}
	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new AggressiveRangedAttackGoal(20));
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GruzzorlugCommander.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.FROST_CANNON_SHOT);
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .15, d2, 1.6F, .8F);
            level().addFreshEntity(projectile);
            playSound(SoundRegistry.FROST_CANNON.get());
        }
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 10), new ItemStack(BlockRegistry.workshopLamp.get(), 4), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 2), PotionUtils.setPotion(new ItemStack(Items.POTION), PotionRegistry.TEA.get()), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 18), new ItemStack(ItemRegistry.sabear_tooth.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 13), new ItemStack(ItemRegistry.sabear_fur.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 1), new ItemStack(ItemRegistry.ice_stone.get(), 2), random.nextInt(7), 1)
        };
        addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}