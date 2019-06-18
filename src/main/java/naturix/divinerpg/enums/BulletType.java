package naturix.divinerpg.enums;

import java.awt.Color;

import naturix.divinerpg.utils.DRPGParticleTypes;
import net.minecraft.util.ResourceLocation;

public enum BulletType {
    NONE(0, null),
    FROST_CANNON_SHOT(6, ProjectileLoc("frost_cannon")),
    CYCLOPSIAN_STAFF_SHOT(6, ItemLoc("cyclops_eye_shards")),
    MAELSTROM_SHOT(12, ProjectileLoc("maelstrom")),
    CRAB_ANCHOR_SHOT(3, ProjectileLoc("crab_anchor")),
    SHARK_ANCHOR_SHOT(4, ProjectileLoc("bowhead_anchor")),
    BOWHEAD_ANCHOR_SHOT(5, ProjectileLoc("bowhead_anchor")),
    LIOPLEURODON_ANCHOR_SHOT(6, ProjectileLoc("liopleurodon_anchor")),
    GOLDEN_FURY_SHOT(30, ItemLoc("gold_nugget")),
    GHAST_CANNON_SHOT(16, ProjectileLoc("ghast_cannon")),
    CRABCLAW_CANNON_SHOT(12, ProjectileLoc("crab_anchor")),
    BOWHEAD_CANNON_SHOT(12, ProjectileLoc("bowhead_anchor")),
    FROSTCLAW_CANNON_SHOT(16, ProjectileLoc("frostclaw_cannon")),
    FRACTITE_CANNON_SHOT(14, ProjectileLoc("fractite_cannon")),
    EDEN_BLITZ_SHOT(10, ProjectileLoc("eden_blitz"), DRPGParticleTypes.EDEN_PORTAL),
    WILDWOOD_BLITZ_SHOT(12, ProjectileLoc("wildwood_blitz"), DRPGParticleTypes.WILDWOOD_PORTAL),
    APALACHIA_BLITZ_SHOT(14, ProjectileLoc("apalachia_blitz"), DRPGParticleTypes.APALACHIA_PORTAL),
    SKYTHERN_BLITZ_SHOT(16, ProjectileLoc("skythern_blitz"), DRPGParticleTypes.SKYTHERN_PORTAL),
    MORTUM_BLITZ_SHOT(18, ProjectileLoc("mortum_blitz"), DRPGParticleTypes.MORTUM_PORTAL),
    HALITE_BLITZ_SHOT(20, ProjectileLoc("halite_blitz"), DRPGParticleTypes.GREEN_PORTAL),
    EDEN_PHASER_SHOT(14, ProjectileLoc("eden_phaser"), DRPGParticleTypes.EDEN_PORTAL),
    WILDWOOD_PHASER_SHOT(17, ProjectileLoc("wildwood_phaser"), DRPGParticleTypes.WILDWOOD_PORTAL),
    APALACHIA_PHASER_SHOT(20, ProjectileLoc("apalachia_phaser"), DRPGParticleTypes.APALACHIA_PORTAL),
    SKYTHERN_PHASER_SHOT(23, ProjectileLoc("skythern_phaser"), DRPGParticleTypes.SKYTHERN_PORTAL),
    MORTUM_PHASER_SHOT(26, ProjectileLoc("mortum_phaser"), DRPGParticleTypes.MORTUM_PORTAL),
    HALITE_PHASER_SHOT(29, ProjectileLoc("halite_phaser"), DRPGParticleTypes.GREEN_PORTAL),
    TEAKER_CANNON_SHOT(3, ProjectileLoc("cannon")),
    AMTHIRMIS_CANNON_SHOT(5, ProjectileLoc("cannon")),
    DARVEN_CANNON_SHOT(8, ProjectileLoc("cannon")),
    CERMILE_CANNON_SHOT(12, ProjectileLoc("cannon")),
    PARDINMAL_CANNON_SHOT(15, ProjectileLoc("cannon")),
    QUADROTIC_WAR_CANNON_SHOT(19, ProjectileLoc("cannon")),
    KAROS_WAR_CANNON_SHOT(21, ProjectileLoc("cannon")),
    HALIOSIS_WRATH_CANNON_SHOT(28, ProjectileLoc("cannon")),
    ARKSIANE_WRATH_CANNON_SHOT(36, ProjectileLoc("cannon")),
    EVERSIGHT_SHOT(42, ProjectileLoc("eversight")),
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

    ARCANITE_BLASTER(23, ProjectileLoc("arcanite_blaster")),

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

    BulletType(float damage, ResourceLocation texture, DRPGParticleTypes particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        this.color = null;
    }

    BulletType(float damage, ResourceLocation texture, Color color) {
        this.damage = damage;
        this.texture = texture;
        this.particle = DRPGParticleTypes.NONE;
        this.color = color;
    }

    BulletType(float damage, ResourceLocation texture) {
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

    public static BulletType getBulletFromOrdinal(int ordinal) {
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