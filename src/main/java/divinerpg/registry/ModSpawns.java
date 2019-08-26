package divinerpg.registry;

import divinerpg.Config;
import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vanilla.Liopleurodon;
import divinerpg.objects.entities.entity.vanilla.Shark;
import divinerpg.objects.entities.entity.vanilla.Whale;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class ModSpawns {
    public static void init(LivingSpawnEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        if (entity.world.getGameRules().getBoolean("doMobSpawning") && entity.world.provider.getDimension() == 0
                && entity instanceof EntityWaterMob && entity.world.getDifficulty() != EnumDifficulty.PEACEFUL
                && !entity.world.isRemote
                && entity.world.getBlockState(entity.getPosition()) == Blocks.WATER.getDefaultState()
                && (entity.world.getBiome(entity.getPosition()) == Biomes.OCEAN
                        || entity.world.getBiome(entity.getPosition()) == Biomes.DEEP_OCEAN)) {

            if (entity.getRNG().nextInt(1500) == 0) {
                Shark shark = new Shark(entity.world);
                shark.copyLocationAndAnglesFrom(entity);
                entity.world.spawnEntity(shark);
                entity.setDead();

                if (Config.debug == true) {
                    DivineRPG.logger.info(shark.getName() + " just spawned at " + entity.getPosition());
                }
            } else if (entity.getRNG().nextInt(2500) == 0) {
                Whale whale = new Whale(entity.world);
                whale.copyLocationAndAnglesFrom(entity);
                entity.world.spawnEntity(whale);
                entity.setDead();

                if (Config.debug == true) {
                    DivineRPG.logger.info(whale.getName() + " just spawned at " + entity.getPosition());
                }
            } else if (entity.getRNG().nextInt(2500) == 0) {
                Liopleurodon liopleurodon = new Liopleurodon(entity.world);
                liopleurodon.copyLocationAndAnglesFrom(entity);
                entity.world.spawnEntity(liopleurodon);
                entity.setDead();

                if (Config.debug == true) {
                    DivineRPG.logger.info(liopleurodon.getName() + " just spawned at " + entity.getPosition());
                }
            }
        }
    }
}