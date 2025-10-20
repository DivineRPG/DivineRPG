package divinerpg.util;

import net.minecraft.sounds.*;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class BlockSetTypesList {
    public static final BlockSetType
        ARCANA = arcanaBlockSetType("arcana"),
        STEEL = steelBlockSetType("steel"),
        DIVINE = cherryWoodSetType("divine"),
        SHIVERSPINE = regularWoodSetType("shiverspine"),
        AURORAOAK = cherryWoodSetType("auroraoak"),
        COZYBARK = cherryWoodSetType("cozybark"),
        STREAMLEAF = netherWoodSetType("streamleaf"),
        EUCALYPTUS = regularWoodSetType("eucalyptus"),
        EDEN = regularWoodSetType("eden"),
        WILDWOOD = regularWoodSetType("wildwood"),
        APALACHIA = regularWoodSetType("apalachia"),
        SKYTHERN = netherWoodSetType("skythern"),
        MORTUM = regularWoodSetType("mortum"),
        FIREWOOD = regularWoodSetType("firewood"),
        DREAMWOOD = regularWoodSetType("dreamwood"),
        HYREWOOD = regularWoodSetType("hyrewood"),
        MINTWOOD = netherWoodSetType("mintwood");
    private static BlockSetType baseBlockSetType(String name, boolean canOpenByHand, boolean canOpenByWindCharge, boolean canButtonBeActivatedByArrows, BlockSetType.PressurePlateSensitivity pressurePlateSensitivity, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
        return new BlockSetType(name, canOpenByHand, canOpenByWindCharge, canButtonBeActivatedByArrows, pressurePlateSensitivity, soundType, doorClose, doorOpen, trapdoorClose, trapdoorOpen, pressurePlateClickOff, pressurePlateClickOn, buttonClickOff, buttonClickOn);
    }
    private static BlockSetType regularWoodSetType(String name) {return new BlockSetType(name);}
    private static BlockSetType customWoodSetType(String name, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
        return baseBlockSetType(name, true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, soundType, doorClose, doorOpen, trapdoorClose, trapdoorOpen, pressurePlateClickOff, pressurePlateClickOn, buttonClickOff, buttonClickOn);
    }
    private static BlockSetType cherryWoodSetType(String name) {
        return customWoodSetType(name, SoundType.CHERRY_WOOD, SoundEvents.CHERRY_WOOD_DOOR_CLOSE, SoundEvents.CHERRY_WOOD_DOOR_OPEN, SoundEvents.CHERRY_WOOD_TRAPDOOR_CLOSE, SoundEvents.CHERRY_WOOD_TRAPDOOR_OPEN, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_OFF, SoundEvents.CHERRY_WOOD_BUTTON_CLICK_ON);
    }
    private static BlockSetType netherWoodSetType(String name) {
        return customWoodSetType(name, SoundType.NETHER_WOOD, SoundEvents.NETHER_WOOD_DOOR_CLOSE, SoundEvents.NETHER_WOOD_DOOR_OPEN, SoundEvents.NETHER_WOOD_TRAPDOOR_CLOSE, SoundEvents.NETHER_WOOD_TRAPDOOR_OPEN, SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF, SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON);
    }
    //Iron interaction, but Stone sounds set
    private static BlockSetType arcanaBlockSetType(String name) {
        return baseBlockSetType(name, false, false, false, BlockSetType.PressurePlateSensitivity.MOBS, SoundType.STONE, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
    }
    //Stone interaction, but Iron sounds set
    private static BlockSetType steelBlockSetType(String name) {
        return baseBlockSetType(name, true, true, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.METAL, SoundEvents.IRON_DOOR_CLOSE, SoundEvents.IRON_DOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON);
    }
}