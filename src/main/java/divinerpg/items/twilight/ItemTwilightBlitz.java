package divinerpg.items.twilight;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.item.*;

public class ItemTwilightBlitz extends ItemModRanged {
    public ItemTwilightBlitz(Rarity rarity, BulletType bulletType, Item ammoSupplier, int uses) {super(rarity, null, bulletType, SoundRegistry.BLITZ.get(), uses, 0, ammoSupplier, 0);}
}