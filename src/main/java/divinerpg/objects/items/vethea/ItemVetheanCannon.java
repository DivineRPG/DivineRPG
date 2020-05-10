package divinerpg.objects.items.vethea;

import divinerpg.enums.BulletType;
import divinerpg.objects.items.base.RangedWeaponBase;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.util.SoundCategory;

import java.util.function.Supplier;

public class ItemVetheanCannon extends RangedWeaponBase {

    public ItemVetheanCannon(String name, BulletType projectileType, Supplier<Item> ammo) {
        super(name, null, projectileType, ModSounds.BLITZ, SoundCategory.MASTER, -1, 0, ammo, 0);
        this.setCreativeTab(DivineRPGTabs.vethea);
    }
}
