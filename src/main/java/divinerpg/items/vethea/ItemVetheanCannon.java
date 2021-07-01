package divinerpg.items.vethea;

import divinerpg.*;
import divinerpg.enums.*;
import divinerpg.items.base.*;
import divinerpg.registries.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

import java.util.function.*;

public class ItemVetheanCannon extends ItemModRanged {

    public ItemVetheanCannon(String name, BulletType projectileType, Supplier<Item> ammo) {
        super(name, null, projectileType, SoundRegistry.BLITZ, SoundCategory.MASTER, -1, 0, ammo, 0, DivineRPG.tabs.vethea);
    }
}
