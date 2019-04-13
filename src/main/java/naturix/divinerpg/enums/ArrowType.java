package naturix.divinerpg.enums;

import net.minecraft.util.ResourceLocation;

public enum ArrowType {
    NONE(0, 0, 0, null),
    HUNTER_ARROW(1, 2, 11, ProjectileLoc("hunter_arrow")),
    SHADOW_ARROW(2, 2, 11, ProjectileLoc("shadow_arrow")),
    ENDER_ARROW(3, 4, 16, ProjectileLoc("ender_arrow")),
    BLUEFIRE_ARROW(4, 2, 11, ProjectileLoc("bluefire_arrow")),
    INFERNO_ARROW(5, 2, 11, ProjectileLoc("inferno_arrow")),
    ICICLE_ARROW(6, 2, 11, ProjectileLoc("icicle_arrow")),
    SNOWSTORM_ARROW(7, 2, 11, ProjectileLoc("snowstorm_arrow")),
    EDEN_ARROW(8, 6, 16, ItemLoc("eden_arrow")),
    LESSER_WILDWOOD_ARROW(9, 6, 16, ItemLoc("wildwood_arrow")),
    GREATER_WILDWOOD_ARROW(10, 10, 20, ItemLoc("wildwood_arrow")),
    FURY_ARROW(11, 13, 25, ItemLoc("fury_arrow"));

    private final int id;
    private final float minDamage;
    private final float maxDamage;
    private final ResourceLocation texture;

    ArrowType(int id, float minDamage, float maxDamage, ResourceLocation texture) {
        this.id = id;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.texture = texture;
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

    public int getArrowId() {
        return this.id;
    }

    public static ArrowType getArrowFromId(int id) {
        for (ArrowType arrow : ArrowType.values()) {
            if (arrow.getArrowId() == id) {
                return arrow;
            }
        }
        return NONE;
    }

    private static ResourceLocation ItemLoc(String name) {
        return new ResourceLocation("divinerpg:textures/items/" + name + ".png");
    }

    private static ResourceLocation ProjectileLoc(String name) {
        return new ResourceLocation("divinerpg:textures/projectiles/" + name + ".png");
    }
}