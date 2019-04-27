package naturix.divinerpg.objects.items.vethea;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.entities.entity.vethea.LadyLuna;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemMoonClock extends ItemMod {

    public ItemMoonClock(String name) {
        super(name, DRPGCreativeTabs.spawner);
        setMaxStackSize(1);
    }
    //FIXME - Doesnt spawn
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = new ItemStack(this);
        if(!world.isRemote) {
            if(Config.debug) {DivineRPG.logger.info("the world isnt remote");}
            if(world.getBlockState(pos) == ModBlocks.lunicAltar.getDefaultState()) {
                if(Config.debug) {DivineRPG.logger.info("looking at the lunic altar");}
                  //FIXME - Needs to check top 2 blocks for air
//                if(world.getBlockState(pos.up()) == Blocks.AIR) {
//                    if(Config.debug) {DivineRPG.logger.info("top blocks are air");}
//                    if(world.getBlockState(new BlockPos(pos.getX(), pos.getY()+2, pos.getZ())) == Blocks.AIR) {
                        LadyLuna entity = new LadyLuna(world);
                        entity.setPositionAndRotation(pos.getX(), (double) pos.getY() + 1, pos.getZ(),
                                player.rotationYaw, player.rotationPitch);
                        world.spawnEntity(entity);if(Config.debug) {
                            DivineRPG.logger.info(player.getDisplayNameString()+ " tried to use the "+ stack.getDisplayName()+ " at " + pos);
                        }
                            if(!player.capabilities.isCreativeMode)stack.shrink(1);
                            return EnumActionResult.PASS;
                            
//                    }
//                }
            }
        }
        
        if(Config.debug) {
            DivineRPG.logger.info(player.getDisplayNameString()+ " tried to use the "+ stack.getDisplayName()+ " at " + pos+" but it failed, that block is "+ world.getBlockState(pos).getBlock().getLocalizedName());
        }
    return EnumActionResult.FAIL;
    }

}