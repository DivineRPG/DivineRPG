package net.divinerpg.dimensions.arcana.components;

import java.util.Random;

import net.divinerpg.dimensions.arcana.ArcanaChunk;

public abstract class DungeonComponentBase {

    public abstract boolean generate(ArcanaChunk chunk, Random rand, int x, int y, int z);

}