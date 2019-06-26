package naturix.divinerpg.objects.items.vethea;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.client.EntityResourceLocation;
import naturix.divinerpg.enums.BulletType;
import naturix.divinerpg.objects.items.base.ItemProjectileShooter;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVetheanCannon extends ItemProjectileShooter {
	BulletType bullet;
    public ItemVetheanCannon(String name, BulletType bullet) {
    	super(name, bullet, ModSounds.BLITZ, ModItems.acid, -1, 0);
        this.setCreativeTab(DivineRPGTabs.vethea);
        this.bullet=bullet;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.rangedDam(bullet.getDamage()));
        list.add(TooltipLocalizer.infiniteUses());
        list.add(TooltipLocalizer.ammo(ModItems.acid));
        list.add(TooltipLocalizer.vethean());
    }
}