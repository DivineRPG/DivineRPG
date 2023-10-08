package divinerpg.events;

import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.registries.*;
import divinerpg.util.DivineRPGPacketHandler;
import divinerpg.util.Utils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Ticker {
    public static int tick;
    @SubscribeEvent
    public void tickServer(TickEvent.ServerTickEvent evt) {
        if(evt.phase == TickEvent.Phase.END) {
            tick++;
            if(tick>100000) tick = 0;
            if(Math.random() < .001D) Utils.ICEIKA_WEATHER = DivineRPGPacketHandler.newWeather();
        }
    }
	@SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event){
        if(event.phase == TickEvent.Phase.START){
            event.player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana != null)
            arcana.regen(event.player);
        });
        }
        Player player = event.player;
        Level level = player.level();
        if(level.dimension().equals(LevelRegistry.ICEIKA) && !player.isCreative() && !player.isSpectator()) {
        	if(!(player.getItemBySlot(EquipmentSlot.HEAD).is(ItemRegistry.WARM_ARMOR) && player.getItemBySlot(EquipmentSlot.CHEST).is(ItemRegistry.WARM_ARMOR) && player.getItemBySlot(EquipmentSlot.LEGS).is(ItemRegistry.WARM_ARMOR) && player.getItemBySlot(EquipmentSlot.FEET).is(ItemRegistry.WARM_ARMOR))
        			&& level.getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(player.blockPosition()) < 7) {
        		if(!level.isClientSide()) {
        			player.setSharedFlagOnFire(false);
        			if(player.isFullyFrozen()) {
        				player.setTicksFrozen(player.getTicksRequiredToFreeze() + 2);
        				if(player.getHealth() > 1F && player.tickCount % 40 == 0) player.hurt(level.damageSources().freeze(), .5F);
        			} else player.setTicksFrozen(player.getTicksFrozen() + 1 + player.getRandom().nextInt(2) + (Utils.ICEIKA_WEATHER == 2 ? player.getRandom().nextInt(2) : 0));
        		}
        	}
        	if(Utils.ICEIKA_WEATHER == 1 && level.isRaining() && player.getItemBySlot(EquipmentSlot.HEAD).isEmpty() && player.getRandom().nextFloat() < .1F && level.canSeeSky(player.blockPosition())) player.hurt(level.damageSources().generic(), 1F);
        }
    }
    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        event.getEntity().getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            arcana.fill(event.getEntity(), arcana.getMaxArcana());
        });
    }
    @SubscribeEvent
    public void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        event.getEntity().getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            arcana.fill(event.getEntity(), arcana.getMaxArcana()-arcana.getArcana());
            event.getEntity().giveExperiencePoints(0);
        });
    }
}