package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.entity.vanilla.Liopleurodon;
import naturix.divinerpg.entities.entity.vanilla.Shark;
import naturix.divinerpg.entities.entity.vanilla.Whale;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class ModSpawns {
	public static void init(LivingSpawnEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		if(entity.world.getGameRules().getBoolean("doMobSpawning")) {
		if(entity instanceof EntityWaterMob) {
			if(entity.world.getDifficulty() != EnumDifficulty.PEACEFUL && !entity.world.isRemote && entity.world.getBlockState(entity.getPosition())==Blocks.WATER.getDefaultState()) {
				
					
					Shark shark = new Shark(entity.world);
					Whale whale = new Whale(entity.world);
					Liopleurodon liopleurodon = new Liopleurodon(entity.world);
					
					shark.copyLocationAndAnglesFrom(entity);
					whale.copyLocationAndAnglesFrom(entity);
					liopleurodon.copyLocationAndAnglesFrom(entity);
					
					if(entity.getRNG().nextInt(2500) == 1) {
					entity.world.spawnEntity(shark);
					entity.setDead();
					
					if(Config.debug == true) {
						DivineRPG.logger.info(shark.getName() + " just spawned at "+ entity.getPosition());
					}}
					if(entity.getRNG().nextInt(5000) == 1) {
					entity.world.spawnEntity(whale);
					entity.setDead();
					
					if(Config.debug == true) {
						DivineRPG.logger.info(whale.getName() + " just spawned at "+ entity.getPosition());
					}}
					if(entity.world.getBiome(entity.getPosition()) == Biomes.DEEP_OCEAN&&entity.getRNG().nextInt(10000) == 1){	
						entity.world.spawnEntity(liopleurodon);
						entity.setDead();

						if(Config.debug == true) {
						DivineRPG.logger.info(liopleurodon.getName() + " just spawned at "+ entity.getPosition());
						}}
					
				} 
			}
		}

		
	}
}