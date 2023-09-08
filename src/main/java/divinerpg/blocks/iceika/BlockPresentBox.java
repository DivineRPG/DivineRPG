package divinerpg.blocks.iceika;

import divinerpg.block_entities.chests.PresentBoxBlockEntity;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

public class BlockPresentBox extends BlockModChest {

    public BlockPresentBox() {
        super(Properties.of().mapColor(MapColor.COLOR_BLUE).ignitedByLava().sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F), () -> BlockEntityRegistry.PRESENT_BOX.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new PresentBoxBlockEntity(p_153215_, p_153216_);
    }

}
