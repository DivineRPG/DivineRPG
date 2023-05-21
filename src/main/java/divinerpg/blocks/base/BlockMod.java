package divinerpg.blocks.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;

public class BlockMod extends Block {
    private final boolean isNotPushable;

    public BlockMod(Block.Properties properties) {
        super(properties);
        this.isNotPushable = false;
    }

    public BlockMod(MaterialColor color, float hardness, float resistance) {
        super(Block.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(hardness, resistance));
        this.isNotPushable = false;
    }

    public BlockMod(float hardness, float resistance, Material material, MaterialColor color, SoundType sound) {
        super(Block.Properties.of(material, color).strength(hardness, resistance).sound(sound));
        this.isNotPushable = false;
    }

    public BlockMod(MaterialColor color, boolean isNotPushable, int luminance) {
        super(Block.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(50F, 1200F).lightLevel((state) -> luminance));
        this.isNotPushable = isNotPushable;
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        if (isNotPushable) {
            return PushReaction.BLOCK;
        } else {
            return PushReaction.NORMAL;
        }
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOL) {
            return 60;
        }
        return 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        if(material == Material.WOOL) {
            return 30;
        }
        return 0;
    }
}