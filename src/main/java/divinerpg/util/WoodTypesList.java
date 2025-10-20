package divinerpg.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.*;

public class WoodTypesList {
    public static final WoodType
        //Overworld
        DIVINE = cherryWoodType("divine", BlockSetTypesList.DIVINE),
        //Iceika
        SHIVERSPINE = regularWoodType("shiverspine", BlockSetTypesList.SHIVERSPINE),
        AURORAOAK = cherryWoodType("auroraoak", BlockSetTypesList.AURORAOAK),
        COZYBARK = cherryWoodType("cozybark", BlockSetTypesList.COZYBARK),
        STREAMLEAF = netherWoodType("streamleaf", BlockSetTypesList.STREAMLEAF),
        EUCALYPTUS = regularWoodType("eucalyptus", BlockSetTypesList.EUCALYPTUS),
        EDEN = regularWoodType("eden", BlockSetTypesList.EDEN),
        WILDWOOD = regularWoodType("wildwood", BlockSetTypesList.WILDWOOD),
        APALACHIA = regularWoodType("apalachia", BlockSetTypesList.APALACHIA),
        SKYTHERN = netherWoodType("skythern", BlockSetTypesList.SKYTHERN),
        MORTUM = regularWoodType("mortum", BlockSetTypesList.MORTUM),
        FIREWOOD = regularWoodType("firewood", BlockSetTypesList.FIREWOOD),
        DREAMWOOD = regularWoodType("dreamwood", BlockSetTypesList.DREAMWOOD),
        HYREWOOD = regularWoodType("hyrewood", BlockSetTypesList.HYREWOOD),
        MINTWOOD = netherWoodType("mintwood", BlockSetTypesList.MINTWOOD);
    private static WoodType regularWoodType(String name, BlockSetType type) {return new WoodType(name, type);}
    private static WoodType cherryWoodType(String name, BlockSetType type) {
        return new WoodType(name, type, SoundType.CHERRY_WOOD, SoundType.CHERRY_WOOD_HANGING_SIGN, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN);
    }
    private static WoodType netherWoodType(String name, BlockSetType type) {
        return new WoodType(name, type, SoundType.NETHER_WOOD, SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE, SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN);
    }
}