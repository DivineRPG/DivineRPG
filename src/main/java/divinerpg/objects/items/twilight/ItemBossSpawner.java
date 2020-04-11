package divinerpg.objects.items.twilight;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.log.Logging;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemBossSpawner extends ItemMod {

    private final Predicate<DimensionType> canSpawn;
    private final Function<World, Entity>[] spawnderEntities;
    private final ITextComponent cantSpawnMessage;

    public ItemBossSpawner(String name, String langKey, Predicate<DimensionType> canSpawn, Function<World, Entity>... spawnedEntities) {
        super(name);
        this.canSpawn = canSpawn;
        this.spawnderEntities = spawnedEntities;
        setMaxStackSize(1);
        this.setCreativeTab(DivineRPGTabs.spawner);

        cantSpawnMessage = new TextComponentTranslation(langKey);
        cantSpawnMessage.getStyle().setColor(TextFormatting.AQUA);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
                                      float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {
            if (!canSpawn.test(world.provider.getDimensionType())) {
                Logging.message(player, cantSpawnMessage.getFormattedText());

                return EnumActionResult.FAIL;
            }

            List<Entity> toSpawn = Arrays.stream(spawnderEntities).map(x -> {
                Entity e = x.apply(world);
                e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                return e;
            }).collect(Collectors.toList());

            if (toSpawn.stream().allMatch(x -> world.getCollisionBoxes(x, x.getEntityBoundingBox()).isEmpty())) {
                toSpawn.forEach(world::spawnEntity);

                if (!player.isCreative())
                    player.getHeldItemMainhand().shrink(toSpawn.size());

                return EnumActionResult.SUCCESS;
            }
        }

        return EnumActionResult.FAIL;
    }
}