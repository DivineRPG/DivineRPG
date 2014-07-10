package net.divinerpg.utils.enums;

public enum ArmorInfo {

    FIRE_PROTECTION("Fire Protection"),
    NO_FALL("No Fall Damage"),
    FLY("Flight"),
    SPEED("Move Faster"),
    MELEE_DAMAGE("#+ Melee Damage"),
    HUNGER("Refills Hunger"),
    DAMAGE_REDUCTION("#% Damage Reduction"),
    JUMP_HEIGHT("#x Jump Height"),
    ORE_DROPS("#x Ore Drops"),
    HEALTH_REGEN("Health Regeneration"),
    UNDERWATER_HEALTH_REGEN("Health Regenerates Underwater"),
    BLOCK_PROTECTION("Block Damage Protection"),
    NIGHT_VISION("Night Vision"),
    EXPLOSION_PROTECTION("Explosion Protection"),
    RANGED_PROTECTION("#% Ranged Damage Protection"),
    MELEE_PROTECTION("#% Melee Damage Protection"),
    UNDERWATER("Breathe Underwater"),
    SCYTHE_DAMAGE("#x Scythe Damage"),
    SWIM("Swim Faster"),
    WITHER_PROTECTION("Wither Protection"),
    ARCANA_REGEN("Arcana Regeneration");

    private String info;

    private ArmorInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
    
    @Override
    public String toString() {
        return getInfo();
    }
}