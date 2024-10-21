package net.divinerpg.utils.enums;

import net.divinerpg.utils.MessageLocalizer;

public enum ArmorInfo {

    FIRE_PROTECTION(MessageLocalizer.norecolor("armor.tooltip.fireprotection")),
    NO_FALL(MessageLocalizer.norecolor("armor.tooltip.nofall")),
    FLY(MessageLocalizer.norecolor("armor.tooltip.fly")),
    SPEED("#x " + (MessageLocalizer.norecolor("armor.tooltip.speed"))),
    MELEE_DAMAGE("+# " + (MessageLocalizer.norecolor("armor.tooltip.meleedamage"))),
    RANGED_DAMAGE("+#% " + (MessageLocalizer.norecolor("armor.tooltip.rangeddamage"))),
    HUNGER(MessageLocalizer.norecolor("armor.tooltip.hunger")),
    DAMAGE_REDUCTION("#% " + (MessageLocalizer.norecolor("armor.tooltip.damagereduction"))),
    JUMP_HEIGHT("#x " + (MessageLocalizer.norecolor("armor.tooltip.jumpheight"))),
    ORE_DROPS("+# " + (MessageLocalizer.norecolor("armor.tooltip.oredrops"))),
    HEALTH_REGEN(MessageLocalizer.norecolor("armor.tooltip.healthregen")),
    UNDERWATER_HEALTH_REGEN(MessageLocalizer.norecolor("armor.tooltip.underwaterhealthregen")),
    BLOCK_PROTECTION(MessageLocalizer.norecolor("armor.tooltip.blockprotection")),
    NIGHT_VISION(MessageLocalizer.norecolor("armor.tooltip.nightvision")),
    EXPLOSION_PROTECTION(MessageLocalizer.norecolor("armor.tooltip.explosionprotection")),
    RANGED_PROTECTION(MessageLocalizer.norecolor("armor.tooltip.rangedprotection")),
    MELEE_PROTECTION("#% " + (MessageLocalizer.norecolor("armor.tooltip.meleeprotection"))),
    ARCANA_PROTECTION("+#% " + (MessageLocalizer.norecolor("armor.tooltip.arcanaprotection"))),
    UNDERWATER(MessageLocalizer.norecolor("armor.tooltip.underwater")),
    SCYTHE_DAMAGE("#x " + (MessageLocalizer.norecolor("armor.tooltip.scythedamage"))),
    SWIM(MessageLocalizer.norecolor("armor.tooltip.swim")),
    WITHER_PROTECTION(MessageLocalizer.norecolor("armor.tooltip.witherprotection")),
    ARCANA_REGEN(MessageLocalizer.norecolor("armor.tooltip.arcanaregen")),
    POISON_PROTECTION(MessageLocalizer.norecolor("armor.tooltip.poisonprotection")),
    FREEZE(MessageLocalizer.norecolor("armor.tooltip.freeze")),
    HASTE(MessageLocalizer.norecolor("armor.tooltip.haste"));
    
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