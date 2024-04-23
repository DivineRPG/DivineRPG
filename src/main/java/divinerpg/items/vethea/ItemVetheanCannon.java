package divinerpg.items.vethea;

import divinerpg.DivineRPG;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import net.minecraft.resources.ResourceLocation;

public class ItemVetheanCannon extends ItemModRanged {
    public ItemVetheanCannon(BulletType projectileType) {super(projectileType, SoundRegistry.BLITZ.get(), new ResourceLocation(DivineRPG.MODID, "acid"), 0, 0);}
}