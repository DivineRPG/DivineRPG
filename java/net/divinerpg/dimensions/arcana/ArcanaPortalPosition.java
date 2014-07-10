package net.divinerpg.dimensions.arcana;

import net.minecraft.util.ChunkCoordinates;

public class ArcanaPortalPosition extends ChunkCoordinates {
	
    public long seed;
    private final TeleporterArcana teleporter;

    public ArcanaPortalPosition(TeleporterArcana arcanaTeleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.teleporter = arcanaTeleporter;
        this.seed = par5;
    }
}