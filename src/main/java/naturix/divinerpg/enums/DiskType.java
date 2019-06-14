package naturix.divinerpg.enums;

import java.awt.Color;

import naturix.divinerpg.utils.DRPGParticleTypes;
import net.minecraft.util.ResourceLocation;

public enum DiskType {
    NONE(0, null),
    TEAKER_DISK(4, ItemLoc("teaker_disk")),
    AMTHRIMIS_DISK(6, ItemLoc("amthirmis_disk")),
    DARVEN_DISK(9, ItemLoc("darven_disk")),
    CERMILE_DISK(13, ItemLoc("cermile_disk")),
    PARDIMAL_DISK(16, ItemLoc("pardimal_disk")),
    QUADROTIC_DISK(20, ItemLoc("quadrotic_wardisk")),
    KAROS_DISK(22, ItemLoc("karos_wardisk")),
    HELIOSIS_DISK(29, ItemLoc("heliosis_wrathdisk")),
    ARKSIANE_DISK(37, ItemLoc("arksiane_wrathdisk")),

    MAGE_SHOT(5, ProjectileLoc("blank"), new Color(62, 212, 254)),
    SPELLBINDER_SHOT(7, ProjectileLoc("blank"), new Color(234, 158, 253)),
    MYSTIC_SHOT(10, ProjectileLoc("blank"), new Color(234, 223, 228)),
    SORCERER_SHOT(12, ProjectileLoc("blank"), new Color(97, 31, 54)),
    TWILIGHT_DEMON_BLACK_SHOT(16, ProjectileLoc("twilight_demon_shot"), new Color(0, 0, 0)),
    TWILIGHT_DEMON_RED_SHOT(16, ProjectileLoc("twilight_demon_shot"), new Color(255, 0, 0)),
    SOUL_FIEND_SHOT(0, ProjectileLoc("blank"));

    private final float damage;
    private final ResourceLocation texture;
    private final DRPGParticleTypes particle;
    private final Color color;

    DiskType(float damage, ResourceLocation texture, DRPGParticleTypes particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        this.color = null;
    }

    DiskType(float damage, ResourceLocation texture, Color color) {
        this.damage = damage;
        this.texture = texture;
        this.particle = DRPGParticleTypes.NONE;
        this.color = color;
    }

    DiskType(float damage, ResourceLocation texture) {
        this.damage = damage;
        this.texture = texture;
        this.particle = DRPGParticleTypes.NONE;
        this.color = null;
    }

    public float getDamage() {
        return this.damage;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public DRPGParticleTypes getParticle() {
        return this.particle;
    }

    public Color getColor() {
        return this.color;
    }

    public static DiskType getBulletFromOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) {
            ordinal = 0;
        }
        return values()[ordinal];
    }

    private static ResourceLocation ItemLoc(String name) {
        return new ResourceLocation("divinerpg:textures/items/" + name + ".png");
    }

    private static ResourceLocation ProjectileLoc(String name) {
        return new ResourceLocation("divinerpg:textures/projectiles/" + name + ".png");
    }
}