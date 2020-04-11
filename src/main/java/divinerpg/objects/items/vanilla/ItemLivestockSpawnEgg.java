package divinerpg.objects.items.vanilla;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.BiFunction;

public class ItemLivestockSpawnEgg extends ItemMod {

    private final BiFunction<World, EntityPlayer, Entity> funcCreate;

    public ItemLivestockSpawnEgg(String name, BiFunction<World, EntityPlayer, Entity> funcCreate) {
        super(name, DivineRPGTabs.spawner);
        this.funcCreate = funcCreate;
        setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
                                      float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            ItemStack stack = player.getHeldItem(hand);
            int x = pos.getX(), y = pos.getY(), z = pos.getZ();

            Entity entity = funcCreate.apply(world, player);
            entity.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
            world.spawnEntity(entity);

            if (!player.isCreative())
                stack.shrink(1);

            return EnumActionResult.PASS;
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip." + stack.getItem().getUnlocalizedName()));
    }
}