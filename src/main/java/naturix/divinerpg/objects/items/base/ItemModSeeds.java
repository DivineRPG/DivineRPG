package naturix.divinerpg.objects.items.base;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.BlockModCrop;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemModSeeds extends ItemSeeds implements IHasModel {
    public String name;
    public BlockModCrop crop;

    public ItemModSeeds(String name, BlockModCrop block) {
        super(block, Blocks.FARMLAND);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.crop = block;
        this.setCreativeTab(DRPGCreativeTabs.food);
        ModItems.ITEMS.add(this);
    }

    public ItemModSeeds(String name, BlockModCrop block, Block placeOn) {
        super(block, placeOn);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.crop = block;
        setCreativeTab(DRPGCreativeTabs.food);
        ModItems.ITEMS.add(this);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack)
                && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), this.crop.getDefaultState());

            if (player instanceof EntityPlayerMP) {
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos.up(), itemstack);
            }

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public void registerModels() {
        DivineRPG.proxy.registerItemRenderer(this, 0, name);
    }
}