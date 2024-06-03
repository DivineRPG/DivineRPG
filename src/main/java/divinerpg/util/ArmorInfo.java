package divinerpg.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import java.util.*;

public class ArmorInfo {
    public static final ArmorInfo
            //TODO: to maybe make it automatic instead of manually inserting values from ArmorAbilitiesEvent
            //Overworld
            angelicInfo = new ArmorInfo(getArmorInfo("fly"),
                                        getArmorInfo("no_fall")),
            aquastriveInfo = new ArmorInfo(getArmorInfo("underwater")),
            arlemiteInfo = new ArmorInfo(getArmorInfo("ranged_protection", 66)),
            bedrockInfo = new ArmorInfo(getArmorInfo("fire_protection"),
                                        getArmorInfo("explosion_protection")),
            corruptedInfo = new ArmorInfo(getArmorInfo("ranged_damage", 50)),
            divineInfo = new ArmorInfo(getArmorInfo("melee_damage", 6),
                                       getArmorInfo("jump_height", 2),
                                       getArmorInfo("no_fall")),
            eliteRealmiteInfo = new ArmorInfo(getArmorInfo("no_fall")),
            enderInfo = new ArmorInfo(getArmorInfo("explosion_protection")),
            fireInfo = new ArmorInfo(getArmorInfo("fire_protection")),
            frozenInfo = new ArmorInfo(getArmorInfo("freeze", 6)),
            jackomanInfo = new ArmorInfo(getArmorInfo("scythe_damage", 3)),
            jungleInfo = new ArmorInfo(getArmorInfo("poison_protection")),
            krakenInfo = new ArmorInfo(getArmorInfo("conduit_power"),
                                       getArmorInfo("swim")),
            terranInfo = new ArmorInfo(getArmorInfo("haste")),
            rupeeInfo = new ArmorInfo(getArmorInfo("melee_protection", 33)),
            shadowInfo = new ArmorInfo(getArmorInfo("step_assist"),
                                       getArmorInfo("speed", 4)),
            skelemanInfo = new ArmorInfo(getArmorInfo("hunger")),
            witherReaperInfo = new ArmorInfo(getArmorInfo("wither_protection")),

            //Iceika
            sengFurInfo = new ArmorInfo(getArmorInfo("hunger"),
                                        getArmorInfo("melee_damage", 2),
                                        getArmorInfo("melee_protection", 30),
                                        getArmorInfo("speed", 2))
                                        .withDimension("iceika"),

            //Arcana
            kormInfo = new ArmorInfo(getArmorInfo("arcana_regen")),
            vemInfo = new ArmorInfo(getArmorInfo("health_regen")),

            //Twilight
            edenInfo = new ArmorInfo(getArmorInfo("ore_drops", 3)),
            wildInfo = new ArmorInfo(getArmorInfo("water_health_regen")),
            apInfo = new ArmorInfo(getArmorInfo("block_protection")),
            skyInfo = new ArmorInfo(getArmorInfo("jump_height", 5),
                                    getArmorInfo("no_fall")),
            mortInfo = new ArmorInfo(getArmorInfo("night_vision")),
            halInfo = new ArmorInfo(getArmorInfo("melee_damage", 16)),
            awakened_halInfo = new ArmorInfo(getArmorInfo("melee_damage", 20),
                                             getArmorInfo("ranged_damage", 50)),

            //Vethea
            basicHelmInfo = new ArmorInfo(getArmorInfo("melee_protection", 15)),
            basicMaskInfo = new ArmorInfo(getArmorInfo("ranged_protection", 15)),
            basicHoodInfo = new ArmorInfo(getArmorInfo("arcana_protection", 15)),
            glisteningHelmInfo = new ArmorInfo(getArmorInfo("melee_damage", 3),
                                               getArmorInfo("melee_protection", 15)),
            glisteningMaskInfo = new ArmorInfo(getArmorInfo("ranged_protection", 15),
                                               getArmorInfo("speed", 1)),
            glisteningHoodInfo = new ArmorInfo(getArmorInfo("arcana_protection", 15),
                                               getArmorInfo("jump_height", 2),
                                               getArmorInfo("no_fall")),
            demonizedHelmInfo = new ArmorInfo(getArmorInfo("melee_damage", 6),
                                              getArmorInfo("melee_protection", 15)),
            demonizedMaskInfo = new ArmorInfo(getArmorInfo("ranged_protection", 15),
                                              getArmorInfo("speed", 2)),
            demonizedHoodInfo = new ArmorInfo(getArmorInfo("arcana_protection", 15),
                                              getArmorInfo("jump_height", 3),
                                              getArmorInfo("no_fall")),
            tormentedHelmInfo = new ArmorInfo(getArmorInfo("melee_damage", 9),
                                              getArmorInfo("melee_protection", 15)),
            tormentedMaskInfo = new ArmorInfo(getArmorInfo("ranged_protection", 15),
                                              getArmorInfo("speed", 3)),
            tormentedHoodInfo = new ArmorInfo(getArmorInfo("arcana_protection", 15),
                                              getArmorInfo("jump_height", 4),
                                              getArmorInfo("no_fall"));
    public final MutableComponent FullSetPerks;
    public String dimensionName;
    public ArmorInfo(Component... fullSetPerks) {
        FullSetPerks = getArmorInfo("");
        if(fullSetPerks != null && fullSetPerks.length > 0) Arrays.stream(fullSetPerks).forEach(FullSetPerks::append);
    }
    public ArmorInfo withDimension(String dimensionName) {
        this.dimensionName = dimensionName;
        return this;
    }
    public List<MutableComponent> asString() {
        List<MutableComponent> components = new ArrayList<>();
        if(dimensionName != null) {
            MutableComponent dimName = getArmorInfo(ChatFormatting.DARK_PURPLE, dimensionName);
            components.add(dimName);
        } if(FullSetPerks != null && !FullSetPerks.getSiblings().isEmpty()) {
            MutableComponent fullSetDescription = getArmorInfo(ChatFormatting.GRAY, "fullset");
            components.add(fullSetDescription);
            components.addAll(FullSetPerks.getSiblings().stream().map(sibling -> (MutableComponent) sibling).toList());
        } return components;
    }
    public static MutableComponent getArmorInfo(ChatFormatting color, String text, Object... args) {
        String id = String.format("tooltip.divinerpg.armor_info.%s", text);
        return args == null || args.length < 1 ? MutableComponent.create(new TranslatableContents(id, null, null)).withStyle(color) : MutableComponent.create(new TranslatableContents(id, null, args)).withStyle(color);
    }
    public static MutableComponent getArmorInfo(String text, Object... args) {
        String id = String.format("tooltip.divinerpg.armor_info.%s", text);
        return args == null || args.length < 1 ? MutableComponent.create(new TranslatableContents(id, null, null)).withStyle(ChatFormatting.BLUE) : MutableComponent.create(new TranslatableContents(id, null, args)).withStyle(ChatFormatting.BLUE);
    }
}