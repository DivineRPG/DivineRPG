package divinerpg.events;

import divinerpg.*;
import divinerpg.attachments.Arcana;
import divinerpg.network.payload.Weather;
import divinerpg.registries.*;
import divinerpg.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.event.tick.*;

@EventBusSubscriber(modid = DivineRPG.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Ticker {
    public static int tick;
    @SubscribeEvent
    public void tickServer(ServerTickEvent evt) {
        if(evt.hasTime()) {
            tick++;
            if(tick>100000) tick = 0;
            if(Math.random() < .001D) Utils.ICEIKA_WEATHER = Weather.newWeather(evt.getServer().getLevel(LevelRegistry.ICEIKA));
        }
    }
	@SubscribeEvent
    public static void playerTick(PlayerTickEvent event){
        Player player = event.getEntity();
        Level level = player.level();
        Arcana.regen(player);
        if(level.dimension().equals(LevelRegistry.ICEIKA) && !player.isCreative() && !player.isSpectator()) {
        	if(Utils.ICEIKA_WEATHER == 1 && level.isRaining() && player.getItemBySlot(EquipmentSlot.HEAD).isEmpty() && player.getRandom().nextFloat() < .1F && level.canSeeSky(player.blockPosition())) player.hurt(level.damageSources().generic(), 1F);
        	if(!level.isClientSide() && !player.hasEffect(MobEffectRegistry.WARMTH) && !player.getItemBySlot(EquipmentSlot.CHEST).getAllEnchantments(CommonHooks.resolveLookup(Registries.ENCHANTMENT)).keySet().contains(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.INSULATION)) && level.getLightEngine().getLayerListener(LightLayer.BLOCK).getLightValue(player.blockPosition()) < 8) {
    			player.setSharedFlagOnFire(false);
    			if(player.isFullyFrozen()) {
    				player.setTicksFrozen(player.getTicksRequiredToFreeze() + 2);
    				if(player.getHealth() > 1F && player.tickCount % 40 == 0) player.hurt(level.damageSources().freeze(), .5F);
    			} else player.setTicksFrozen(player.getTicksFrozen() + 1 + player.getRandom().nextInt(2) + (Utils.ICEIKA_WEATHER == 2 ? player.getRandom().nextInt(2) : 0));
        	}
        }
        if(player.getItemBySlot(EquipmentSlot.CHEST).getAllEnchantments(CommonHooks.resolveLookup(Registries.ENCHANTMENT)).keySet().contains(level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.INSULATION))) {
    		int f = player.getTicksFrozen();
    		if(f > 0) player.setTicksFrozen(f - 2);
        }
    }
}