package divinerpg.utils;

import divinerpg.DivineRPG;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.HashMap;
import java.util.Map;

public final class BlockSoundTypeMap {
    private static final Map<Material, SoundType> map = new HashMap<Material, SoundType>();
    static {
        map.put(Material.ROCK, SoundType.STONE);
        map.put(Material.PORTAL, SoundType.STONE);
        map.put(Material.GROUND, SoundType.GROUND);
        map.put(Material.GRASS, SoundType.PLANT);
        map.put(Material.LEAVES, SoundType.PLANT);
        map.put(Material.PLANTS, SoundType.PLANT);
        map.put(Material.VINE, SoundType.PLANT);
        map.put(Material.WOOD, SoundType.WOOD);
        map.put(Material.GLASS, SoundType.GLASS);
        map.put(Material.REDSTONE_LIGHT, SoundType.GLASS);
        map.put(Material.CLOTH, SoundType.CLOTH);
        map.put(Material.IRON, SoundType.METAL);
        map.put(Material.CIRCUITS, SoundType.METAL);
        map.put(Material.SNOW, SoundType.SNOW);
    }

    public static final SoundType soundTypeForMaterial(Material material) {
        SoundType soundType = map.get(material);
        if(soundType == null) {
            DivineRPG.logger.info("No sound type for material " + material.toString() + " in map");
            return SoundType.STONE;
        }
        return soundType;
    }
}
