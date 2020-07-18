package divinerpg.dimensions.arcana.mazegen;

import net.minecraft.util.Rotation;

public class Cell {
    public int x, y, identifier;
    public boolean hasNorthEdge, hasEastEdge, hasSouthEdge, hasWestEdge;

    public enum PieceType {
        CROSSROADS,
        THREE_WAY,
        HALLWAY,
        CORNER,
        DEAD_END
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        //will fix magic constant later
        this.identifier = (x * ArcanaMazeGenerator.MAZE_SIZE) + y;

        this.hasNorthEdge = true;
        this.hasEastEdge = true;
        this.hasSouthEdge = true;
        this.hasWestEdge = true;
    }

    public int getNumberOfEdges() {
        int result = 0;
        if(this.hasNorthEdge) {
            result++;
        }
        if(this.hasEastEdge) {
            result++;
        }
        if(this.hasSouthEdge) {
            result++;
        }
        if(this.hasWestEdge) {
            result++;
        }
        return result;
    }

    public PieceType getPieceType() {
        switch(this.getNumberOfEdges()) {
            case 0:
                return PieceType.CROSSROADS;
            case 1:
                return PieceType.THREE_WAY;
            case 2:
                if((this.hasNorthEdge && this.hasSouthEdge) || (this.hasEastEdge && this.hasWestEdge)) {
                    return PieceType.HALLWAY;
                }
                else {
                    return PieceType.CORNER;
                }
            case 3:
                return PieceType.DEAD_END;
            default:
                return null;
        }
    }

    public Rotation getRotation() {
        //DEAD END has opening at South Edge by default
        //CORNER has openings at South and East edges by default
        //HALLWAY has openings at South and North edges by default
        //THREE WAY has openings at South, West, and East edges by default
        //CROSSROADS obviously doesn't really matter but can have random rotation I guess in case for some reason they don't end up being rotationally symmetrical

        switch(this.getPieceType()) {
            case CROSSROADS:
                return Rotation.NONE;
            case THREE_WAY:
                if(this.hasNorthEdge) {
                    return Rotation.NONE;
                }
                else if(this.hasEastEdge) {
                    return Rotation.CLOCKWISE_90;
                }
                else if(this.hasSouthEdge) {
                    return Rotation.CLOCKWISE_180;
                }
                else {
                    return Rotation.COUNTERCLOCKWISE_90;
                }
            case CORNER:
                if(!this.hasSouthEdge) {
                    if(!this.hasEastEdge) {
                        return Rotation.NONE;
                    }
                    else {
                        return Rotation.CLOCKWISE_90;
                    }
                }
                else {
                    if(!this.hasEastEdge) {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                    else {
                        return Rotation.CLOCKWISE_180;
                    }
                }
            case HALLWAY:
                if(!this.hasSouthEdge) {
                    return Rotation.NONE;
                }
                else {
                    return Rotation.CLOCKWISE_90;
                }
            case DEAD_END:
                if(!this.hasSouthEdge) {
                    return Rotation.NONE;
                }
                else if(!this.hasWestEdge) {
                    return Rotation.CLOCKWISE_90;
                }
                else if(!this.hasNorthEdge) {
                    return Rotation.CLOCKWISE_180;
                }
                else {
                    return Rotation.COUNTERCLOCKWISE_90;
                }
            default:
                return null;
        }
    }
}
