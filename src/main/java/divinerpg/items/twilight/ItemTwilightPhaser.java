package divinerpg.items.twilight;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;

public class ItemTwilightPhaser extends ItemModRanged {
    public ItemTwilightPhaser(int rarity, BulletType bulletType, int uses) {super(rarity, null, bulletType, SoundRegistry.PHASER.get(), uses, 50, null, 0);}
}