package naturix.divinerpg.enums;

import net.minecraft.util.ResourceLocation;

public enum ArrowType {
    NONE(0, 0, null, false, false, false),
    HUNTER_ARROW(2, 11, ProjectileLoc("hunter_arrow"), true, false, false),
    SHADOW_ARROW(2, 11, ProjectileLoc("shadow_arrow"), false, false, false),
    ENDER_ARROW(4, 16, ProjectileLoc("ender_arrow"), false, false, false),
    BLUEFIRE_ARROW(2, 11, ProjectileLoc("bluefire_arrow"), false, false, true),
    INFERNO_ARROW(2, 11, ProjectileLoc("inferno_arrow"), false, true, false),
    ICICLE_ARROW(2, 11, ProjectileLoc("icicle_arrow"), false, false, false),
    SNOWSTORM_ARROW(2, 11, ProjectileLoc("snowstorm_arrow"), false, false, true),
    EDEN_ARROW(6, 16, ProjectileLoc("eden_arrow"), false, false, false),
    LESSER_WILDWOOD_ARROW(6, 16, ProjectileLoc("wildwood_arrow"), false, false, false),
    GREATER_WILDWOOD_ARROW(10, 20, ProjectileLoc("wildwood_arrow"), false, false, false),
    FURY_ARROW(13, 25, ProjectileLoc("fury_arrow"), false, false, false),
    EVERFRIGHT(25, 46, ProjectileLoc("ever_arrow"), false, false, false),
    TEAKER_ARROW(2, 5, ProjectileLoc("teaker_arrow"), false, false, false),
    AMTHRIMIS_ARROW(2, 7, ProjectileLoc("teaker_arrow"), false, false, false),
    DARVEN_ARROW(3, 11, ProjectileLoc("darven_arrow"), false, false, false),
    CERMIL_ARROW(4, 14, ProjectileLoc("darven_arrow"), false, false, false),
    PARDINAL_ARROW(5, 18, ProjectileLoc("pardimal_arrow"), false, false, false),
    QUADROTIC_ARROW(6, 21, ProjectileLoc("pardimal_arrow"), false, false, false),
    KAROS_ARROW(7, 23, ProjectileLoc("karos_arrow"), false, false, false),
    HELIOSIS_ARROW(8, 28, ProjectileLoc("karos_arrow"), false, false, false),
    ARKSIAN_ARROW(12, 36, ProjectileLoc("karos_arrow"), false, false, false),

    ARID_WARRIOR_ARROW(1.5F, 1.5F, VanillaLoc(), false, false, false),
    WILDFIRE_ARROW(5, 5, ProjectileLoc("inferno_arrow"), false, true, false),
    FROST_ARCHER_ARROW(2, 2, ProjectileLoc("snowstorm_arrow"), false, false, false);

    private final float minDamage;
    private final float maxDamage;
    private final ResourceLocation texture;
    private boolean poisonDamage;
    private boolean fireDamage;
    private boolean explosionDamage;

    ArrowType(float minDamage, float maxDamage, ResourceLocation texture, boolean poisonDamage, boolean fireDamage,
            boolean explosionDamage) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.texture = texture;
        this.poisonDamage = poisonDamage;
        this.fireDamage = fireDamage;
        this.explosionDamage = explosionDamage;
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

    public boolean poisonDamage() {
        return this.poisonDamage;
    }

    public boolean fireDamage() {
        return this.fireDamage;
    }

    public boolean explosionDamage() {
        return this.explosionDamage;
    }

    public static ArrowType getArrowFromId(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) {
            ordinal = 0;
        }
        return values()[ordinal];
    }

    private static ResourceLocation ProjectileLoc(String name) {
        return new ResourceLocation("divinerpg:textures/projectiles/" + name + ".png");
    }

    private static ResourceLocation VanillaLoc() {
        return new ResourceLocation("minecraft:textures/projectiles/arrow.png");
    }
}