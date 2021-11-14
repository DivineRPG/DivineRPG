package divinerpg.world.arcana;


import net.minecraft.util.Rotation;

public class Cell {
    public int x, y, identifier;
    public boolean hasNorthEdge, hasEastEdge, hasSouthEdge, hasWestEdge;

    public enum PieceType {
        CROSSROADS,
        JUNCTION,
        HALLWAY,
        CORNER,
        DEAD_END
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.identifier = (x * ArcanaMazeGenerator.MAZE_SIZE) + y;

        this.hasNorthEdge = true;
        this.hasEastEdge = true;
        this.hasSouthEdge = true;
        this.hasWestEdge = true;
    }

    public int getNumberOfEdges() {
        int result = 0;
        if (this.hasNorthEdge) {
            result++;
        }
        if (this.hasEastEdge) {
            result++;
        }
        if (this.hasSouthEdge) {
            result++;
        }
        if (this.hasWestEdge) {
            result++;
        }
        return result;
    }

    public PieceType getPieceType() {
        switch (this.getNumberOfEdges()) {
            case 0:
                return PieceType.CROSSROADS;
            case 1:
                return PieceType.JUNCTION;
            case 2:
                if ((this.hasNorthEdge && this.hasSouthEdge) || (this.hasEastEdge && this.hasWestEdge)) {
                    return PieceType.HALLWAY;
                } else {
                    return PieceType.CORNER;
                }
            case 3:
                return PieceType.DEAD_END;
            default:
                return null;
        }
    }

    public Rotation getRotation() {
        //These are all assuming you are facing south

        //DEAD END has opening at Bottom edge by default
        //CORNER has openings at Bottom and Right edges by default
        //HALLWAY has openings at Bottom and Top edges by default
        //THREE WAY has openings at Bottom, Left, and Right edges by default
        //CROSSROADS has a randomly selected rotation to support rooms that aren't rotationally symmetrical
        //The random selection is done elsewhere to avoid having to pass a seeded random number generator through here
        switch (this.getPieceType()) {
            case CROSSROADS:
                return Rotation.NONE;
            case JUNCTION:
                if (this.hasNorthEdge) {
                    return Rotation.NONE;
                } else if (this.hasEastEdge) {
                    return Rotation.CLOCKWISE_90;
                } else if (this.hasSouthEdge) {
                    return Rotation.CLOCKWISE_180;
                } else {
                    return Rotation.COUNTERCLOCKWISE_90;
                }
            case CORNER:
                if (!this.hasSouthEdge) {
                    if (!this.hasWestEdge) {
                        return Rotation.NONE;
                    } else {
                        return Rotation.COUNTERCLOCKWISE_90;
                    }
                } else {
                    if (!this.hasEastEdge) {
                        return Rotation.CLOCKWISE_180;
                    } else {
                        return Rotation.CLOCKWISE_90;
                    }
                }
            case HALLWAY:
                if (!this.hasSouthEdge) {
                    return Rotation.NONE;
                } else {
                    return Rotation.CLOCKWISE_90;
                }
            case DEAD_END:
                if (!this.hasSouthEdge) {
                    return Rotation.NONE;
                } else if (!this.hasWestEdge) {
                    return Rotation.CLOCKWISE_90;
                } else if (!this.hasNorthEdge) {
                    return Rotation.CLOCKWISE_180;
                } else {
                    return Rotation.COUNTERCLOCKWISE_90;
                }
            default:
                return null;
        }
    }
}