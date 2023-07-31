package divinerpg.entities.base;

import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityDivineTameable extends TamableAnimal {
	protected final float healthIncrease;
    protected EntityDivineTameable(EntityType<? extends TamableAnimal> type, Level worldIn, float healthIncrease) {
        super(type, worldIn);
        this.healthIncrease = healthIncrease;
        setTame(false);
    }
    public boolean isMeat(ItemStack item) {
    	return item.getFoodProperties(this) != null && item.getFoodProperties(this).isMeat();
    }
    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(1, new FloatGoal(this));
        goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
        goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
        goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
    @Override
    public void setTame(boolean tamed) {
        super.setTame(tamed);
        if(isTame()) {
            AttributeInstance attribute = getAttribute(Attributes.MAX_HEALTH);
            attribute.setBaseValue(attribute.getValue() * healthIncrease);
        }
    }
    public boolean isAngry() {
        return false;
    }
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(Items.CARROT) || item.is(Items.APPLE) || item.is(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moonbulb")));
    }
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if(level().isClientSide()) return isOwnedBy(player) ? InteractionResult.CONSUME : InteractionResult.PASS;
        if(isTame()) {
            if(isFood(itemstack) && getHealth() < getMaxHealth()) {
                if(!player.isCreative()) itemstack.shrink(1);
                heal((float)item.getFoodProperties(itemstack, this).getNutrition());
                gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
            InteractionResult actionresulttype = super.mobInteract(player, hand);
            if((!actionresulttype.consumesAction() || isBaby()) && isOwnedBy(player)) {
                setOrderedToSit(!isOrderedToSit());
                jumping = false;
                navigation.stop();
                setTarget((LivingEntity)null);
                return InteractionResult.SUCCESS;
            }
        } else if(isTamingFood(itemstack)) {
            if(!player.isCreative()) itemstack.shrink(1);
            if(random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                tame(player);
                navigation.stop();
                setTarget((LivingEntity)null);
                setOrderedToSit(true);
                level().broadcastEntityEvent(this, (byte)7);
            } else level().broadcastEntityEvent(this, (byte)6);
            return InteractionResult.SUCCESS;
        } else if(player.isCreative()) tame(player);
        return super.mobInteract(player, hand);
    }
	@Override
	public AgeableMob getBreedOffspring(ServerLevel s, AgeableMob a) {
		return null;
	}
}
