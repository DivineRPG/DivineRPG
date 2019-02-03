package naturix.divinerpg.bases.items.special;

import naturix.divinerpg.bases.items.ItemBase;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.log.Logging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class HordeHorn extends ItemBase {

    public HordeHorn(String name) {
        super(name);
        this.setMaxDamage(1);
        this.setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return EnumActionResult.PASS;
        } else {
            pos = pos.add(facing.getFrontOffsetX(), facing.getFrontOffsetY(), facing.getFrontOffsetZ());

            if (world.provider.getDimension() == 1) {
                if (world.getBlockState(pos) != Blocks.AIR.getDefaultState()) {
                    return EnumActionResult.PASS;
                }
                world.playSound(player, pos, ModSounds.AYERACO_SPAWN, SoundCategory.NEUTRAL, 20.0F, 1.0F);
                world.setBlockState(pos, ModBlocks.ayeracoSpawn.getDefaultState());
                if (!player.capabilities.isCreativeMode) {
                    player.inventory.getCurrentItem().shrink(1);
                }
            } else {
                world.playSound(player, pos, ModSounds.AYERACO_SPAWN, SoundCategory.MUSIC, 20.0F, 1.0F);
                Logging.message(player, TextFormatting.AQUA + "The Ayeraco Horde can only be spawned in The End");
            }
            return EnumActionResult.FAIL;
        }
    }
}