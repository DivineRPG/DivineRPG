package divinerpg.enums;

import divinerpg.*;
import net.minecraft.particles.*;
import net.minecraft.util.*;

import java.awt.*;

public enum BulletType {
    NONE(0, null),
    FROST_CANNON_SHOT(6, ProjectileLoc("frost_cannon")),
    CYCLOPSIAN_STAFF_SHOT(6, ItemLoc("cyclops_eye_shards")),
    MAELSTROM_SHOT(12, ProjectileLoc("maelstrom")),
    CRAB_ANCHOR_SHOT(3, ProjectileLoc("crab_anchor")),
    SHARK_ANCHOR_SHOT(4, ProjectileLoc("bowhead_anchor")),
    BOWHEAD_ANCHOR_SHOT(5, ProjectileLoc("bowhead_anchor")),
    LIOPLEURODON_ANCHOR_SHOT(6, ProjectileLoc("liopleurodon_anchor")),
    GOLDEN_FURY_SHOT(30, VanillaItemLoc("gold_nugget")),
    GHAST_CANNON_SHOT(16, ProjectileLoc("ghast_cannon")),
    CRABCLAW_CANNON_SHOT(12, ProjectileLoc("crab_anchor")),
    BOWHEAD_CANNON_SHOT(12, ProjectileLoc("bowhead_anchor")),
    FROSTCLAW_CANNON_SHOT(16, ProjectileLoc("frostclaw_cannon")),
    FRACTITE_CANNON_SHOT(14, ProjectileLoc("fractite_cannon")),

//    EDEN_BLITZ_SHOT(10, ProjectileLoc("eden_blitz"), ParticleRegistry.EDEN_PORTAL.get()),
//    WILDWOOD_BLITZ_SHOT(12, ProjectileLoc("wildwood_blitz"), ParticleRegistry.WILDWOOD_PORTAL.get()),
//    APALACHIA_BLITZ_SHOT(14, ProjectileLoc("apalachia_blitz"), ParticleRegistry.APALACHIA_PORTAL.get()),
//    SKYTHERN_BLITZ_SHOT(16, ProjectileLoc("skythern_blitz"), ParticleRegistry.SKYTHERN_PORTAL.get()),
//    MORTUM_BLITZ_SHOT(18, ProjectileLoc("mortum_blitz"), ParticleRegistry.MORTUM_PORTAL.get()),
//    HALITE_BLITZ_SHOT(20, ProjectileLoc("halite_blitz"), ParticleRegistry.GREEN_PORTAL.get()),
//    EDEN_PHASER_SHOT(14, ProjectileLoc("eden_phaser"), ParticleRegistry.EDEN_PORTAL.get()),
//    WILDWOOD_PHASER_SHOT(17, ProjectileLoc("wildwood_phaser"), ParticleRegistry.WILDWOOD_PORTAL.get()),
//    APALACHIA_PHASER_SHOT(20, ProjectileLoc("apalachia_phaser"), ParticleRegistry.APALACHIA_PORTAL.get()),
//    SKYTHERN_PHASER_SHOT(23, ProjectileLoc("skythern_phaser"), ParticleRegistry.SKYTHERN_PORTAL.get()),
//    MORTUM_PHASER_SHOT(26, ProjectileLoc("mortum_phaser"), ParticleRegistry.MORTUM_PORTAL.get()),
//    HALITE_PHASER_SHOT(29, ProjectileLoc("halite_phaser"), ParticleRegistry.GREEN_PORTAL.get()),

    EDEN_BLITZ_SHOT(10, ProjectileLoc("eden_blitz"), ParticleTypes.BUBBLE),
    WILDWOOD_BLITZ_SHOT(12, ProjectileLoc("wildwood_blitz"), ParticleTypes.BUBBLE),
    APALACHIA_BLITZ_SHOT(14, ProjectileLoc("apalachia_blitz"), ParticleTypes.BUBBLE),
    SKYTHERN_BLITZ_SHOT(16, ProjectileLoc("skythern_blitz"), ParticleTypes.BUBBLE),
    MORTUM_BLITZ_SHOT(18, ProjectileLoc("mortum_blitz"), ParticleTypes.BUBBLE),
    HALITE_BLITZ_SHOT(20, ProjectileLoc("halite_blitz"), ParticleTypes.BUBBLE),
    EDEN_PHASER_SHOT(14, ProjectileLoc("eden_phaser"), ParticleTypes.BUBBLE),
    WILDWOOD_PHASER_SHOT(17, ProjectileLoc("wildwood_phaser"), ParticleTypes.BUBBLE),
    APALACHIA_PHASER_SHOT(20, ProjectileLoc("apalachia_phaser"), ParticleTypes.BUBBLE),
    SKYTHERN_PHASER_SHOT(23, ProjectileLoc("skythern_phaser"), ParticleTypes.BUBBLE),
    MORTUM_PHASER_SHOT(26, ProjectileLoc("mortum_phaser"), ParticleTypes.BUBBLE),
    HALITE_PHASER_SHOT(29, ProjectileLoc("halite_phaser"), ParticleTypes.BUBBLE),

    SCYTHE_SHOT(6, ProjectileLoc("scythe")),
    MEGA_SCYTHE_SHOT(18, ProjectileLoc("scythe")),
    SHURIKEN_SHOT(4, ItemLoc("shuriken")),
    SNOWFLAKE_SHURIKEN_SHOT(7, ItemLoc("snowflake_shuriken")),
    EDEN_SLICER_SHOT(8, ItemLoc("eden_slicer")),
    WILDWOOD_SLICER_SHOT(10, ItemLoc("wildwood_slicer")),
    APALACHIA_SLICER_SHOT(12, ItemLoc("apalachia_slicer")),
    SKYTHERN_SLICER_SHOT(14, ItemLoc("skythern_slicer")),
    MORTUM_SLICER_SHOT(16, ItemLoc("mortum_slicer")),
    HALITE_SLICER_SHOT(22, ItemLoc("halite_slicer")),

    ARCANITE_BLASTER(23, ProjectileLoc("blaster_shot")),
    GENERALS_STAFF_SHOT(18, ProjectileLoc("generals_staff"), new Color(31, 93, 210)),
    GENERALS_STAFF_SPRAY(18, ProjectileLoc("generals_staff"), new Color(56, 152, 186)),

    MAGE_SHOT(5, ProjectileLoc("blank"), new Color(62, 212, 254)),
    SPELLBINDER_SHOT(7, ProjectileLoc("blank"), new Color(234, 158, 253)),
    MYSTIC_SHOT(10, ProjectileLoc("blank"), new Color(234, 223, 228)),
    SORCERER_SHOT(12, ProjectileLoc("blank"), new Color(97, 31, 54)),
    TWILIGHT_DEMON_BLACK_SHOT(16, ProjectileLoc("twilight_demon_shot"), new Color(0, 0, 0)),
    TWILIGHT_DEMON_RED_SHOT(16, ProjectileLoc("twilight_demon_shot"), new Color(255, 0, 0)),
    SOUL_FIEND_SHOT(0, ProjectileLoc("blank")),
    SUNSTORM(12, ProjectileLoc("blank"), new Color(255, 235, 0)),
    
    
    TEAKER_CANNON_SHOT(3, ProjectileLoc("cannon")),
    AMTHIRMIS_CANNON_SHOT(5, ProjectileLoc("cannon")),
    DARVEN_CANNON_SHOT(8, ProjectileLoc("cannon")),
    CERMILE_CANNON_SHOT(12, ProjectileLoc("cannon")),
    PARDIMAL_CANNON_SHOT(15, ProjectileLoc("cannon")),
    QUADROTIC_CANNON_SHOT(19, ProjectileLoc("cannon")),
    KAROS_CANNON_SHOT(21, ProjectileLoc("cannon")),
    HELIOSIS_CANNON_SHOT(28, ProjectileLoc("cannon")),
    ARKSIANE_CANNON_SHOT(36, ProjectileLoc("cannon")),
    EVERSIGHT_SHOT(42, ProjectileLoc("cannon")),

//    LUNA_SPARKLER(12, ProjectileLoc("blank"), new Color(139, 103, 255), ParticleRegistry.WILDWOOD_PORTAL.get());
    LUNA_SPARKLER(12, ProjectileLoc("blank"), new Color(139, 103, 255), ParticleTypes.BUBBLE);

    private final float damage;
    private final ResourceLocation texture;
    private final BasicParticleType particle;
    private final Color color;

    BulletType(float damage, ResourceLocation texture, BasicParticleType particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        this.color = null;
    }

    BulletType(float damage, ResourceLocation texture, Color color) {
        this.damage = damage;
        this.texture = texture;
        this.particle = null;
        this.color = color;
    }

    BulletType(float damage, ResourceLocation texture, Color color, BasicParticleType particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        this.color = color;
    }

    BulletType(float damage, ResourceLocation texture) {
        this.damage = damage;
        this.texture = texture;
        this.particle = null;
        this.color = null;
    }

    public float getDamage() {
        return this.damage;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }

    public BasicParticleType getParticle() {
        return this.particle;
    }

    public Color getColor() {
        return this.color;
    }

    public static BulletType getBulletFromOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) {
            ordinal = 0;
        }
        return values()[ordinal];
    }

    private static ResourceLocation ProjectileLoc(String name) {
        return new ResourceLocation(DivineRPG.MODID, "textures/projectiles/" + name + ".png");
    }

    private static ResourceLocation ItemLoc(String name) {
        return new ResourceLocation(DivineRPG.MODID, "textures/items/" + name + ".png");
    }

    private static ResourceLocation VanillaItemLoc(String name) {
        return new ResourceLocation("minecraft:textures/items/" + name + ".png");
    }


}