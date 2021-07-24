package divinerpg.entities.base;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class EntityVetheaMob extends EntityDivineMob {
	
	public EntityVetheaMob(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public abstract int getSpawnLayer();
	
	@Override
    public boolean checkSpawnRules(IWorld world, SpawnReason spawnReason) {
        return this.getY() < 48.0D * this.getSpawnLayer()  && this.getY() > 48.0D * (this.getSpawnLayer() - 1) && super.checkSpawnRules(world, spawnReason);
    }
}