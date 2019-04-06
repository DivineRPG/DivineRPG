package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.enums.ProjectileType;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityShooterBullet;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemScythe extends ItemMod {
    public ItemScythe(String name) {
        super(name);
        setCreativeTab(DRPGCreativeTabs.ranged);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand handIn) {
        ItemStack stack = player.getHeldItem(handIn);

        if (!world.isRemote) {
            world.playSound(null, player.getPosition(), ModSounds.DEEP_LAUGH, SoundCategory.MASTER, 1, 1);

            ItemStack boots = player.inventory.armorItemInSlot(0);
            ItemStack legs = player.inventory.armorItemInSlot(1);
            ItemStack body = player.inventory.armorItemInSlot(2);
            ItemStack helmet = player.inventory.armorItemInSlot(3);

            boolean fullArmor = (boots != null && legs != null && body != null && helmet != null
                    && boots.getItem() == ModItems.jackOManBoots && body.getItem() == ModItems.jackOManBody
                    && legs.getItem() == ModItems.jackOManLegs && helmet.getItem() == ModItems.jackOManHelmet);
            ProjectileType projectileType = fullArmor ? ProjectileType.MEGA_SCYTHE_SHOT : ProjectileType.SCYTHE_SHOT;

            EntityShooterBullet bullet = new EntityShooterBullet(world, player, projectileType);
            bullet.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(bullet);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(handIn));
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.rangedDam(6));
        list.add(TooltipLocalizer.infiniteAmmo());
        list.add(TooltipLocalizer.infiniteUses());
    }
}
