package divinerpg.objects.items.arcana;

import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.objects.entities.entity.arcana.Wraith;
import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.TooltipHelper;
import divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemGhostbane extends ItemMod {

    public ItemGhostbane() {
        super("ghostbane", DivineRPGTabs.spawner);
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        IArcana arcana = DivineAPI.getArcana(player);
        if (!world.isRemote && arcana.getArcana() >= 200) {
            Wraith wraith = new Wraith(world, player);
            wraith.setLocationAndAngles(pos.getX(), pos.getY() + 1, pos.getZ(), 0.0F, 0.0F);
            world.spawnEntity(wraith);
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