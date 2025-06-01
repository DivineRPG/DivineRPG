package divinerpg.events;

import divinerpg.attachments.Arcana;
import divinerpg.block_entities.block.TerranGhostBlockEntity;
import divinerpg.entities.goals.TurtleEatAequoreaGoal;
import divinerpg.entities.vanilla.overworld.EntityAequorea;
import divinerpg.network.payload.Weather;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.*;

public class Ticker {
    public static int tick;
    @SubscribeEvent
    public void tickServer(ServerTickEvent.Pre evt) {
        if(evt.hasTime()) {
            tick++;
            if(tick>100000) tick = 0;
            if(Math.random() < .0001D) Utils.ICEIKA_WEATHER = Weather.newWeather(evt.getServer().getLevel(LevelRegistry.ICEIKA));
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
                if(Utils.ICEIKA_WEATHER == 1 && level.isRaining() && player.getItemBySlot(EquipmentSlot.HEAD).isEmpty() && player.getRandom().nextFloat() < .1F && level.canSeeSky(player.blockPosition())) player.hurt(level.damageSources().generic(), 1F);
                if(!level.isClientSide() && !player.hasEffect(MobEffectRegistry.WARMTH) && !player.getItemBySlot(EquipmentSlot.CHEST).getTagEnchantments().keySet().contains(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.INSULATION)) && level.getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(player.blockPosition()) < 8) {
                    player.setSharedFlagOnFire(false);
                    if(player.isFullyFrozen()) {
                        player.setTicksFrozen(player.getTicksRequiredToFreeze() + 2);
                        if(player.getHealth() > 1F && player.tickCount % 40 == 0) player.hurt(level.damageSources().freeze(), .5F);
                    } else player.setTicksFrozen(player.getTicksFrozen() + 2 + player.getRandom().nextInt(2) + (Utils.ICEIKA_WEATHER == 2 ? player.getRandom().nextInt(2) : 0));
                }
            }
        }
        if(player.getItemBySlot(EquipmentSlot.CHEST).getAllEnchantments(CommonHooks.resolveLookup(Registries.ENCHANTMENT)).keySet().contains(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.INSULATION))) {
    		int f = player.getTicksFrozen();
    		if(f > 0) player.setTicksFrozen(f - 2);
        }
    }

    @SubscribeEvent
    public void addVanillaMobGoals(EntityJoinLevelEvent event) {
        if(event.getEntity() instanceof Turtle turtle) {
            turtle.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(turtle, EntityAequorea.class, false));
            turtle.goalSelector.addGoal(3, new TurtleEatAequoreaGoal(turtle, turtle.getAttributeValue(Attributes.FOLLOW_RANGE), false));
        }
    }
    @SubscribeEvent
    public void onMineBlock(BlockEvent.BreakEvent event) {
        if(event.getPlayer().getMainHandItem().is(ItemRegistry.terran_shifter)) {
            event.setCanceled(true);
            event.getLevel().setBlock(event.getPos(), BlockRegistry.terranGhostBlock.get().defaultBlockState(), 3);
            ((TerranGhostBlockEntity)event.getLevel().getBlockEntity(event.getPos())).originalState = event.getState();
        }
    }
}