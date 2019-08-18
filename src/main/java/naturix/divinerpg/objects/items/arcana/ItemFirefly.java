package naturix.divinerpg.objects.items.arcana;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityFirefly;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFirefly extends RangedWeaponBase {

    public ItemFirefly() {
        super("firefly",
                EntityFirefly.class,
                null,
                ModSounds.FIREFLY,
                SoundCategory.PLAYERS,
                -1,
                0,
                null,
                5);
        setFull3D();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TooltipLocalizer.homingShots());
        tooltip.add(TooltipLocalizer.rangedDam(15));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}