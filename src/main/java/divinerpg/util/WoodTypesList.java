package divinerpg.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.*;

import static divinerpg.DivineRPG.MODID;

public class WoodTypesList {
    public static final WoodType
        //Overworld
        DIVINE = WoodType.register(cherryWoodType("divine", BlockSetTypesList.DIVINE)),
        //Iceika
        SHIVERSPINE = WoodType.register(regularWoodType("shiverspine", BlockSetTypesList.SHIVERSPINE)),
        AURORAOAK = WoodType.register(cherryWoodType("auroraoak", BlockSetTypesList.AURORAOAK)),
        COZYBARK = WoodType.register(cherryWoodType("cozybark", BlockSetTypesList.COZYBARK)),
        STREAMLEAF = WoodType.register(netherWoodType("streamleaf", BlockSetTypesList.STREAMLEAF)),
        EUCALYPTUS = WoodType.register(regularWoodType("eucalyptus", BlockSetTypesList.EUCALYPTUS)),
        EDEN = WoodType.register(regularWoodType("eden", BlockSetTypesList.EDEN)),
        WILDWOOD = WoodType.register(regularWoodType("wildwood", BlockSetTypesList.WILDWOOD)),
        APALACHIA = WoodType.register(regularWoodType("apalachia", BlockSetTypesList.APALACHIA)),
        SKYTHERN = WoodType.register(netherWoodType("skythern", BlockSetTypesList.SKYTHERN)),
        MORTUM = WoodType.register(regularWoodType("mortum", BlockSetTypesList.MORTUM)),
        FIREWOOD = WoodType.register(regularWoodType("firewood", BlockSetTypesList.FIREWOOD)),
        DREAMWOOD = WoodType.register(regularWoodType("dreamwood", BlockSetTypesList.DREAMWOOD)),
        HYREWOOD = WoodType.register(regularWoodType("hyrewood", BlockSetTypesList.HYREWOOD)),
        MINTWOOD = WoodType.register(netherWoodType("mintwood", BlockSetTypesList.MINTWOOD));
    private static WoodType regularWoodType(String name, BlockSetType type) {return new WoodType(MODID + ":" + name, type);}
    private static WoodType cherryWoodType(String name, BlockSetType type) {
        return new WoodType(MODID + ":" + name, type, SoundType.CHERRY_WOOD, SoundType.CHERRY_WOOD_HANGING_SIGN, SoundEvents.CHERRY_WOOD_FENCE_GATE_CLOSE, SoundEvents.CHERRY_WOOD_FENCE_GATE_OPEN);
    }
    private static WoodType netherWoodType(String name, BlockSetType type) {
        return new WoodType(MODID + ":" + name, type, SoundType.NETHER_WOOD, SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE, SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN);
    }
}