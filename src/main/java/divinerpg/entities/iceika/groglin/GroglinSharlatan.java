package divinerpg.entities.iceika.groglin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static divinerpg.registries.AttachmentRegistry.IMPORTANT;
import static divinerpg.registries.ItemRegistry.serenade_of_ice;
import static divinerpg.registries.RecipeRegistry.Trades.GROGLIN_SHARLATAN;
import static net.minecraft.world.InteractionHand.MAIN_HAND;
import static net.minecraft.world.effect.MobEffects.SLOWNESS;

public class GroglinSharlatan extends Groglin implements RangedAttackMob {
    public GroglinSharlatan(EntityType<? extends GroglinSharlatan> type, Level worldIn) {
        super(type, worldIn);
        if(!worldIn.isClientSide()) setData(IMPORTANT.attachment, true);
    }
    @Override protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {setItemInHand(MAIN_HAND, new ItemStack(serenade_of_ice.get()));}
    @Override protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 10, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override public void performRangedAttack(LivingEntity e, float f) {
        LivingEntity target = getTarget();
        if(isAlive() && target != null) {
            target.addEffect(new MobEffectInstance(SLOWNESS, 25, 1, false, true, true));
            target.setTicksFrozen(target.getTicksFrozen() + 10);
            if(getRandom().nextBoolean()) target.hurt(damageSources().indirectMagic(this, this), 1);
        }
    }
    @Override protected void updateTrades(ServerLevel level) {addOffersFromTradeSet(getOffers(), GROGLIN_SHARLATAN.get(level(), getRandom()), 3);}
}