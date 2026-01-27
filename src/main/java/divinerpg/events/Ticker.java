package divinerpg.events;

import divinerpg.attachments.Arcana;
import divinerpg.block_entities.block.TerranGhostBlockEntity;
import divinerpg.entities.goals.TurtleEatAequoreaGoal;
import divinerpg.entities.vanilla.overworld.EntityAequorea;
import divinerpg.network.payload.Weather;
import divinerpg.recipe.FireConversionRecipe;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.*;
import net.minecraft.sounds.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.event.entity.*;
import net.neoforged.neoforge.event.entity.player.*;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.*;

import java.util.List;

public class Ticker {
    public static int tick;
    @SubscribeEvent
    public void tickServer(ServerTickEvent.Pre evt) {
        if(evt.hasTime()) {
            tick++;
            if(tick > 100000) tick = 0;
            if(Math.random() < .0001) Utils.ICEIKA_WEATHER = Weather.newWeather(evt.getServer().getLevel(LevelRegistry.ICEIKA));
        }
    }
	@SubscribeEvent
    public void playerTick(PlayerTickEvent.Pre event){
        Player player = event.getEntity();
        Level level = player.level();
        if(!level.isClientSide()) Arcana.regen(player);
        if(level.dimension() == LevelRegistry.ICEIKA) {
            if(!level.isClientSide() && (player.tickCount & 7) == 0) AttachmentRegistry.IN_DUNGEON.set(player, ((ServerLevel) level).structureManager().getStructureWithPieceAt(player.blockPosition(), TagRegistry.ICEIKA_DUNGEON).isValid());
            if(!player.isCreative() && !player.isSpectator()) {
                if(Utils.ICEIKA_WEATHER == 1 && level.isRaining() && player.getItemBySlot(EquipmentSlot.HEAD).isEmpty() && player.getRandom().nextFloat() < .1F && level.canSeeSky(player.blockPosition())) player.hurt(level.damageSources().source(DamageRegistry.HAIL.getKey()), 1);
                if(!level.isClientSide && !player.hasEffect(MobEffectRegistry.WARMTH) && !player.isOnFire() && !player.getItemBySlot(EquipmentSlot.CHEST).getTagEnchantments().keySet().contains(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.INSULATION)) && level.getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(player.blockPosition()) < 8) {
                    player.setSharedFlagOnFire(false);
                    if(player.isFullyFrozen()) {
                        player.setTicksFrozen(player.getTicksRequiredToFreeze() + 2);
                        if(player.getHealth() > 1 && player.tickCount % 40 == 0) player.hurt(level.damageSources().freeze(), .5F);
                    } else player.setTicksFrozen(player.getTicksFrozen() + 2 + player.getRandom().nextInt(2) + (Utils.ICEIKA_WEATHER == 2 ? player.getRandom().nextInt(2) : 0));
                }
            }
        } if(player.getItemBySlot(EquipmentSlot.CHEST).getAllEnchantments(CommonHooks.resolveLookup(Registries.ENCHANTMENT)).keySet().contains(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.INSULATION))) {
    		int f = player.getTicksFrozen();
    		if(f > 0) player.setTicksFrozen(f - 2);
        }
    }
    @SubscribeEvent
    public void canSleep(CanPlayerSleepEvent e) {
        Player.BedSleepingProblem p = e.getProblem();
        if((p == Player.BedSleepingProblem.NOT_POSSIBLE_HERE || p == Player.BedSleepingProblem.NOT_POSSIBLE_NOW) && e.getState().is(BlockRegistry.nightmareBed))
            e.setProblem(null);
    }
    @SubscribeEvent
    public void canContinueSleeping(CanContinueSleepingEvent e) {
        Player.BedSleepingProblem p = e.getProblem();
        if((p == Player.BedSleepingProblem.NOT_POSSIBLE_HERE || p == Player.BedSleepingProblem.NOT_POSSIBLE_NOW) && e.getEntity().getInBlockState().is(BlockRegistry.nightmareBed))
            e.setContinueSleeping(true);
    }
    @SubscribeEvent
    public void addVanillaMobGoals(EntityJoinLevelEvent event) {
        if(event.getEntity() instanceof Turtle turtle) {
            turtle.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(turtle, EntityAequorea.class, false));
            turtle.goalSelector.addGoal(3, new TurtleEatAequoreaGoal(turtle, turtle.getAttributeValue(Attributes.MOVEMENT_SPEED) * 4, false));
        }
    }
    @SubscribeEvent
    public void onMineBlock(BlockEvent.BreakEvent event) {
        if(handleTerranShifter(event.getLevel(), event.getPlayer(), event.getPos(), event.getState(), event.getPlayer().getMainHandItem())) event.setCanceled(true);
    }
    public static boolean handleTerranShifter(LevelAccessor level, Player player, BlockPos pos, BlockState state, ItemStack tool) {
        if(tool.is(ItemRegistry.terran_shifter) && !state.is(BlockRegistry.terranGhostBlock)) {
            level.setBlock(pos, BlockRegistry.terranGhostBlock.get().defaultBlockState(), 3);
            ((TerranGhostBlockEntity)level.getBlockEntity(pos)).originalState = state;
            tool.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
            return true;
        } return false;
    }
    @SubscribeEvent
    public void onEntityLeave(EntityLeaveLevelEvent event) {
        if(!event.getLevel().isClientSide && event.getEntity() instanceof ItemEntity i && i.getAge() < i.lifespan) {
            ItemStack stack = i.getItem();
            if(stack.isEmpty()) return;
            ServerLevel level = (ServerLevel) event.getLevel();
            List<FireConversionRecipe> recipes = level.getRecipeManager().getAllRecipesFor(FireConversionRecipe.TYPE).stream().filter(r -> r.value().inputItem().test(stack)).map(RecipeHolder::value).toList();
            if(recipes.isEmpty()) return;
            BlockPos pos = i.blockPosition();
            if(!level.isAreaLoaded(pos, 1)) return;
            BlockState state, prevState;
            Iterable<BlockPos> positions = BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 0, 1));
            for(BlockPos position : positions) {
                prevState = state = level.getBlockState(position);
                if(!state.isAir()) for(FireConversionRecipe recipe : recipes) if(recipe.inputState().test(state, level.random)) {
                    if(recipe.outputState().isPresent()) level.setBlock(position, state = recipe.outputState().get().getState(level.getRandom(), position), 3);
                    if(recipe.outputItem().isPresent()) {
                        ItemStack output = recipe.outputItem().get().copy();
                        if(!output.isEmpty()) {
                            if(output.is(ItemRegistry.frozen_clock)) output.set(DataComponentRegistry.variant, Utils.determineTimeOfDay(level));
                            output.setCount(output.getCount() * stack.getCount());
                            ItemEntity itemEntity = new ItemEntity(level, i.getX(), i.getY(), i.getZ(), output);
                            itemEntity.setDefaultPickUpDelay();
                            itemEntity.setDeltaMovement(i.getDeltaMovement());
                            level.addFreshEntity(itemEntity);
                        }
                    } if(recipe.advancement().isPresent()) {
                        List<ServerPlayer> players = Utils.getNearbyPlayers(level, i.getX(), i.getY(), i.getZ(), 9);
                        for(ServerPlayer player : players) Utils.awardAdvancement(level.getServer(), player, recipe.advancement().get(), recipe.advancementCriteria().orElse("impossible"));
                    } if(state.isAir()) {
                        if(prevState.is(BlockRegistry.icyFire)) level.playSound(null, position, SoundRegistry.FREEZE.get(), SoundSource.BLOCKS, .8F, 1.5F);
                        else if(prevState.is(BlockRegistry.enchantedFlame)) {
                            level.playSound(null, position, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 0.8F, 1.2F);
                            level.playSound(null, position, SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 0.8F, 1F);
                        } else if(prevState.is(BlockTags.FIRE)) level.playSound(null, position, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS);
                        else if(prevState.getFluidState().is(FluidRegistry.SMOLDERING_TAR_FLUID.get())) {
                            level.playSound(null, position, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 1, 1);
                            level.sendParticles(ParticleTypes.SMOKE, i.getX(), i.getY(), i.getZ(), 25, .5, .5, .5, .01);
                        }
                    } else if(state.is(BlockRegistry.icyFire)) {
                        if(prevState.is(BlockRegistry.icyFire)) level.playSound(null, position, SoundRegistry.FREEZE.get(), SoundSource.BLOCKS, .8F, 1.5F);
                        else level.playSound(null, position, SoundRegistry.FREEZE.get(), SoundSource.BLOCKS, 1, 1);
                    } else if(state.is(BlockRegistry.hellFire)) {
                        level.sendParticles(ParticleTypes.SOUL, i.getX(), i.getY(), i.getZ(), 4, .2, .2, .2, 0);
                        level.playSound(null, position, SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, .7F, 1.5F);
                        level.playSound(null, position, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1, 1);
                    } else if(state.is(BlockRegistry.divineFlame) || state.is(BlockRegistry.wildFlame) || state.is(BlockRegistry.enchantedFlame) || state.is(BlockRegistry.skyFire) || state.is(BlockRegistry.mortumEmbers)) {
                        level.playSound(null, position, SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.BLOCKS, 1, 1);
                        level.playSound(null, position, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1, 1);
                    } return;
                }
            }
        }
    }
}