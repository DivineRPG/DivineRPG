package divinerpg.enums;

import divinerpg.DivineRPG;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

public enum BulletType {
    NONE(0, null),

    //Throwables
    TOMATO_SHOT(.5F, ItemLoc("tomato")),
    SHURIKEN_SHOT(4, ItemLoc("shuriken")),
    VILE_STORM_SHOT(7, ItemLoc("vile_storm"), BulletDamageType.PHYSIC, BulletSpecial.POISON, 2),
    SNOWFLAKE_SHURIKEN_SHOT(7, ItemLoc("snowflake_shuriken"), BulletDamageType.PHYSIC, BulletSpecial.SLOW, 2),
    GRENADE(6, ProjectileLoc("grenade"), BulletDamageType.PHYSIC, BulletSpecial.EXPLODE),
    EDEN_SLICER_SHOT(8, ItemLoc("eden_slicer")),
    WILDWOOD_SLICER_SHOT(10, ItemLoc("wildwood_slicer")),
    APALACHIA_SLICER_SHOT(12, ItemLoc("apalachia_slicer")),
    SKYTHERN_SLICER_SHOT(14, ItemLoc("skythern_slicer")),
    MORTUM_SLICER_SHOT(16, ItemLoc("mortum_slicer")),
    HALITE_SLICER_SHOT(22, ItemLoc("halite_slicer")),

    //Serenades
    SERENADE_OF_DEATH_SHOT(14, ProjectileLoc("serenade_of_death"), BulletDamageType.MAGIC, BulletSpecial.POISON, 2),
    SERENADE_OF_ICE_SHOT(0, ProjectileLoc("serenade_of_ice"), BulletDamageType.NONE, BulletSpecial.SLOW, 5),

    //Anchors
    CRAB_ANCHOR_SHOT(3, ProjectileLoc("crab_anchor")),
    SHARK_ANCHOR_SHOT(4, ProjectileLoc("shark_anchor")),
    BOWHEAD_ANCHOR_SHOT(5, ProjectileLoc("bowhead_anchor")),
    LIOPLEURODON_ANCHOR_SHOT(6, ProjectileLoc("liopleurodon_anchor")),

    //Harps
    SOUND_OF_MUSIC_SHOT(10, ProjectileLoc("sound_of_music"), BulletDamageType.MAGIC, BulletSpecial.MUSIC),
    SOUND_OF_CAROLS_SHOT(16, ProjectileLoc("sound_of_carols"), BulletDamageType.MAGIC, BulletSpecial.MUSIC),
    SOUND_OF_WHALES_SHOT(20, ProjectileLoc("sound_of_whales"), BulletDamageType.MAGIC, BulletSpecial.MUSIC),

    //Extra
    SCYTHE_SHOT(6, ProjectileLoc("scythe"), BulletDamageType.MAGIC),
    MEGA_SCYTHE_SHOT(18, ProjectileLoc("scythe"), BulletDamageType.MAGIC),
    CYCLOPSIAN_STAFF_SHOT(6, ItemLoc("cyclops_eye_shards")),
    MAELSTROM_SHOT(12, ProjectileLoc("maelstrom"), ParticleRegistry.APALACHIA_PORTAL.get(), BulletDamageType.MAGIC),
    ATTRACTOR_SHOT(0, ProjectileLoc("arcana_shot"), BulletDamageType.NONE, BulletSpecial.PULL),
    REFLECTOR_SHOT(0, ProjectileLoc("arcana_shot"), BulletDamageType.NONE, BulletSpecial.PUSH),
    CAPTAINS_SPARKLER_SHOT(20, ProjectileLoc("sparkler"), BulletDamageType.ARCANA, BulletSpecial.RAINBOW),
    GENERALS_STAFF_SHOT(18, ProjectileLoc("generals_staff"), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletDamageType.ARCANA, BulletSpecial.SPLIT),
    GENERALS_STAFF_SPRAY(18, ProjectileLoc("generals_staff"), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletDamageType.ARCANA),

    //Cannons
    CRABCLAW_CANNON_SHOT(12, ProjectileLoc("crab_anchor")),
    FROSTCLAW_CANNON_SHOT(16, ProjectileLoc("frostclaw_cannon")),
    BOWHEAD_CANNON_SHOT(12, ProjectileLoc("bowhead_anchor")),
    FROST_CANNON_SHOT(6, ProjectileLoc("frost_cannon")),
    FRACTITE_CANNON_SHOT(14, ProjectileLoc("fractite_cannon")),
    GHAST_CANNON_SHOT(16, ProjectileLoc("ghast_cannon"), BulletDamageType.MAGIC),
    GOLDEN_FURY_SHOT(30, VanillaItemLoc("gold_nugget")),

    //Shotguns
    ARCANITE_BLASTER(23, ProjectileLoc("blaster_shot"), BulletDamageType.ARCANA),
    CORRUPTED_BULLET(10, ItemLoc("corrupted_bullet")),

    //Blitz
    EDEN_BLITZ_SHOT(10, ProjectileLoc("eden_blitz"), BulletDamageType.PHYSIC, ParticleRegistry.EDEN_PORTAL.get()),
    WILDWOOD_BLITZ_SHOT(12, ProjectileLoc("wildwood_blitz"), BulletDamageType.PHYSIC, ParticleRegistry.WILDWOOD_PORTAL.get()),
    APALACHIA_BLITZ_SHOT(14, ProjectileLoc("apalachia_blitz"), BulletDamageType.PHYSIC, ParticleRegistry.APALACHIA_PORTAL.get()),
    SKYTHERN_BLITZ_SHOT(16, ProjectileLoc("skythern_blitz"), BulletDamageType.PHYSIC, ParticleRegistry.SKYTHERN_PORTAL.get()),
    MORTUM_BLITZ_SHOT(18, ProjectileLoc("mortum_blitz"), BulletDamageType.PHYSIC, ParticleRegistry.MORTUM_PORTAL.get()),
    HALITE_BLITZ_SHOT(20, ProjectileLoc("halite_blitz"), BulletDamageType.PHYSIC, ParticleRegistry.GREEN_PORTAL.get()),

    //Phasers
    EDEN_PHASER_SHOT(14, ProjectileLoc("eden_phaser"), ParticleRegistry.EDEN_PORTAL.get(), BulletDamageType.MAGIC),
    WILDWOOD_PHASER_SHOT(17, ProjectileLoc("wildwood_phaser"), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletDamageType.MAGIC),
    APALACHIA_PHASER_SHOT(20, ProjectileLoc("apalachia_phaser"), ParticleRegistry.APALACHIA_PORTAL.get(), BulletDamageType.MAGIC),
    SKYTHERN_PHASER_SHOT(23, ProjectileLoc("skythern_phaser"), ParticleRegistry.SKYTHERN_PORTAL.get(), BulletDamageType.MAGIC),
    MORTUM_PHASER_SHOT(26, ProjectileLoc("mortum_phaser"), ParticleRegistry.MORTUM_PORTAL.get(), BulletDamageType.MAGIC),
    HALITE_PHASER_SHOT(29, ProjectileLoc("halite_phaser"), ParticleRegistry.GREEN_PORTAL.get(), BulletDamageType.MAGIC),

    //Mob Projectiles
    MAGE_SHOT(10, blank(), 62, 212, 254),
    SPELLBINDER_SHOT(12, blank(),234, 158, 253),
    MYSTIC_SHOT(13, blank(), 234, 223, 228),
    SORCERER_SHOT(14, blank(), 97, 31, 54),

    //Boss Projectiles
    BONE_FRAGMENT(6, ProjectileLoc("bone_fragment")),
    BONE_BOMB(16, ProjectileLoc("bone_bomb")),
    SUNSTORM(12, blank(),255, 235, 0),
    TWILIGHT_DEMON_BLACK_SHOT(16, ProjectileLoc("twilight_demon_shot"),0, 0, 0),
    TWILIGHT_DEMON_RED_SHOT(16, ProjectileLoc("twilight_demon_shot"), 255, 0, 0),
    SOUL_FIEND_SHOT(0, blank()),
    LUNA_SPARKLER(12, blank(), 139, 103, 255, ParticleRegistry.WILDWOOD_PORTAL.get()),

    //Vethea Cannons
    TEAKER_CANNON_SHOT(3, ProjectileLoc("cannon")),
    AMTHIRMIS_CANNON_SHOT(5, ProjectileLoc("cannon")),
    DARVEN_CANNON_SHOT(8, ProjectileLoc("cannon")),
    CERMILE_CANNON_SHOT(12, ProjectileLoc("cannon")),
    PARDIMAL_CANNON_SHOT(15, ProjectileLoc("cannon")),
    QUADROTIC_CANNON_SHOT(19, ProjectileLoc("cannon")),
    KAROS_CANNON_SHOT(21, ProjectileLoc("cannon")),
    HELIOSIS_CANNON_SHOT(28, ProjectileLoc("cannon")),
    ARKSIANE_CANNON_SHOT(36, ProjectileLoc("cannon")),
    EVERSIGHT_SHOT(42, ProjectileLoc("eversight"), BulletDamageType.PHYSIC),

    //Vethea Bouncing Projectiles
    TEAKER_STAFF_SHOT(3, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    AMTHIRMIS_STAFF_SHOT(5, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    DARVEN_STAFF_SHOT(8, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    CERMILE_STAFF_SHOT(12, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    PARDIMAL_STAFF_SHOT(15, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    QUADROTIC_STAFF_SHOT(19, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    KAROS_STAFF_SHOT(21, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    HELIOSIS_STAFF_SHOT(28, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    ARKSIANE_STAFF_SHOT(36, ProjectileLoc("bouncing_projectile"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),
    EVERNIGHT_SHOT(115, ProjectileLoc("evernight"), BulletDamageType.ARCANA, BulletSpecial.BOUNCE),

    //Disks
    TEAKER_DISK(4, ItemLoc("teaker_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    AMTHIRMIS_DISK(6, ItemLoc("amthirmis_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    DARVEN_DISK(9, ItemLoc("darven_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    CERMILE_DISK(13, ItemLoc("cermile_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    PARDIMAL_DISK(16, ItemLoc("pardimal_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    QUADROTIC_DISK(20, ItemLoc("quadrotic_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    KAROS_DISK(22, ItemLoc("karos_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    HELIOSIS_DISK(29, ItemLoc("heliosis_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    ARKSIANE_DISK(37, ItemLoc("arksiane_disk"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),

    //Dissipators
    TEAKER_DISSIPATOR(4, ItemLoc("teaker_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    AMTHIRMIS_DISSIPATOR(6, ItemLoc("amthirmis_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    DARVEN_DISSIPATOR(9, ItemLoc("darven_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    CERMILE_DISSIPATOR(13, ItemLoc("cermile_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    PARDIMAL_DISSIPATOR(16, ItemLoc("pardimal_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    QUADROTIC_DISSIPATOR(20, ItemLoc("quadrotic_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    KAROS_DISSIPATOR(22, ItemLoc("karos_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    HELIOSIS_DISSIPATOR(29, ItemLoc("heliosis_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN),
    ARKSIANE_DISSIPATOR(37, ItemLoc("arksiane_dissipator"), BulletDamageType.PHYSIC, BulletSpecial.RETURN);
    private final BulletSpecial bulletSpecial;
    private final BulletDamageType bulletDamageType;
    private final ResourceLocation texture;
    private final SimpleParticleType particle;
    private final float damage;
    public int effectSec;
    private final int r, g, b;
    BulletType(float damage, ResourceLocation texture, SimpleParticleType particle, BulletDamageType type) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        r = 0;
        g = 0;
        b = 0;
        bulletDamageType = type;
        bulletSpecial = BulletSpecial.NONE;
    }
    BulletType(float damage, ResourceLocation texture, SimpleParticleType particle, BulletDamageType type, BulletSpecial special) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        r = 0;
        g = 0;
        b = 0;
        bulletDamageType = type;
        bulletSpecial = special;
    }
    BulletType(float damage, ResourceLocation texture, BulletDamageType type, SimpleParticleType particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        r = 0;
        g = 0;
        b = 0;
        bulletDamageType = type;
        bulletSpecial = BulletSpecial.NONE;
    }
    BulletType(float damage, ResourceLocation texture, int r, int g, int b) {
        this.damage = damage;
        this.texture = texture;
        particle = null;
        this.r = r;
        this.g = g;
        this.b = b;
        bulletDamageType = BulletDamageType.MAGIC;
        bulletSpecial = BulletSpecial.NONE;
    }
    BulletType(float damage, ResourceLocation texture, int r, int g, int b, SimpleParticleType particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        this.r = r;
        this.g = g;
        this.b = b;
        bulletDamageType = BulletDamageType.ARCANA;
        bulletSpecial = BulletSpecial.NONE;
    }
    BulletType(float damage, ResourceLocation texture, BulletDamageType type) {
        this.damage = damage;
        this.texture = texture;
        particle = null;
        r = 0;
        g = 0;
        b = 0;
        bulletDamageType = type;
        bulletSpecial = BulletSpecial.NONE;
    }
    BulletType(float damage, ResourceLocation texture) {
        this.damage = damage;
        this.texture = texture;
        particle = null;
        r = 0;
        g = 0;
        b = 0;
        bulletDamageType = BulletDamageType.PHYSIC;
        bulletSpecial = BulletSpecial.NONE;
    }
    //Bullets with effect specials
    BulletType(float damage, ResourceLocation texture, BulletDamageType type, BulletSpecial special, int sec) {
        this.damage = damage;
        this.texture = texture;
        particle = null;
        r = 0;
        g = 0;
        b = 0;
        bulletDamageType = type;
        bulletSpecial = special;
        effectSec = sec;
    }
    //Bullets with other specials
    BulletType(float damage, ResourceLocation texture, BulletDamageType type, BulletSpecial special) {
        this.damage = damage;
        this.texture = texture;
        particle = null;
        r = 0;
        g = 0;
        b = 0;
        bulletDamageType = type;
        bulletSpecial = special;
    }
    public static BulletType getBulletFromOrdinal(int ordinal) {
        if (ordinal < 0 || ordinal > values().length) ordinal = 0;
        return values()[ordinal];
    }
    private static ResourceLocation ProjectileLoc(String name) {return new ResourceLocation(DivineRPG.MODID, "textures/projectiles/" + name + ".png");}
    private static ResourceLocation blank() {return new ResourceLocation("minecraft:textures/particle/generic_0.png");}
    public static ResourceLocation ItemLoc(String name) {return new ResourceLocation(DivineRPG.MODID, "textures/item/" + name + ".png");}
    private static ResourceLocation VanillaItemLoc(String name) {return new ResourceLocation("minecraft:textures/item/" + name + ".png");}
    public float getDamage() {return damage;}
    public ResourceLocation getTexture() {return texture;}
    public SimpleParticleType getParticle() {return particle;}
    public int getRed() {return r;}
    public int getGreen() {return g;}
    public int getBlue() {return b;}
    public BulletSpecial getBulletSpecial() {return bulletSpecial;}
    public enum BulletSpecial {NONE, BLIND, BOUNCE, EXPLODE, FLAME, MUSIC, NAUSEA, POISON, PULL, PUSH, RAINBOW, RETURN, SLOW, SPLIT, WITHER}
    public BulletDamageType getBulletDamageType() {return bulletDamageType;}
    public enum BulletDamageType {NONE, PHYSIC, MAGIC, ARCANA}
}