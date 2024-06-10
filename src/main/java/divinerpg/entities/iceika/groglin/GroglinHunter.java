package divinerpg.entities.iceika.groglin;

import divinerpg.entities.ai.FollowLeaderGoal;
import divinerpg.entities.base.EntityDivineMerchant;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;

public class GroglinHunter extends Groglin implements RangedAttackMob {
	public GroglinHunter(EntityType<? extends Groglin> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 3);
	}
	@Override protected void registerGoals() {
		super.registerGoals();
        goalSelector.addGoal(0, new RangedBowAttackGoal<>(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 20, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
		goalSelector.addGoal(4, new FollowLeaderGoal(this, GroglinSharlatan.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
	}
	@Override public void performRangedAttack(LivingEntity target, float f) {
		if(isAlive() && getTarget() != null) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level(), ArrowType.PALE_ARCHER_ARROW, this, target, 1.6F, 1.2F);
            double d0 = getTarget().getX() - getX(), d1 = getTarget().getY(.3333333333333333) - projectile.getY(), d2 = getTarget().getZ() - getZ(), d3 = Mth.sqrt((float)(d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .18, d2, 1.6F, 1.2F);
            level().addFreshEntity(projectile);
        }
	}
	@Override
	protected void updateTrades() {
		MerchantOffers merchantoffers = this.getOffers();
        DivineTrades[] tradetrades = new DivineTrades[]{
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 24), new ItemStack(ItemRegistry.seng_fur.get()), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 12), new ItemStack(ItemRegistry.raw_seng_meat.get(), 2), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 6), new ItemStack(ItemRegistry.raw_wolpertinger_meat.get(), 5), random.nextInt(7), 5),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 10), new ItemStack(ItemRegistry.cauldron_flesh.get(), 5), random.nextInt(7), 1),
                new EntityDivineMerchant.DivineTrades(new ItemStack(ItemRegistry.olivine.get(), 1), new ItemStack(ItemRegistry.ice_stone.get(), 3), random.nextInt(7), 1)
        };
        addOffersFromItemListings(merchantoffers, tradetrades, 3);
	}
}