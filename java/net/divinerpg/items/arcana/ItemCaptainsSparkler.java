package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntitySparkler;
import net.divinerpg.items.base.ItemModRanged;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCaptainsSparkler extends ItemModRanged {

    public ItemCaptainsSparkler(String name) {
        super(name, -1, Sounds.sparkler, EntitySparkler.class);
        this.setFull3D();
    }

    @Override
    protected boolean additionalRightClickChecks(EntityPlayer player) {
        return ArcanaHelper.getProperties(player).useBar(15);
    }

    @Override
    protected void addAdditionalInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	list.add(TooltipLocalizer.rangedDam(20));
        list.add(TooltipLocalizer.arcanaConsumed(7));
    }
}
