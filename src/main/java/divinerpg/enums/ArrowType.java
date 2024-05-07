package divinerpg.enums;

import divinerpg.DivineRPG;
import divinerpg.registries.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public enum ArrowType {
    HUNTER_ARROW(2, ProjectileLoc("hunter_arrow"), Items.ARROW, ArrowSpecial.POISON, 2),
    SHADOW_ARROW(2, ProjectileLoc("shadow_arrow"), Items.ARROW),
    ENDER_ARROW(4, ProjectileLoc("ender_arrow")),
    SOULFIRE_ARROW(2, ProjectileLoc("soulfire_arrow"), ArrowSpecial.EXPLODE),
    INFERNO_ARROW(2, ProjectileLoc("inferno_arrow"), ArrowSpecial.FLAME, 12),
    ICICLE_ARROW(2, ProjectileLoc("icicle_arrow"), Items.ARROW),
    SNOWSTORM_ARROW(2, ProjectileLoc("snowstorm_arrow"), ArrowSpecial.EXPLODE),
    EDEN_ARROW(6, ProjectileLoc("eden_arrow"), ItemRegistry.eden_arrow.get()),
    LESSER_WILDWOOD_ARROW(6, ProjectileLoc("wildwood_arrow"), ItemRegistry.wildwood_arrow.get()),
    GREATER_WILDWOOD_ARROW(10, ProjectileLoc("wildwood_arrow"), ItemRegistry.wildwood_arrow.get()),
    FURY_ARROW(13, ProjectileLoc("fury_arrow"), ItemRegistry.fury_arrow.get()),
    EVERFRIGHT(25, ProjectileLoc("ever_arrow"), ItemRegistry.ever_arrow.get()),
    TEAKER_ARROW(2, ProjectileLoc("teaker_arrow"), ItemRegistry.teaker_arrow.get()),
    AMTHIRMIS_ARROW(2, ProjectileLoc("teaker_arrow"), ItemRegistry.teaker_arrow.get()),
    DARVEN_ARROW(3, ProjectileLoc("darven_arrow"), ItemRegistry.darven_arrow.get()),
    CERMILE_ARROW(4, ProjectileLoc("darven_arrow"), ItemRegistry.darven_arrow.get()),
    PARDIMAL_ARROW(5, ProjectileLoc("pardimal_arrow"), ItemRegistry.pardimal_arrow.get()),
    QUADROTIC_ARROW(6, ProjectileLoc("pardimal_arrow"), ItemRegistry.pardimal_arrow.get()),
    KAROS_ARROW(7, ProjectileLoc("karos_arrow"), ItemRegistry.karos_arrow.get()),
    HELIOSIS_ARROW(8, ProjectileLoc("karos_arrow"), ItemRegistry.karos_arrow.get()),
    ARKSIANE_ARROW(12, ProjectileLoc("karos_arrow"), ItemRegistry.karos_arrow.get()),

    ARID_WARRIOR_ARROW(1.5F, VanillaLoc()),
    WILDFIRE_ARROW(5, ProjectileLoc("inferno_arrow"), ArrowSpecial.FLAME, 6),
    PALE_ARCHER_ARROW(2, ProjectileLoc("snowstorm_arrow")),
    SUN_ARCHER_ARROW(9, ProjectileLoc("eden_arrow")),
    ENCHANTED_ARCHER_ARROW(12, ProjectileLoc("wildwood_arrow")),
    SKYTHERN_ARCHER_ARROW(14, ProjectileLoc("wildwood_arrow")),
    TWILIGHT_ARCHER_ARROW(16, ProjectileLoc("fury_arrow")),
    REYVOR_ARROW(22, ProjectileLoc("fury_arrow")),
    ETERNAL_ARCHER_FLAME_ARROW(26, ProjectileLoc("fury_arrow"), ArrowSpecial.FLAME, 8),
    ETERNAL_ARCHER_WITHER_ARROW(26, ProjectileLoc("fury_arrow"), ArrowSpecial.WITHER, 5),
    ETERNAL_ARCHER_EXPLODE_ARROW(26, ProjectileLoc("fury_arrow"), ArrowSpecial.EXPLODE),
    ETERNAL_ARCHER_SLOW_ARROW(26, ProjectileLoc("fury_arrow"), ArrowSpecial.SLOW, 5),
    ETERNAL_ARCHER_NAUSEA_ARROW(26, ProjectileLoc("fury_arrow"), ArrowSpecial.NAUSEA, 10),
    ETERNAL_ARCHER_BLIND_ARROW(26, ProjectileLoc("fury_arrow"), ArrowSpecial.BLIND, 5),
    LIVING_STATUE_ARROW(6, VanillaLoc());
    private final float baseDamage;
    private final ResourceLocation texture;
    private final ArrowSpecial arrowSpecial;
    private final Item arrowSupplier;
    public int effectSec;
    ArrowType(float baseDamage, ResourceLocation texture) {
        this.baseDamage = baseDamage;
        this.texture = texture;
        arrowSpecial = ArrowSpecial.NONE;
        arrowSupplier = null;
    }
    ArrowType(float baseDamage, ResourceLocation texture, Item ammo) {
        this.baseDamage = baseDamage;
        this.texture = texture;
        arrowSpecial = ArrowSpecial.NONE;
        arrowSupplier = ammo;
    }
    ArrowType(float baseDamage, ResourceLocation texture, ArrowSpecial special) {
        this.baseDamage = baseDamage;
        this.texture = texture;
        arrowSupplier = null;
        arrowSpecial = special;
    }
    ArrowType(float baseDamage, ResourceLocation texture, ArrowSpecial special, int seconds) {
        this.baseDamage = baseDamage;
        this.texture = texture;
        arrowSupplier = null;
        arrowSpecial = special;
        effectSec = seconds;
    }
    ArrowType(float baseDamage, ResourceLocation texture, Item ammo, ArrowSpecial special, int seconds) {
        this.baseDamage = baseDamage;
        this.texture = texture;
        arrowSupplier = ammo;
        arrowSpecial = special;
        effectSec = seconds;
    }
    public static ArrowType getArrowFromId(int ordinal) {
        if(ordinal < 0 || ordinal > values().length) ordinal = 0;
        return values()[ordinal];
    }
    private static ResourceLocation ProjectileLoc(String name) {return new ResourceLocation(DivineRPG.MODID, "textures/projectiles/" + name + ".png");}
    private static ResourceLocation VanillaLoc() {return new ResourceLocation("textures/entity/projectiles/arrow.png");}
    public float getBaseDamage() {return baseDamage;}
    public ResourceLocation getTexture() {return texture;}
    public ArrowSpecial getArrowSpecial() {return arrowSpecial;}
    public enum ArrowSpecial {NONE, FLAME, WITHER, EXPLODE, SLOW, NAUSEA, BLIND, POISON}
    public Item getArrowSupplier() {return arrowSupplier;}
}