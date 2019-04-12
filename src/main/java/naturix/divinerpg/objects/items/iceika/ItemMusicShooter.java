package naturix.divinerpg.objects.items.iceika;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.entities.entity.projectiles.EntitySoundOfCarols;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySoundOfMusic;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMusicShooter extends ItemMod {

    public ItemMusicShooter(String name) {
        super(name, DRPGCreativeTabs.ranged);
        setMaxStackSize(1);
        setMaxDamage(4000);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        if (this == ModItems.soundOfCarols) {
            list.add(TooltipLocalizer.rangedDam(16));
        } else {
            list.add(TooltipLocalizer.rangedDam(10));
        }
        list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getMetadata()));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!world.isRemote) {
            if (this == ModItems.soundOfCarols) {
                EntityThrowable bullet = new EntitySoundOfCarols(world, player);
                bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(bullet);
                world.playSound(null, player.getPosition(), ModSounds.SOUND_OF_CAROLS, SoundCategory.MASTER, 1, 1);
            } else {
                EntityThrowable bullet = new EntitySoundOfMusic(world, player);
                bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(bullet);
                world.playSound(null, player.getPosition(), ModSounds.SOUND_OF_MUSIC, SoundCategory.MASTER, 1, 1);
            }
            if (!player.capabilities.isCreativeMode) {
                stack.damageItem(1, player);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}
