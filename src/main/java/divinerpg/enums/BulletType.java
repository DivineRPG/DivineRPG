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
    VILE_STORM_SHOT(7, ItemLoc("vile_storm")),
    SNOWFLAKE_SHURIKEN_SHOT(7, ItemLoc("snowflake_shuriken")),
    GRENADE(6, ItemLoc("grenade")),
    EDEN_SLICER_SHOT(8, ItemLoc("eden_slicer")),
    WILDWOOD_SLICER_SHOT(10, ItemLoc("wildwood_slicer")),
    APALACHIA_SLICER_SHOT(12, ItemLoc("apalachia_slicer")),
    SKYTHERN_SLICER_SHOT(14, ItemLoc("skythern_slicer")),
    MORTUM_SLICER_SHOT(16, ItemLoc("mortum_slicer")),
    HALITE_SLICER_SHOT(22, ItemLoc("halite_slicer")),

    //Anchors
    CRAB_ANCHOR_SHOT(3, ProjectileLoc("crab_anchor")),
    SHARK_ANCHOR_SHOT(4, ProjectileLoc("shark_anchor")),
    BOWHEAD_ANCHOR_SHOT(5, ProjectileLoc("bowhead_anchor")),
    LIOPLEURODON_ANCHOR_SHOT(6, ProjectileLoc("liopleurodon_anchor")),

    //Harps
    SOUND_OF_MUSIC_SHOT(10, ProjectileLoc("sound_of_music")),
    SOUND_OF_CAROLS_SHOT(16, ProjectileLoc("sound_of_carols")),
    SOUND_OF_WHALES_SHOT(20, ProjectileLoc("sound_of_whales")),

    //Other projectiles
    SERENADE_OF_DEATH_SHOT(14, ProjectileLoc("serenade_of_death")),
    SCYTHE_SHOT(6, ProjectileLoc("scythe")),
    MEGA_SCYTHE_SHOT(18, ProjectileLoc("scythe")),
    CYCLOPSIAN_STAFF_SHOT(6, ItemLoc("cyclops_eye_shards")),
    CRABCLAW_CANNON_SHOT(12, ProjectileLoc("crab_anchor")),
    FROSTCLAW_CANNON_SHOT(16, ProjectileLoc("frostclaw_cannon")),
    BOWHEAD_CANNON_SHOT(12, ProjectileLoc("bowhead_anchor")),
    FROST_CANNON_SHOT(6, ProjectileLoc("frost_cannon")),
    FRACTITE_CANNON_SHOT(14, ProjectileLoc("fractite_cannon")),
    MAELSTROM_SHOT(12, ProjectileLoc("maelstrom")),
    GHAST_CANNON_SHOT(16, ProjectileLoc("ghast_cannon")),
    GOLDEN_FURY_SHOT(30, VanillaItemLoc("gold_nugget")),
    CAPTAINS_SPARKLER_SHOT(20, ProjectileLoc("sparkler")),
    ARCANITE_BLASTER(23, ProjectileLoc("blaster_shot")),
    GENERALS_STAFF_SHOT(18, ProjectileLoc("generals_staff"), 31, 93, 210),
    GENERALS_STAFF_SPRAY(18, ProjectileLoc("generals_staff"), 56, 152, 186),

    //Blitz
    EDEN_BLITZ_SHOT(10, ProjectileLoc("eden_blitz"), ParticleRegistry.EDEN_PORTAL.get()),
    WILDWOOD_BLITZ_SHOT(12, ProjectileLoc("wildwood_blitz"), ParticleRegistry.WILDWOOD_PORTAL.get()),
    APALACHIA_BLITZ_SHOT(14, ProjectileLoc("apalachia_blitz"), ParticleRegistry.APALACHIA_PORTAL.get()),
    SKYTHERN_BLITZ_SHOT(16, ProjectileLoc("skythern_blitz"), ParticleRegistry.SKYTHERN_PORTAL.get()),
    MORTUM_BLITZ_SHOT(18, ProjectileLoc("mortum_blitz"), ParticleRegistry.MORTUM_PORTAL.get()),
    HALITE_BLITZ_SHOT(20, ProjectileLoc("halite_blitz"), ParticleRegistry.GREEN_PORTAL.get()),

    //Phasers
    EDEN_PHASER_SHOT(14, ProjectileLoc("eden_phaser"), ParticleRegistry.EDEN_PORTAL.get()),
    WILDWOOD_PHASER_SHOT(17, ProjectileLoc("wildwood_phaser"), ParticleRegistry.WILDWOOD_PORTAL.get()),
    APALACHIA_PHASER_SHOT(20, ProjectileLoc("apalachia_phaser"), ParticleRegistry.APALACHIA_PORTAL.get()),
    SKYTHERN_PHASER_SHOT(23, ProjectileLoc("skythern_phaser"), ParticleRegistry.SKYTHERN_PORTAL.get()),
    MORTUM_PHASER_SHOT(26, ProjectileLoc("mortum_phaser"), ParticleRegistry.MORTUM_PORTAL.get()),
    HALITE_PHASER_SHOT(29, ProjectileLoc("halite_phaser"), ParticleRegistry.GREEN_PORTAL.get()),

    //Mob projectiles
    MAGE_SHOT(10, blank(), 62, 212, 254),
    SPELLBINDER_SHOT(12, blank(),234, 158, 253),
    MYSTIC_SHOT(13, blank(), 234, 223, 228),
    SORCERER_SHOT(14, blank(), 97, 31, 54),

    //Boss projectiles
    BONE_FRAGMENT(6, ProjectileLoc("bone_fragment")),
    BONE_BOMB(16, ProjectileLoc("bone_bomb")),
    SUNSTORM(12, blank(),255, 235, 0),
    TWILIGHT_DEMON_BLACK_SHOT(16, ProjectileLoc("twilight_demon_shot"),0, 0, 0),
    TWILIGHT_DEMON_RED_SHOT(16, ProjectileLoc("twilight_demon_shot"), 255, 0, 0),
    SOUL_FIEND_SHOT(0, blank()),
    LUNA_SPARKLER(12, blank(), 139, 103, 255, ParticleRegistry.WILDWOOD_PORTAL.get()),

    //Vethea cannons
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

    //Vethea bouncing projectiles
    TEAKER_STAFF_SHOT(3, ProjectileLoc("bouncing_projectile")),
    AMTHIRMIS_STAFF_SHOT(5, ProjectileLoc("bouncing_projectile")),
    DARVEN_STAFF_SHOT(8, ProjectileLoc("bouncing_projectile")),
    CERMILE_STAFF_SHOT(12, ProjectileLoc("bouncing_projectile")),
    PARDIMAL_STAFF_SHOT(15, ProjectileLoc("bouncing_projectile")),
    QUADROTIC_STAFF_SHOT(19, ProjectileLoc("bouncing_projectile")),
    KAROS_STAFF_SHOT(21, ProjectileLoc("bouncing_projectile")),
    HELIOSIS_STAFF_SHOT(28, ProjectileLoc("bouncing_projectile")),
    ARKSIANE_STAFF_SHOT(36, ProjectileLoc("bouncing_projectile")),
    EVERNIGHT_SHOT(115, ProjectileLoc("bouncing_projectile")),

    //Disks
    TEAKER_DISK(4, ItemLoc("teaker_disk")),
    AMTHIRMIS_DISK(6, ItemLoc("amthirmis_disk")),
    DARVEN_DISK(9, ItemLoc("darven_disk")),
    CERMILE_DISK(13, ItemLoc("cermile_disk")),
    PARDIMAL_DISK(16, ItemLoc("pardimal_disk")),
    QUADROTIC_DISK(20, ItemLoc("quadrotic_disk")),
    KAROS_DISK(22, ItemLoc("karos_disk")),
    HELIOSIS_DISK(29, ItemLoc("heliosis_disk")),
    ARKSIANE_DISK(37, ItemLoc("arksiane_disk")),

    //Dissipators
    TEAKER_DISSIPATOR(4, ItemLoc("teaker_dissipator")),
    AMTHIRMIS_DISSIPATOR(6, ItemLoc("amthirmis_dissipator")),
    DARVEN_DISSIPATOR(9, ItemLoc("darven_dissipator")),
    CERMILE_DISSIPATOR(13, ItemLoc("cermile_dissipator")),
    PARDIMAL_DISSIPATOR(16, ItemLoc("pardimal_dissipator")),
    QUADROTIC_DISSIPATOR(20, ItemLoc("quadrotic_dissipator")),
    KAROS_DISSIPATOR(22, ItemLoc("karos_dissipator")),
    HELIOSIS_DISSIPATOR(29, ItemLoc("heliosis_dissipator")),
    ARKSIANE_DISSIPATOR(37, ItemLoc("arksiane_dissipator"));
    private final float damage;
    private final ResourceLocation texture;
    private final SimpleParticleType particle;
    private final int r, g, b;
    BulletType(float damage, ResourceLocation texture, SimpleParticleType particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        r = 0;
        g = 0;
        b = 0;
    }
    BulletType(float damage, ResourceLocation texture, int r, int g, int b) {
        this.damage = damage;
        this.texture = texture;
        particle = null;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    BulletType(float damage, ResourceLocation texture, int r, int g, int b, SimpleParticleType particle) {
        this.damage = damage;
        this.texture = texture;
        this.particle = particle;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    BulletType(float damage, ResourceLocation texture) {
        this.damage = damage;
        this.texture = texture;
        particle = null;
        r = 0;
        g = 0;
        b = 0;
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
}