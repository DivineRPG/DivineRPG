package divinerpg.items.twilight;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.item.Rarity;

public class ItemTwilightPhaser extends ItemModRanged {
    public ItemTwilightPhaser(Rarity rarity, BulletType bulletType, int uses) {super(rarity, null, bulletType, SoundRegistry.PHASER.get(), uses, 50, null, 0);}
}