package naturix.divinerpg.entities.entity;

import naturix.divinerpg.entities.entity.vanilla.AyeracoBlue;
import naturix.divinerpg.entities.entity.vanilla.AyeracoGreen;
import naturix.divinerpg.entities.entity.vanilla.AyeracoPurple;
import naturix.divinerpg.entities.entity.vanilla.AyeracoRed;
import naturix.divinerpg.entities.entity.vanilla.AyeracoYellow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

public abstract class EntityDivineRPGBoss extends EntityDivineRPGMob {
	

	public EntityDivineRPGBoss(World par1World) {
		super(par1World);
	}
	private BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS));
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

	@Override
	public boolean canDespawn() {
		return false;	
	}

    @Override
	public boolean isNonBoss() {
		return false;
	}

	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		if(this instanceof AyeracoBlue) {
			bossInfo.setColor(BossInfo.Color.BLUE);
			}
		if(this instanceof AyeracoGreen) {
			bossInfo.setColor(BossInfo.Color.GREEN);
			}
		if(this instanceof AyeracoPurple) {
			bossInfo.setColor(BossInfo.Color.PURPLE);
			}
		if(this instanceof AyeracoRed) {
			bossInfo.setColor(BossInfo.Color.RED);
			}
		if(this instanceof AyeracoYellow) {
			bossInfo.setColor(BossInfo.Color.YELLOW);
			}
		
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
}