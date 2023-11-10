package divinerpg.entities.iceika;

import divinerpg.DivineRPG;
import divinerpg.enums.EntityStats;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.*;

public class EntityDolossal extends AbstractHorse {
	private static final Ingredient FOOD = Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry")));
	public EntityDolossal(EntityType<? extends EntityDolossal> type, Level level) {
		super(type, level);
		getNavigation().setCanFloat(true);
		setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1F);
		setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1F);
	}
	@Override protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(3, new AvoidEntityGoal<>(this, EntitySeng.class, 7F, 1D, 1.2));
	}
	@Override public void aiStep() {
		super.aiStep();
		if(getDeltaMovement().y < 0D && ((getControllingPassenger() instanceof LocalPlayer player && player.input.jumping) || (!hasControllingPassenger() && !onGround()))) {
			setDeltaMovement(getDeltaMovement().multiply(1.05, .6, 1.05));
			fallDistance = 0F;
			for(Entity entity : getPassengers()) entity.fallDistance = 0F;
		}
	}
	@Override protected void randomizeAttributes(RandomSource random) {
		getAttribute(Attributes.MAX_HEALTH).setBaseValue(generateMaxHealth(random::nextInt));
		getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(generateSpeed(random::nextDouble));
		getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(generateJumpStrength(random::nextDouble));
	}
	@Override public boolean canMate(Animal animal) {
		return animal != this && animal instanceof EntityDolossal dol && canParent() && dol.canParent();
	}
	@Override public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		EntityDolossal dol = (EntityDolossal)ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(DivineRPG.MODID, "dolossal")).create(level);
		if(dol != null) setOffspringAttributes(mob, dol);
		return dol;
	}
	@Override public boolean isFood(ItemStack stack) {
		return FOOD.test(stack);
	}
	@Override protected boolean handleEating(Player player, ItemStack item) {
		boolean flag = false;
		if(FOOD.test(item)) {
			if(!level().isClientSide() && isTamed() && getAge() == 0 && !isInLove()) {
				flag = true;
				setInLove(player);
			}
	 		if(getHealth() < getMaxHealth()) {
				heal(3f);
				flag = true;
			}
			if(isBaby()) {
				level().addParticle(ParticleTypes.HAPPY_VILLAGER, getRandomX(1D), getRandomY() + .5, getRandomZ(1D), 0D, 0D, 0D);
				if(!level().isClientSide()) ageUp(60);
				flag = true;
			}
			if((flag || !isTamed()) && getTemper() < getMaxTemper()) {
				flag = true;
				if(!level().isClientSide()) modifyTemper(3);
			}
			if(flag) {
				if(!isSilent()) {
					SoundEvent soundevent = getEatingSound();
					if(soundevent != null) level().playSound((Player)null, getX(), getY(), getZ(), soundevent, getSoundSource(), 1F, 1F + (random.nextFloat() - random.nextFloat()) * .2F);
				} gameEvent(GameEvent.EAT);
			}
		} return flag;
	}
	@Override protected void playStepSound(BlockPos pos, BlockState stat) {
		playSound(SoundEvents.CHICKEN_STEP, .25F, .6F);
	}
	@Override protected void playJumpSound() {
		playSound(SoundEvents.RABBIT_JUMP);
	}
	public static final <T extends Mob> void registerDolossalAttributes(EntityAttributeCreationEvent event, RegistryObject<EntityType<T>> entity) {
		EntityStats stats = EntityStats.DOLOSSAL;
		event.put(entity.get(), Mob.createMobAttributes().add(Attributes.MAX_HEALTH, stats.getHealth()).add(Attributes.ATTACK_DAMAGE, stats.getAttackDamage()).add(Attributes.MOVEMENT_SPEED, stats.getMovementSpeed()).add(Attributes.FOLLOW_RANGE, stats.getFollowRange()).add(Attributes.FLYING_SPEED, stats.getMovementSpeed()).add(Attributes.JUMP_STRENGTH, 1D).build());
	}
}