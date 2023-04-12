package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.config.CommonConfig;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID)
public class GhostWhaleEvent {

    private static final ResourceLocation BONEYARD_BIOME = new ResourceLocation(DivineRPG.MODID, "boneyard");

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!event.getEntity().level.isClientSide) {
            List<String> ANIMALS = CommonConfig.ghostWhaleProtected.get();
            Entity source = event.getSource().getDirectEntity();
            if (source == null || !(source instanceof Player)) {
                return;
            }
            Player player = (Player) source;
            Level world = player.level;
            Holder<Biome> biome = world.getBiome(event.getEntity().blockPosition());
            if (!biome.is(BONEYARD_BIOME)) {
                return;
            }
            for (String animal : ANIMALS) {
                if (ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(animal)) == event.getEntity().getType()) {
                    break;
                }
            }
            if (!player.isCreative()) {
                int kills = player.getPersistentData().getInt("animal_kills") + 1;
                player.getPersistentData().putInt("animal_kills", kills);
                if (kills >= CommonConfig.ghostWhaleKills.get()) {
                    BlockPos spawnPos = event.getEntity().blockPosition().offset(player.random.nextInt(16) - 8, player.random.nextInt(8) + 4, player.random.nextInt(16) - 8);
                    EntityRegistry.GHOST_WHALE.get().spawn((ServerLevel) world, (ItemStack) null, player, spawnPos, MobSpawnType.EVENT, false, false);
                    player.getPersistentData().putInt("animal_kills", 0);
                }
            }
        }
    }

}