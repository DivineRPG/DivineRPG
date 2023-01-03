package divinerpg.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import net.minecraft.resources.ResourceLocation;

public class ItemVetheanCannon extends ItemModRanged {

    public ItemVetheanCannon(BulletType projectileType, ResourceLocation ammo) {
        super(projectileType, () -> SoundRegistry.BLITZ.get(), ammo, -1, 0);
    }
}
