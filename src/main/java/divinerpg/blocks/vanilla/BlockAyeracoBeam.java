package divinerpg.blocks.vanilla;

import divinerpg.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockAyeracoBeam extends ContainerBlock {
    private String tex;

    public BlockAyeracoBeam(String name, String tex) {
        super(Block.Properties.of(Material.FIRE).strength(6000000.0F, 6000000.0F));
        this.tex = tex;
        hasTileEntity(defaultBlockState());
        setRegistryName(name);
    }


    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityAyeracoBeam(
                new ResourceLocation(DivineRPG.MODID + ":textures/blocks/beam_" + tex + ".png"));
    }
}
