package naturix.divinerpg.objects.items.arcana;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.capabilities.ArcanaProvider;
import naturix.divinerpg.capabilities.IArcana;
import naturix.divinerpg.objects.entities.entity.arcana.Wraith;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.utils.TooltipHelper;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGhostbane extends ItemMod {

    public ItemGhostbane() {
        super("ghostbane", DivineRPGTabs.spawner);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World w, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        Wraith wraith = new Wraith(w);
        IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP, null);
        if (!w.isRemote && arcana.getArcana() >= 200) {
            wraith.setLocationAndAngles(pos.getX(), pos.getY() + 1, pos.getZ(), 0.0F, 0.0F);
            w.spawnEntity(wraith);
            arcana.consume(player, 200);
            return EnumActionResult.PASS;
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(TooltipLocalizer.arcanaConsumed(200));
        list.add(TooltipHelper.getInfoText("tooltip.ghostbane.spawn"));
        list.add(TooltipHelper.getInfoText("tooltip.ghostbane.damage"));
        list.add(TooltipHelper.getInfoText("tooltip.ghostbane.health"));
        list.add(TooltipHelper.getInfoText("tooltip.ghostbane.despawn"));
    }
}