package divinerpg.enums;

import divinerpg.DivineRPG;
import net.minecraft.util.ResourceLocation;

public enum DiskType {
    NONE(0, null),
    TEAKER_DISK(4, ItemLoc("teaker_disk")),
    AMTHRIMIS_DISK(6, ItemLoc("amthirmis_disk")),
    DARVEN_DISK(9, ItemLoc("darven_disk")),
    CERMILE_DISK(13, ItemLoc("cermile_disk")),
    PARDIMAL_DISK(16, ItemLoc("pardimal_disk")),
    QUADROTIC_DISK(20, ItemLoc("quadrotic_disk")),
    KAROS_DISK(22, ItemLoc("karos_disk")),
    HELIOSIS_DISK(29, ItemLoc("heliosis_disk")),
    ARKSIANE_DISK(37, ItemLoc("arksiane_disk"));

    private final float damage;
    private final ResourceLocation texture;

    DiskType(float damage, ResourceLocation texture) {
        this.damage = damage;
        this.texture = texture;
    }

    public float getDamage() {
        return this.damage;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public static DiskType getDiskFromOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) {
            ordinal = 0;
        }
        return values()[ordinal];
    }

    private static ResourceLocation ItemLoc(String name) {
        return new ResourceLocation(DivineRPG.MODID, "textures/items/" + name + ".png");
    }

    private static ResourceLocation ProjectileLoc(String name) {
        return new ResourceLocation(DivineRPG.MODID, "textures/projectiles/" + name + ".png");
    }
}
