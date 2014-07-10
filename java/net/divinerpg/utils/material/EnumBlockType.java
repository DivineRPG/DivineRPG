package net.divinerpg.utils.material;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;

public enum EnumBlockType {

    ROCK(Material.rock, Block.soundTypeStone),
    DIRT(Material.ground, Block.soundTypeGravel),
    LEAVES(Material.leaves, Block.soundTypeGrass),
    WOOD(Material.wood, Block.soundTypeWood),
    GLASS(Material.glass, Block.soundTypeGlass),
    GRASS(Material.grass, Block.soundTypeGrass),
    VINES(Material.vine, Block.soundTypeGrass),
    WOOL(Material.cloth, Block.soundTypeCloth),
    PORTAL(Material.portal, Block.soundTypeStone),
    IRON(Material.iron, Block.soundTypeMetal),
    SNOW(Material.snow, Block.soundTypeSnow),
    PLANT(Material.plants, Block.soundTypeGrass);

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
