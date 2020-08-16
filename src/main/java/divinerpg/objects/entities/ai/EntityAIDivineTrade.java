package divinerpg.objects.entities.ai;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIDivineTrade extends EntityAIBase {
    private final EntityDivineMerchant merchant;

    public EntityAIDivineTrade(EntityDivineMerchant merchantIn) {
        this.merchant = merchantIn;
        this.setMutexBits(5);
    }

    public boolean shouldExecute() {
        if (!this.merchant.isEntityAlive()) {
            return false;
        } else if (this.merchant.isInWater()) {
            return false;
        } else if (!this.merchant.onGround) {
            return false;
        } else if (this.merchant.velocityChanged) {
            return false;
        } else {
            EntityPlayer entityplayer = this.merchant.getCustomer();
            if (entityplayer == null) {
                return false;
            } else if (this.merchant.getDistanceSq(entityplayer) > 16.0D) {
                return false;
            } else {
                return entityplayer.openContainer != null;
            }
        }
    }

    public void startExecuting() {
        this.merchant.getNavigator().clearPath();
    }

    public void resetTask() {
        this.merchant.setCustomer(null);
    }
}
