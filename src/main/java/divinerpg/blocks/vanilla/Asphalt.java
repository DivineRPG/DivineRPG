package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;

import static net.minecraft.world.level.block.Blocks.BLACKSTONE;

public class Asphalt extends BlockMod {
    public Asphalt() {super(Properties.ofFullCopy(BLACKSTONE).speedFactor(1.2F));}
}