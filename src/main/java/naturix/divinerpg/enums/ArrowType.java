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
    EDEN_ARROW(6, 16, ItemLoc("eden_arrow"), false, false, false),
    LESSER_WILDWOOD_ARROW(6, 16, ItemLoc("wildwood_arrow"), false, false, false),
    GREATER_WILDWOOD_ARROW(10, 20, ItemLoc("wildwood_arrow"), false, false, false),
    FURY_ARROW(13, 25, ItemLoc("fury_arrow"), false, false, false);

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

    private static ResourceLocation ItemLoc(String name) {
        return new ResourceLocation("divinerpg:textures/items/" + name + ".png");
    }

    private static ResourceLocation ProjectileLoc(String name) {
        return new ResourceLocation("divinerpg:textures/projectiles/" + name + ".png");
    }
}