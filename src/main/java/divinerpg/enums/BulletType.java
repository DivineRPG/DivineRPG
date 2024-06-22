package divinerpg.enums;

import divinerpg.DivineRPG;
import divinerpg.registries.ParticleRegistry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

public enum BulletType {
    //Throwables
    TOMATO_SHOT(.5F, ItemLoc("tomato")),
    SHURIKEN_SHOT(4, ItemLoc("shuriken")),
    VILE_STORM_SHOT(7, ItemLoc("vile_storm"), BulletDamageType.PHYSIC, BulletSpecial.POISON, 3, 2),
    SNOWFLAKE_SHURIKEN_SHOT(7, ItemLoc("snowflake_shuriken"), BulletDamageType.PHYSIC, BulletSpecial.SLOW, 3, 2),
    GRENADE(6, ProjectileLoc("grenade"), BulletDamageType.PHYSIC, BulletSpecial.EXPLODE, 3, 0),
    EDEN_SLICER_SHOT(8, ItemLoc("eden_slicer")),
    WILDWOOD_SLICER_SHOT(10, ItemLoc("wildwood_slicer")),
    APALACHIA_SLICER_SHOT(12, ItemLoc("apalachia_slicer")),
    SKYTHERN_SLICER_SHOT(14, ItemLoc("skythern_slicer")),
    MORTUM_SLICER_SHOT(16, ItemLoc("mortum_slicer")),
    HALITE_SLICER_SHOT(18, ItemLoc("halite_slicer")),

    //Serenades
    SERENADE_OF_DEATH_SHOT(7, ProjectileLoc("serenade_of_death"), BulletDamageType.MAGIC, BulletSpecial.POISON, 3, 2),
    SERENADE_OF_ICE_SHOT(0, ProjectileLoc("serenade_of_ice"), BulletDamageType.NONE, BulletSpecial.SLOW, 3, 5),

    //Anchors
    CRAB_ANCHOR_SHOT(3, ProjectileLoc("crab_anchor")),
    SHARK_ANCHOR_SHOT(4, ProjectileLoc("shark_anchor")),
    BOWHEAD_ANCHOR_SHOT(5, ProjectileLoc("bowhead_anchor")),
    LIOPLEURODON_ANCHOR_SHOT(6, ProjectileLoc("liopleurodon_anchor")),

    //Harps
    SOUND_OF_MUSIC_SHOT(9, ProjectileLoc("sound_of_music"), BulletDamageType.MAGIC, BulletSpecial.MUSIC),
    SOUND_OF_CAROLS_SHOT(11, ProjectileLoc("sound_of_carols"), BulletDamageType.MAGIC, BulletSpecial.MUSIC),
    SOUND_OF_WHALES_SHOT(13, ProjectileLoc("sound_of_whales"), BulletDamageType.MAGIC, BulletSpecial.MUSIC),

    //Extra
    SCYTHE_SHOT(6, ProjectileLoc("scythe"), BulletDamageType.MAGIC),
    MEGA_SCYTHE_SHOT(18, ProjectileLoc("scythe"), BulletDamageType.MAGIC),
    CYCLOPSIAN_STAFF_SHOT(3, ItemLoc("cyclops_eye_shards")),
    MAELSTROM_SHOT(12, ProjectileLoc("maelstrom"), ParticleRegistry.APALACHIA_PORTAL.get(), BulletDamageType.MAGIC),
    ATTRACTOR_SHOT(0, ProjectileLoc("arcana_shot"), BulletDamageType.NONE, BulletSpecial.PULL),
    REFLECTOR_SHOT(0, ProjectileLoc("arcana_shot"), BulletDamageType.NONE, BulletSpecial.PUSH),
    CAPTAINS_SPARKLER_SHOT(13, ProjectileLoc("sparkler"), BulletDamageType.ARCANA, BulletSpecial.RAINBOW),
    GENERALS_STAFF_SPRAY(13, ProjectileLoc("generals_staff"), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletSpecial.NONE),
    GENERALS_STAFF_SHOT(13, ProjectileLoc("generals_staff"), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletType.GENERALS_STAFF_SPRAY, 4),
    STAR(13, ProjectileLoc("starlight"), ParticleRegistry.EDEN_PORTAL.get(), BulletSpecial.SKY),
    METEOR(15, ProjectileLoc("meteor"), ParticleRegistry.MORTUM_PORTAL.get(), BulletSpecial.SKY),

    //Cannons
    CRABCLAW_CANNON_SHOT(4, ProjectileLoc("crab_anchor")),
    FROSTCLAW_CANNON_SHOT(7, ProjectileLoc("frostclaw_cannon")),
    BOWHEAD_CANNON_SHOT(6, ProjectileLoc("bowhead_anchor")),
    FROST_CANNON_SHOT(6, ProjectileLoc("frost_cannon")),
    FRACTITE_CANNON_SHOT(8, ProjectileLoc("fractite_cannon")),
    GHAST_CANNON_SHOT(11, ProjectileLoc("ghast_cannon"), BulletDamageType.MAGIC),
    GOLDEN_FURY_SHOT(17, VanillaItemLoc("gold_nugget")),

    //Shotguns
    ARCANITE_BLASTER(13, ProjectileLoc("blaster_shot"), BulletDamageType.ARCANA),
    CORRUPTED_BULLET(10, ItemLoc("corrupted_bullet")),

    //Blitz
    EDEN_BLITZ_SHOT(10, ProjectileLoc("eden_blitz"), ParticleRegistry.EDEN_PORTAL.get(), BulletDamageType.PHYSIC),
    WILDWOOD_BLITZ_SHOT(12, ProjectileLoc("wildwood_blitz"), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletDamageType.PHYSIC),
    APALACHIA_BLITZ_SHOT(14, ProjectileLoc("apalachia_blitz"), ParticleRegistry.APALACHIA_PORTAL.get(), BulletDamageType.PHYSIC),
    SKYTHERN_BLITZ_SHOT(16, ProjectileLoc("skythern_blitz"), ParticleRegistry.SKYTHERN_PORTAL.get(), BulletDamageType.PHYSIC),
    MORTUM_BLITZ_SHOT(18, ProjectileLoc("mortum_blitz"), ParticleRegistry.MORTUM_PORTAL.get(), BulletDamageType.PHYSIC),
    HALITE_BLITZ_SHOT(20, ProjectileLoc("halite_blitz"), ParticleRegistry.HALITE_PORTAL.get(), BulletDamageType.PHYSIC),

    //Phasers
    EDEN_PHASER_SHOT(8, ProjectileLoc("eden_phaser"), ParticleRegistry.EDEN_PORTAL.get(), BulletDamageType.MAGIC),
    WILDWOOD_PHASER_SHOT(10, ProjectileLoc("wildwood_phaser"), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletDamageType.MAGIC),
    APALACHIA_PHASER_SHOT(12, ProjectileLoc("apalachia_phaser"), ParticleRegistry.APALACHIA_PORTAL.get(), BulletDamageType.MAGIC),
    SKYTHERN_PHASER_SHOT(14, ProjectileLoc("skythern_phaser"), ParticleRegistry.SKYTHERN_PORTAL.get(), BulletDamageType.MAGIC),
    MORTUM_PHASER_SHOT(16, ProjectileLoc("mortum_phaser"), ParticleRegistry.MORTUM_PORTAL.get(), BulletDamageType.MAGIC),
    HALITE_PHASER_SHOT(18, ProjectileLoc("halite_phaser"), ParticleRegistry.HALITE_PORTAL.get(), BulletDamageType.MAGIC),

    //Mob Projectiles
    CAVE_ROCK(6, ProjectileLoc("cave_rock"), BulletDamageType.PHYSIC),
    //TODO: to change damage type to Magic for mages (etc.) after we add proper damage reduction for armors
    WEAK_CORI_SHOT(20, ProjectileLoc("cori_shot"), BulletDamageType.PHYSIC),
    MAGE_SHOT(10, blank(), ParticleRegistry.WILDWOOD_PORTAL.get(), BulletDamageType.PHYSIC),
    SPELLBINDER_SHOT(12, blank(), ParticleRegistry.APALACHIA_PORTAL.get(), BulletDamageType.PHYSIC),
    ADVANCED_CORI_SHOT(30, ProjectileLoc("cori_shot"), BulletDamageType.PHYSIC),
    MYSTIC_SHOT(13, blank(), ParticleRegistry.SKYTHERN_PORTAL.get(), BulletDamageType.PHYSIC),
    SORCERER_SHOT(14, blank(), ParticleRegistry.MORTUM_PORTAL.get(), BulletDamageType.PHYSIC),
    MANDRAGORA_SHOT(4, ProjectileLoc("mandragora_projectile"), BulletDamageType.PHYSIC),
    KAZROTIC_SHOT(0, ProjectileLoc("kazrotic_shot"), BulletDamageType.NONE, BulletSpecial.MOB_EXPLODE, 3, 0),
    ZORAGON_BOMB(0, ProjectileLoc("zoragon_bomb"), BulletDamageType.NONE, BulletSpecial.MOB_EXPLODE, 3, 0),

    //Boss Projectiles
    THE_WATCHER_SHOT(4, ProjectileLoc("watcher_shot"), BulletDamageType.PHYSIC, BulletSpecial.MOB_EXPLODE, 5, 0),
    KING_OF_SCORCHERS_SHOT(14, ProjectileLoc("king_of_scorchers_shot"), BulletDamageType.NONE, BulletSpecial.FLAME, 0, 8),
    KING_OF_SCORCHERS_METEOR(0, ProjectileLoc("king_of_scorchers_meteor"), BulletDamageType.NONE, BulletSpecial.MOB_EXPLODE, 3, 0),
    BONE_FRAGMENT(6, ProjectileLoc("bone_fragment")),
    BONE_BOMB(16, ProjectileLoc("bone_bomb")),
    SUNSTORM(12, blank(), ParticleRegistry.EDEN_PORTAL.get(), BulletDamageType.PHYSIC),
    EXPERIENCED_CORI_SHOT(80, ProjectileLoc("cori_shot"), BulletDamageType.PHYSIC),
    TWILIGHT_DEMON_BLACK_SHOT(16, ProjectileLoc("twilight_demon_shot"), ParticleRegistry.MORTUM_PORTAL.get(), BulletDamageType.PHYSIC),
    TWILIGHT_DEMON_RED_SHOT(16, ProjectileLoc("twilight_demon_shot"), ParticleRegistry.TWILIGHT_PORTAL.get(), BulletDamageType.PHYSIC),
    SOUL_FIEND_SHOT(0, blank(), BulletDamageType.NONE),
    KAROS_BOMB(0, ProjectileLoc("zoragon_bomb"), BulletDamageType.NONE, BulletSpecial.EXPLODE, 3, 0),
    LUNA_SPARKLER(12, blank(), ParticleRegistry.APALACHIA_PORTAL.get(), BulletDamageType.PHYSIC),
    RAGLOK_BOMB(0, ProjectileLoc("raglok_bomb"), BulletDamageType.NONE, BulletSpecial.MOB_EXPLODE, 3, 0),
    WRECK_SHOT(15, ProjectileLoc("wreck_shot"), BulletDamageType.PHYSIC),
    WRECK_STRONG_SHOT(40, ProjectileLoc("wreck_shot"), BulletDamageType.PHYSIC),
    WRECK_BOUNCING_SHOT(35, ProjectileLoc("wreck_bouncing_projectile"), BulletDamageType.PHYSIC, BulletSpecial.BOUNCE),
    WRECK_EXPLOSIVE_SHOT(0, ProjectileLoc("wreck_explosive_projectile"), BulletDamageType.NONE, BulletSpecial.MOB_EXPLODE, 3, 0),

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
    private SimpleParticleType particle;
    public BulletType sprayBullet;
    private final float damage;
    public int effectPower;
    public int effectSec;
    //Generic bullets
    BulletType(float damage, ResourceLocation texture) {
        this.damage = damage;
        this.texture = texture;
        bulletDamageType = BulletDamageType.PHYSIC;
        bulletSpecial = BulletSpecial.NONE;
    }
    //Generic bullets with a different damage type
    BulletType(float damage, ResourceLocation texture, BulletDamageType type) {
        this.damage = damage;
        this.texture = texture;
        bulletDamageType = type;
        bulletSpecial = BulletSpecial.NONE;
    }
    //Generic bullets + have particles
    BulletType(float damage, ResourceLocation texture, SimpleParticleType particle, BulletDamageType type) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        bulletDamageType = type;
        bulletSpecial = BulletSpecial.NONE;
    }
    //Bullets with effect/explosive specials
    BulletType(float damage, ResourceLocation texture, BulletDamageType type, BulletSpecial special, int power, int sec) {
        this.damage = damage;
        this.texture = texture;
        bulletDamageType = type;
        bulletSpecial = special;
        effectPower = power;
        effectSec = sec;
    }
    //Bullets with other specials
    BulletType(float damage, ResourceLocation texture, BulletDamageType type, BulletSpecial special) {
        this.damage = damage;
        this.texture = texture;
        bulletDamageType = type;
        bulletSpecial = special;
    }
    //Bullets with other specials + have particles
    BulletType(float damage, ResourceLocation texture, SimpleParticleType particle, BulletSpecial special) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        bulletDamageType = BulletDamageType.ARCANA;
        bulletSpecial = special;
    }
    //Split projectiles
    BulletType(float damage, ResourceLocation texture, SimpleParticleType particle, BulletType type, int amount) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        bulletDamageType = BulletDamageType.ARCANA;
        bulletSpecial = BulletSpecial.SPLIT;
        sprayBullet = type;
        effectPower = amount;
    }
    public static BulletType getBulletFromOrdinal(int ordinal) {
        if(ordinal < 0 || ordinal > values().length) ordinal = 0;
        return values()[ordinal];
    }
    private static ResourceLocation ProjectileLoc(String name) {return new ResourceLocation(DivineRPG.MODID, "textures/projectiles/" + name + ".png");}
    //TODO: to fix, for some reason blank textures are a 1x1 white square
    private static ResourceLocation blank() {return new ResourceLocation("minecraft:textures/particle/generic_0.png");}
    public static ResourceLocation ItemLoc(String name) {return new ResourceLocation(DivineRPG.MODID, "textures/item/" + name + ".png");}
    private static ResourceLocation VanillaItemLoc(String name) {return new ResourceLocation("minecraft:textures/item/" + name + ".png");}
    public float getDamage() {return damage;}
    public ResourceLocation getTexture() {return texture;}
    public SimpleParticleType getParticle() {return particle;}
    public BulletSpecial getBulletSpecial() {return bulletSpecial;}
    public enum BulletSpecial {NONE, BLIND, BOUNCE, EXPLODE, MOB_EXPLODE, FLAME, MUSIC, NAUSEA, POISON, PULL, PUSH, RAINBOW, RETURN, SKY, SLOW, SPLIT, WITHER}
    public BulletDamageType getBulletDamageType() {return bulletDamageType;}
    public enum BulletDamageType {NONE, PHYSIC, MAGIC, ARCANA}
}