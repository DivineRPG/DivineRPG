package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.twilight.ItemBossSpawner;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import java.util.Objects;

public class ItemHordeHorn extends ItemBossSpawner {

    public ItemHordeHorn(String name) {
        super(name, "message.ayeraco_horde", x -> Objects.equals(x, DimensionType.THE_END));
        this.setMaxStackSize(1);
        this.setCreativeTab(DivineRPGTabs.spawner);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        EnumActionResult result = super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);

        if (result == EnumActionResult.SUCCESS) {
            pos = pos.add(facing.getFrontOffsetX(), facing.getFrontOffsetY(), facing.getFrontOffsetZ());
            if (world.getBlockState(pos) == Blocks.AIR.getDefaultState()) {
                world.playSound(null, pos, SoundRegistry.AYERACO_SPAWN, SoundCategory.MASTER, 20.0F, 1.0F);
                world.setBlockState(pos, BlockRegistry.ayeracoSpawn.getDefaultState());

                if (!player.isCreative()) {
                    player.getHeldItemMainhand().shrink(1);
                }
            }
        }

        return result;
    }
}