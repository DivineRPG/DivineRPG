package divinerpg.events;

import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GlacialWallTotemEvent {

    @SubscribeEvent
    public void onPlayerHurt(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if(player.getInventory().getItem(Inventory.SLOT_OFFHAND).is(ItemRegistry.glacial_wall_totem.get())) {
                if (player.getHealth() <= player.getMaxHealth() * 0.2) {
                    deployIcicleBarrier(player);
                    player.getInventory().getItem(Inventory.SLOT_OFFHAND).shrink(1);
                    Level level = player.level();
                    BlockPos playerPos = player.blockPosition();
                    level.playSound(null, playerPos, SoundEvents.TOTEM_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
    }

    private void deployIcicleBarrier(Player player) {
        Level level = player.level();
        BlockPos playerPos = player.blockPosition();
        int radius = 2;
        for (int x = -radius; x <= radius; x++) {
            for (int y = 0; y <= 4; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos blockPos = playerPos.offset(x, y, z);
                    boolean isOnEdge = Math.abs(x) == radius || Math.abs(z) == radius || y == 0 || y == 4;
                    boolean isAir = level.getBlockState(blockPos).isAir();
                    if (isOnEdge && isAir) {
                        level.setBlockAndUpdate(blockPos, BlockRegistry.icicle.get().defaultBlockState());
                    }
                }
            }
        }
        AABB box = new AABB(playerPos.offset(-radius, 1, -radius), playerPos.offset(radius, 4, radius));
        level.getEntitiesOfClass(LivingEntity.class, box).stream()
                .filter(entity -> entity != player && !(entity instanceof Player) && entity instanceof Mob)
                .forEach(entity -> {
                    double xDist = player.getX() - entity.getX();
                    double zDist = player.getZ() - entity.getZ();
                    double pushStrength = 3.0;

                    entity.push(xDist * pushStrength, 0.5, zDist * pushStrength);
                });
    }

}
