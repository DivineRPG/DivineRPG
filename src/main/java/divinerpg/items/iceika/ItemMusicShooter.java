package divinerpg.items.iceika;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import net.minecraft.sounds.SoundEvent;

public class ItemMusicShooter extends ItemModRanged {
    public ItemMusicShooter(SoundEvent event, BulletType bulletType) {super(bulletType, event, 4000, 20);}
}