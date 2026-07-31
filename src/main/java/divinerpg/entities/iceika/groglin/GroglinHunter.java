package divinerpg.entities.iceika.groglin;

import divinerpg.entities.goals.FollowLeaderGoal;
import divinerpg.entities.projectile.arrows.IcicleArrow;
import divinerpg.registries.ItemRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.RecipeRegistry.Trades.GROGLIN_HUNTER;
import static net.minecraft.sounds.SoundEvents.SKELETON_SHOOT;
import static net.minecraft.world.InteractionHand.MAIN_HAND;
import static net.minecraft.world.entity.EquipmentSlot.MAINHAND;

public class GroglinHunter extends Groglin implements RangedAttackMob {
    public GroglinHunter(EntityType<? extends GroglinHunter> type, Level worldIn) {super(type, worldIn);}
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, new ItemStack(ItemRegistry.icicle_bow.get()));}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new RangedBowAttackGoal<>(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 20, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
        goalSelector.addGoal(4, new FollowLeaderGoal(this, GroglinSharlatan.class, 1, 4, (float)getAttributeValue(Attributes.FOLLOW_RANGE)));
    }
    @Override public void performRangedAttack(LivingEntity target, float f) {
        if(isAlive() && getTarget() != null && !level().isClientSide()) {
            IcicleArrow abstractArrow = new IcicleArrow(level(), this, new ItemStack(ItemRegistry.icicle_arrow.get()), getItemBySlot(MAINHAND));
            double d0 = target.getX() - getX(), d1 = target.getY(.3333333333333333) - abstractArrow.getY(), d2 = target.getZ() - getZ(), d3 = Math.sqrt(d0 * d0 + d2 * d2);
            abstractArrow.shoot(d0, d1 + d3 * .2, d2, 1.6F, 14 - (level().getDifficulty().getId() << 2));
            playSound(SKELETON_SHOOT, 1, 1 / (getRandom().nextFloat() * .4F + .8F));
            level().addFreshEntity(abstractArrow);
        }
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), GROGLIN_HUNTER.get(level(), getRandom()), 3);}
}