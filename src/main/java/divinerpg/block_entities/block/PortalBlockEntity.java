package divinerpg.block_entities.block;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.utils.UniversalPosition;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class PortalBlockEntity extends BlockEntity {
    public UniversalPosition targetPosition;

    public PortalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public PortalBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.PORTAL.get(), pos, state);
    }

    public boolean shouldRenderFace(Direction direction) {
        return direction.getAxis() == Axis.Y;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (this.targetPosition != null) {
            ValueOutput targetOutput = output.child("TargetPosition");
            this.targetPosition.write(targetOutput);
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        input.child("TargetPosition").ifPresent(targetInput -> {
            this.targetPosition = UniversalPosition.read(targetInput);
        });
    }
}