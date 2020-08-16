package divinerpg.objects.entities.ai;

import divinerpg.objects.entities.entity.EntityDivineMerchant;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIWatchCustomer extends EntityAIWatchClosest {
    private final EntityDivineMerchant merchant;

    public EntityAIWatchCustomer(EntityDivineMerchant merchantIn) {
        super(merchantIn, EntityPlayer.class, 8.0F);
        this.merchant = merchantIn;
    }

    public boolean shouldExecute() {
        if (this.merchant.isTrading()) {
            this.closestEntity = this.merchant.getCustomer();
            return true;
        } else {
            return false;
        }
    }
}
