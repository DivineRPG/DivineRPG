package divinerpg.utils.material;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public enum EnumBlockType {
    ROCK(Material.ROCK, SoundType.STONE),
    DIRT(Material.GROUND, SoundType.GROUND),
    LEAVES(Material.LEAVES, SoundType.PLANT),
    WOOD(Material.WOOD, SoundType.WOOD),
    GLASS(Material.GLASS, SoundType.GLASS),
    GRASS(Material.GRASS, SoundType.PLANT),
    VINES(Material.VINE, SoundType.PLANT),
    WOOL(Material.CLOTH, SoundType.CLOTH),
    PORTAL(Material.PORTAL, SoundType.STONE),
    IRON(Material.IRON, SoundType.METAL),
    SNOW(Material.SNOW, SoundType.SNOW),
    PLANT(Material.PLANTS, SoundType.PLANT),
    CIRCUIT(Material.CIRCUITS, SoundType.METAL);

    private Material  material;
    private SoundType sound;

    private EnumBlockType(Material material, SoundType sound) {
        this.material = material;
        this.sound = sound;
    }

    public Material getMaterial() {
        return material;
    }

    public SoundType getSound() {
        return sound;
    }
}
