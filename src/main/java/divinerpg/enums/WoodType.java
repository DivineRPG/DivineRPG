package divinerpg.enums;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum WoodType implements IStringSerializable {
    DIVINE("divine", MapColor.EMERALD, 2),
    FROZEN("frozen", MapColor.ICE, 2),
    EDEN("eden", MapColor.SAND, 2),
    WILDWOOD("wildwood", MapColor.WATER, 2),
    APALACHIA("apalachia", MapColor.PINK, 2),
    SKYTHERN("skythern", MapColor.WHITE_STAINED_HARDENED_CLAY, 2),
    MORTUM("mortum", MapColor.BROWN, 2),
    EUCALYPTUS("eucalyptus", MapColor.WHITE_STAINED_HARDENED_CLAY, 2);

    private final String name;
    private final MapColor mapColor;
    private final float hardness;
    private Block plank;
    private Block stair;
    private Block singleSlab;
    private Block doubleSlab;

    WoodType(String name, MapColor mapColor, float hardness) {
        this.name = name;
        this.mapColor = mapColor;
        this.hardness = hardness;
    }

    @Override
    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public MapColor getMapColor() {
        return mapColor;
    }

    public float getHardness() {
        return hardness;
    }

    public Block getPlank() {
        return this.plank;
    }

    public void setPlank(Block plank) {
        this.plank = plank;
    }

    public Block getStair() {
        return this.stair;
    }

    public void setStair(Block stair) {
        this.stair = stair;
    }

    public Block getSingleSlab() {
        return this.singleSlab;
    }

    public void setSingleSlab(Block singleSlab) {
        this.singleSlab = singleSlab;
    }

    public Block getDoubleSlab() {
        return this.doubleSlab;
    }

    public void setDoubleSlab(Block doubleSlab) {
        this.doubleSlab = doubleSlab;
    }
}