package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.client.ArcanaHelper;
import naturix.divinerpg.objects.entities.entity.projectiles.EntitySparkler;
import naturix.divinerpg.objects.items.base.ItemModRanged;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCaptainsSparkler extends ItemModRanged {

    public ItemCaptainsSparkler(String name) {
        super(name, -1, ModSounds.SPARKLER, EntitySparkler.class);
    }

    @Override
    protected void addAdditionalInformation(ItemStack stack, @Nullable World worldIn, List<String> list,
            ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.rangedDam(20));
        list.add(TooltipLocalizer.arcanaConsumed(7));
    }

    @Override
    protected boolean additionalRightClickChecks(EntityPlayer player) {
    	IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
        if(arcana.getArcana()>=7) {
        	arcana.consume(7);
        	return true;
        }else {
        	return false;
        }
    }
}