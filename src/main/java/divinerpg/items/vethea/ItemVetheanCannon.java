package divinerpg.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;

public class ItemVetheanCannon extends ItemModRanged {
    public ItemVetheanCannon(BulletType bulletType) {super(bulletType, SoundRegistry.BLITZ.get(), ItemRegistry.acid.get(), 0, 0);}
}