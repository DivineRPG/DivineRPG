package naturix.divinerpg.objects.items.itemblock;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on Jan
 * /29/2019
 */
public class ItemBlockDoor extends ItemBlock {
    public ItemBlockDoor(Block block) {
        super(block);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (facing != EnumFacing.UP) {
            return EnumActionResult.FAIL;
        } else {
            IBlockState bottomState = worldIn.getBlockState(pos);
            Block bottomBlock = bottomState.getBlock();

            if (!block.isReplaceable(worldIn, pos)) {
                pos = pos.offset(facing);
            }

            ItemStack stack = player.getHeldItem(hand);

            if (player.canPlayerEdit(pos, facing, stack) && this.block.canPlaceBlockAt(worldIn, pos)) {
                EnumFacing playerFacing = EnumFacing.fromAngle((double) player.rotationYaw);
                int x = playerFacing.getFrontOffsetX();
                int z = playerFacing.getFrontOffsetZ();
                boolean flag = x < 0 && hitZ < 0.5f || x > 0 && hitZ > 0.5f || z < 0 && hitX < 0.5f || z > 0 && hitX > 0.5f;
                this.placeDoor(worldIn, pos, playerFacing, this.block, flag);
                SoundType soundType = block.getSoundType(bottomState, worldIn, pos, player);
                worldIn.playSound(player, pos, soundType.getPlaceSound(), SoundCategory.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
                stack.shrink(1);
                return EnumActionResult.SUCCESS;
            } else {
                return EnumActionResult.FAIL;
            }
        }
    }

    private static void placeDoor(World worldIn, BlockPos bottomDoorPos, EnumFacing playerFacing, Block door, boolean isRightHinge) {
        BlockPos posYClockwise = bottomDoorPos.offset(playerFacing.rotateY());
        BlockPos posYCounterClockwise = bottomDoorPos.offset(playerFacing.rotateYCCW());

        int i = (worldIn.getBlockState(posYCounterClockwise).isNormalCube()? 1 : 0) + (worldIn.getBlockState(posYCounterClockwise.up()).isNormalCube()? 1 : 0);
        int j = (worldIn.getBlockState(posYClockwise).isNormalCube()? 1 : 0) + (worldIn.getBlockState(posYClockwise.up()).isNormalCube()? 1 : 0);

        boolean flag = worldIn.getBlockState(posYCounterClockwise).getBlock() == door || worldIn.getBlockState(posYCounterClockwise.up()).getBlock() == door;
        boolean flag1 = worldIn.getBlockState(posYClockwise).getBlock() == door || worldIn.getBlockState(posYClockwise.up()).getBlock() == door;

        if ((!flag || flag1) && j <= i) {
            if (flag1 && !flag || j < i) {
                isRightHinge = false;
            }
        } else {
            isRightHinge = true;
        }

        BlockPos topDoorPos = bottomDoorPos.up();
        boolean flag2 = worldIn.isBlockPowered(bottomDoorPos) || worldIn.isBlockPowered(topDoorPos);
        IBlockState doorState = door.getDefaultState()
                .withProperty(BlockDoor.FACING, playerFacing)
                .withProperty(BlockDoor.HINGE, isRightHinge ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT)
                .withProperty(BlockDoor.POWERED, Boolean.valueOf(flag2))
                .withProperty(BlockDoor.OPEN, Boolean.valueOf(flag2));

        worldIn.setBlockState(bottomDoorPos, doorState.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER));
        worldIn.setBlockState(topDoorPos, doorState.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER));
        worldIn.notifyNeighborsOfStateChange(bottomDoorPos, door, false);
        worldIn.notifyNeighborsOfStateChange(topDoorPos, door, false);
    }
}
