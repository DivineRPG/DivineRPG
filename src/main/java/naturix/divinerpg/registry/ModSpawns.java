package naturix.divinerpg.registry;

import naturix.divinerpg.entities.entity.vanilla.Shark;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class ModSpawns {
	public static void init(LivingSpawnEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		if(entity.world.getGameRules().getBoolean("doMobSpawning")) {
		if(entity instanceof EntityWaterMob) {
			if(entity.world.getBiome(new BlockPos(entity)) == Biomes.OCEAN && entity.world.getDifficulty() != EnumDifficulty.PEACEFUL && !entity.world.isRemote) {
				if(entity.getRNG().nextInt(500) == 1) {
					Shark squid = new Shark(entity.world);
					squid.copyLocationAndAnglesFrom(entity);
					entity.world.spawnEntity(squid);
					entity.setDead();
				} 
			}
		}

		
	}}
}
