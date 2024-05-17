package divinerpg.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;

public class ItemStaff extends ItemModRanged {
    public ItemStaff(BulletType projectileType, int arcana, int onUseDamage) {
        super(projectileType, SoundRegistry.STAFF.get(), null, 0, 0, arcana);
        this.onUseDamage = onUseDamage;
    }
}