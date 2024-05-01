package divinerpg.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;

public class ItemVetheanCannon extends ItemModRanged {
    public ItemVetheanCannon(BulletType projectileType) {super(projectileType, SoundRegistry.BLITZ.get(), ItemRegistry.acid.getId(), 0, 0);}
}