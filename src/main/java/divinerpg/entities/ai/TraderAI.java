package divinerpg.entities.ai;

import divinerpg.entities.base.*;
import net.minecraft.entity.ai.goal.*;

public class TraderAI extends Goal {
    private final EntityDivineMerchant merchant;

    public TraderAI(EntityDivineMerchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public boolean canUse() {
        return merchant.isAlive() && !merchant.isTrading() && merchant.canRestock();
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }

    @Override
    public void start() {
        merchant.restock();
    }

    @Override
    public void stop() {
        merchant.setTradingPlayer(null);
    }
}
