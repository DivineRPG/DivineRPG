package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.BlockStupidSpawner;

public class BlockArcanaSpawner extends BlockStupidSpawner {
    public BlockArcanaSpawner(String name, String mobName) {
        super(name, mobName, false);
        setBlockUnbreakable();
        setResistance(6000000F);
    }
}