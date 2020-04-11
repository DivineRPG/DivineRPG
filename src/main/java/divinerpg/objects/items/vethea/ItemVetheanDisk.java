package divinerpg.objects.items.vethea;

import divinerpg.enums.DiskType;
import divinerpg.objects.entities.entity.projectiles.EntityDisk;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeKeys;
import divinerpg.utils.TooltipHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemVetheanDisk extends ItemMod {
    DiskType diskType;

    public ItemVetheanDisk(String name, DiskType diskType) {
        super(name);
        this.diskType = diskType;
        this.maxStackSize = 1;
        this.setCreativeTab(DivineRPGTabs.vethea);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeKeys.rangedDam(diskType.getDamage()));
        list.add(TooltipHelper.getInfoText("tooltip.vethean_return"));
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
                                      EnumFacing side, float hitX, float hitY, float hitZ) {
        return EnumActionResult.SUCCESS;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        world.playSound(null, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);

        if (!world.isRemote) {
            EntityDisk disk = new EntityDisk(world, player, this.diskType, itemstack.getItem());
            disk.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(disk);
        }

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}