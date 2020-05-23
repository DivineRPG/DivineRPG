package divinerpg.enums;

import divinerpg.DivineRPG;
import net.minecraft.util.ResourceLocation;

public enum ArrowType {
    NONE(0, 0, null),
    HUNTER_ARROW(2, 11, ProjectileLoc("hunter_arrow"), ArrowSpecial.POSION),
    SHADOW_ARROW(2, 11, ProjectileLoc("shadow_arrow")),
    ENDER_ARROW(4, 16, ProjectileLoc("ender_arrow")),
    BLUEFIRE_ARROW(2, 11, ProjectileLoc("bluefire_arrow"), ArrowSpecial.EXPLODE),
    INFERNO_ARROW(2, 11, ProjectileLoc("inferno_arrow"), ArrowSpecial.FLAME),
    ICICLE_ARROW(2, 11, ProjectileLoc("icicle_arrow")),
    SNOWSTORM_ARROW(2, 11, ProjectileLoc("snowstorm_arrow"), ArrowSpecial.EXPLODE),
    EDEN_ARROW(6, 16, ProjectileLoc("eden_arrow")),
    LESSER_WILDWOOD_ARROW(6, 16, ProjectileLoc("wildwood_arrow")),
    GREATER_WILDWOOD_ARROW(10, 20, ProjectileLoc("wildwood_arrow")),
    FURY_ARROW(13, 25, ProjectileLoc("fury_arrow")),
    EVERFRIGHT(25, 46, ProjectileLoc("ever_arrow")),
    TEAKER_ARROW(2, 5, ProjectileLoc("teaker_arrow")),
    AMTHIRMIS_ARROW(2, 7, ProjectileLoc("teaker_arrow")),
    DARVEN_ARROW(3, 11, ProjectileLoc("darven_arrow")),
    CERMILE_ARROW(4, 14, ProjectileLoc("darven_arrow")),
    PARDIMAL_ARROW(5, 18, ProjectileLoc("pardimal_arrow")),
    QUADROTIC_ARROW(6, 21, ProjectileLoc("pardimal_arrow")),
    KAROS_ARROW(7, 23, ProjectileLoc("karos_arrow")),
    HELIOSIS_ARROW(8, 28, ProjectileLoc("karos_arrow")),
    ARKSIANE_ARROW(12, 36, ProjectileLoc("karos_arrow")),

    ARID_WARRIOR_ARROW(1.5F, 1.5F, VanillaLoc()),
    WILDFIRE_ARROW(5, 5, ProjectileLoc("inferno_arrow"), ArrowSpecial.FLAME),
    FROST_ARCHER_ARROW(2, 2, ProjectileLoc("snowstorm_arrow")),
    SUN_ARCHER_ARROW(9, 9, ProjectileLoc("eden_arrow")),
    ENCHANTED_ARCHER_ARROW(12, 12, ProjectileLoc("wildwood_arrow")),
    SKYTHERN_ARCHER_ARROW(14, 14, ProjectileLoc("wildwood_arrow")),
    TWILIGHT_ARCHER_ARROW(16, 16, ProjectileLoc("fury_arrow")),
    REYVOR_ARROW(22, 22, ProjectileLoc("fury_arrow")),
    ETERNAL_ARCHER_FLAME_ARROW(26, 26, ProjectileLoc("fury_arrow"), ArrowSpecial.FLAME),
    ETERNAL_ARCHER_WITHER_ARROW(26, 26, ProjectileLoc("fury_arrow"), ArrowSpecial.WITHER),
    ETERNAL_ARCHER_EXPLODE_ARROW(26, 26, ProjectileLoc("fury_arrow"), ArrowSpecial.EXPLODE),
    ETERNAL_ARCHER_SLOW_ARROW(26, 26, ProjectileLoc("fury_arrow"), ArrowSpecial.SLOW),
    ETERNAL_ARCHER_NAUSEA_ARROW(26, 26, ProjectileLoc("fury_arrow"), ArrowSpecial.NAUSEA),
    ETERNAL_ARCHER_BLIND_ARROW(26, 26, ProjectileLoc("fury_arrow"), ArrowSpecial.BLIND),
    LIVING_STATUE_ARROW(6, 6, VanillaLoc());

    private final float minDamage;
    private final float maxDamage;
    private final ResourceLocation texture;
    private ArrowSpecial arrowSpecial = ArrowSpecial.NONE;

    ArrowType(float minDamage, float maxDamage, ResourceLocation texture) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.texture = texture;
        this.arrowSpecial = ArrowSpecial.NONE;
    }

    ArrowType(float minDamage, float maxDamage, ResourceLocation texture, ArrowSpecial special) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.texture = texture;
        this.arrowSpecial = special;
    }

    public float getMinDamage() {
        return this.minDamage;
    }

    public float getMaxDamage() {
        return this.maxDamage;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public ArrowSpecial getArrowSpecial() {
        return this.arrowSpecial;
    }

    public static ArrowType getArrowFromId(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) {
            ordinal = 0;
        }
        return values()[ordinal];
    }

    private static ResourceLocation ProjectileLoc(String name) {
        return new ResourceLocation(DivineRPG.MODID, "textures/projectiles/" + name + ".png");
    }

    private static ResourceLocation VanillaLoc() {
        return new ResourceLocation("minecraft:textures/entity/projectiles/arrow.png");
    }

    public enum ArrowSpecial {
        NONE, FLAME, WITHER, EXPLODE, SLOW, NAUSEA, BLIND, POSION
    }
}