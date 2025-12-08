package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.Blocks.GLOWSTONE;

public class BlockLightCrystal extends BlockMod {
    public BlockLightCrystal(MapColor color) {super(Properties.ofFullCopy(GLOWSTONE).mapColor(color));}
}