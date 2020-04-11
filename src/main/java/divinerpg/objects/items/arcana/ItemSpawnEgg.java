package divinerpg.objects.items.arcana;

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

public class ItemSpawnEgg extends ItemMod {

    private final BiFunction<World, EntityPlayer, Entity> createEntityFunc;
    private final String langId;

    public ItemSpawnEgg(String name, BiFunction<World, EntityPlayer, Entity> createEntityFunc) {
        super(name, DivineRPGTabs.spawner);
        this.createEntityFunc = createEntityFunc;
        setMaxStackSize(1);

        langId = "tooltip." + name;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
                                      float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            int x = pos.getX(), y = pos.getY(), z = pos.getZ();

            Entity e = createEntityFunc.apply(world, player);
            e.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
            world.spawnEntity(e);

            if (!player.isCreative())
                player.getHeldItem(hand).shrink(1);


            return EnumActionResult.PASS;
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n(langId));
    }
}