package naturix.divinerpg.enums;

import java.awt.Color;

import naturix.divinerpg.utils.DRPGParticleTypes;
import net.minecraft.util.ResourceLocation;

public enum BulletType {
    NONE(0, 0, null),
    FROST_CANNON_SHOT(1, 6, ProjectileLoc("frost_cannon")),
    CYCLOPSIAN_STAFF_SHOT(2, 6, ItemLoc("cyclops_eye_shards")),
    MAELSTROM_SHOT(3, 12, ProjectileLoc("maelstrom")),
    CRAB_ANCHOR_SHOT(4, 3, ProjectileLoc("crab_anchor")),
    SHARK_ANCHOR_SHOT(5, 4, ProjectileLoc("bowhead_anchor")),
    BOWHEAD_ANCHOR_SHOT(6, 5, ProjectileLoc("bowhead_anchor")),
    LIOPLEURODON_ANCHOR_SHOT(7, 6, ProjectileLoc("lioleurodon_anchor")),
    GOLDEN_FURY_SHOT(8, 30, ItemLoc("gold_nugget")),
    GHAST_CANNON_SHOT(9, 16, ProjectileLoc("ghast_cannon")),
    CRABCLAW_CANNON_SHOT(10, 12, ProjectileLoc("crab_anchor")),
    BOWHEAD_CANNON_SHOT(11, 12, ProjectileLoc("bowhead_anchor")),
    FROSTCLAW_CANNON_SHOT(12, 16, ProjectileLoc("frostclaw_cannon")),
    FRACTITE_CANNON_SHOT(13, 14, ProjectileLoc("fractite_cannon")),
    EDEN_BLITZ_SHOT(14, 10, ProjectileLoc("eden_blitz"), DRPGParticleTypes.EDEN_PORTAL),
    WILDWOOD_BLITZ_SHOT(15, 12, ProjectileLoc("wildwood_blitz"), DRPGParticleTypes.WILDWOOD_PORTAL),
    APALACHIA_BLITZ_SHOT(16, 14, ProjectileLoc("apalachia_blitz"), DRPGParticleTypes.APALACHIA_PORTAL),
    SKYTHERN_BLITZ_SHOT(17, 16, ProjectileLoc("skythern_blitz"), DRPGParticleTypes.SKYTHERN_PORTAL),
    MORTUM_BLITZ_SHOT(18, 18, ProjectileLoc("mortum_blitz"), DRPGParticleTypes.MORTUM_PORTAL),
    HALITE_BLITZ_SHOT(19, 20, ProjectileLoc("halite_blitz"), DRPGParticleTypes.GREEN_PORTAL),
    EDEN_PHASER_SHOT(20, 14, ProjectileLoc("eden_phaser"), DRPGParticleTypes.EDEN_PORTAL),
    WILDWOOD_PHASER_SHOT(21, 17, ProjectileLoc("wildwood_phaser"), DRPGParticleTypes.WILDWOOD_PORTAL),
    APALACHIA_PHASER_SHOT(22, 20, ProjectileLoc("apalachia_phaser"), DRPGParticleTypes.APALACHIA_PORTAL),
    SKYTHERN_PHASER_SHOT(23, 23, ProjectileLoc("skythern_phaser"), DRPGParticleTypes.SKYTHERN_PORTAL),
    MORTUM_PHASER_SHOT(24, 26, ProjectileLoc("mortum_phaser"), DRPGParticleTypes.MORTUM_PORTAL),
    HALITE_PHASER_SHOT(25, 29, ProjectileLoc("halite_phaser"), DRPGParticleTypes.GREEN_PORTAL),
    TEAKER_CANNON_SHOT(26, 3, ProjectileLoc("cannon")),
    AMTHIRMIS_CANNON_SHOT(27, 5, ProjectileLoc("cannon")),
    DARVEN_CANNON_SHOT(28, 8, ProjectileLoc("cannon")),
    CERMILE_CANNON_SHOT(29, 12, ProjectileLoc("cannon")),
    PARDINMAL_CANNON_SHOT(30, 15, ProjectileLoc("cannon")),
    QUADROTIC_WAR_CANNON_SHOT(31, 19, ProjectileLoc("cannon")),
    KAROS_WAR_CANNON_SHOT(32, 21, ProjectileLoc("cannon")),
    HALIOSIS_WRATH_CANNON_SHOT(33, 28, ProjectileLoc("cannon")),
    ARKSIANE_WRATH_CANNON_SHOT(34, 36, ProjectileLoc("cannon")),
    EVERSIGHT_SHOT(35, 42, ProjectileLoc("eversight")),
    SCYTHE_SHOT(36, 6, ProjectileLoc("scythe")),
    MEGA_SCYTHE_SHOT(37, 18, ProjectileLoc("scythe")),
    SHURIKEN_SHOT(38, 4, ItemLoc("shuriken")),
    SNOWFLAKE_SHURIKEN_SHOT(39, 7, ItemLoc("snowflake_shuriken"));

    private final int id;
    private final float damage;
    private final ResourceLocation texture;
    private final DRPGParticleTypes particle;
    private final Color color;

    BulletType(int id, float damage, ResourceLocation texture, DRPGParticleTypes particle) {
        this.id = id;
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        this.color = null;
    }

    BulletType(int id, float damage, ResourceLocation texture, Color color) {
        this.id = id;
        this.damage = damage;
        this.texture = texture;
        this.particle = DRPGParticleTypes.NONE;
        this.color = color;
    }

    BulletType(int id, float damage, ResourceLocation texture) {
        this.id = id;
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

    public int getBulletId() {
        return this.id;
    }

    public static BulletType getBulletFromId(int id) {
        for (BulletType bullet : BulletType.values()) {
            if (bullet.getBulletId() == id) {
                return bullet;
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