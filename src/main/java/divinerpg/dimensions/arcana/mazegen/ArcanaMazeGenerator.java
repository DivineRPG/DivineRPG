package divinerpg.dimensions.arcana.mazegen;

import divinerpg.dimensions.arcana.mazegen.Cell;
import divinerpg.dimensions.arcana.mazegen.UnionFind;

import java.util.*;

public class ArcanaMazeGenerator {
    public static final int MAZE_SIZE = 64;

    private static class Edge {
        Cell firstAdjacent, secondAdjacent;
        Direction direction;

        enum Direction {
            HORIZONTAL,
            VERTICAL
        }

        Edge(Cell firstAdjacent, Cell secondAdjacent, Direction direction) {
            this.firstAdjacent = firstAdjacent;
            this.secondAdjacent = secondAdjacent;
            this.direction = direction;
        }
    }

    public static Cell[][] generate(int chunkX, int chunkZ, long worldSeed) {
        //Create new random and seed it with provided variables using the vanilla method
        Random random = new Random();
        random.setSeed(worldSeed);
        long k = random.nextLong() / 2L * 2L + 1L;
        long l = random.nextLong() / 2L * 2L + 1L;
        random.setSeed((long) chunkX * k + (long) chunkZ * l ^ worldSeed);

        //Set up stuff
        Cell[][] grid = new Cell[MAZE_SIZE][MAZE_SIZE];
        ArrayList<Edge> edges = new ArrayList<Edge>(); //Was going to use HashSet but I guess there's no efficient way to obtain random elements from them
        UnionFind<Integer> unionFind = new UnionFind<Integer>();

        //Cells
        for(int x = 0; x < MAZE_SIZE; x++) {
            for(int y = 0; y < MAZE_SIZE; y++) {
                Cell cell = new Cell(x, y);
                grid[x][y] = cell;
                unionFind.add(cell.identifier);
            }
        }

        //Horizontal edges
        for(int x = 1; x < MAZE_SIZE; x++) {
            for(int y = 0; y < MAZE_SIZE; y++) {
                edges.add(new Edge(grid[x - 1][y], grid[x][y], Edge.Direction.HORIZONTAL));
            }
        }

        //Vertical edges
        for(int x = 0; x < MAZE_SIZE; x++) {
            for(int y = 1; y < MAZE_SIZE; y++) {
                edges.add(new Edge(grid[x][y - 1], grid[x][y], Edge.Direction.VERTICAL));
            }
        }

        //Shuffle array using seed
        Collections.shuffle(edges, random);

        //Go through all edges
        for(Edge edge: edges) {

            //Get the cells bordering the edge
            Cell firstCell = edge.firstAdjacent;
            Cell secondCell = edge.secondAdjacent;

            //If they are not already part of the same set then delete the edge and join the cells
            if(unionFind.find(firstCell.identifier) != unionFind.find(secondCell.identifier)) {
                if(edge.direction == Edge.Direction.HORIZONTAL) {
                    firstCell.hasSouthEdge = false;
                    secondCell.hasNorthEdge = false;
                }
                else {
                    firstCell.hasEastEdge = false;
                    secondCell.hasWestEdge = false;
                }
                unionFind.union(firstCell.identifier, secondCell.identifier);
            }

            //Otherwise do nothing
        }

        return grid;
    }
}
