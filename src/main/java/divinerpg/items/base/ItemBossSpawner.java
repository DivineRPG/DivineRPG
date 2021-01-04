package divinerpg.items.base;

import divinerpg.DivineRPG;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.*;

import java.util.function.*;

public class ItemBossSpawner extends ItemMod {

    private final Predicate<DimensionType> canSpawn;
    private final Function<World, Entity>[] spawnderEntities;
    private final String langKey;

    public ItemBossSpawner(String name, String langKey, Predicate<DimensionType> canSpawn, Function<World, Entity>... spawnedEntities) {
        super(name, new Item.Properties().group(DivineRPG.tabs.spawners).maxStackSize(1));
        this.canSpawn = canSpawn;
        this.spawnderEntities = spawnedEntities;
        this.langKey = langKey;
    }

//    @Override
//    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
//                                      float hitX, float hitY, float hitZ) {
//
//        if (!world.isRemote) {
//            if (!canSpawn.test(world.provider.getDimensionType())) {
//                TextComponentBase message = TextComponentHelper.createComponentTranslation(player, langKey);
//                message.getStyle().setColor(TextFormatting.AQUA);
//                player.sendMessage(message);
//                return EnumActionResult.FAIL;
//            }
//
//            List<Entity> toSpawn = Arrays.stream(spawnderEntities).map(x -> {
//                Entity e = x.apply(world);
//                e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
//                return e;
//            }).collect(Collectors.toList());
//
//            if (toSpawn.stream().allMatch(x -> world.getCollisionBoxes(x, x.getEntityBoundingBox()).isEmpty())) {
//                toSpawn.forEach(world::spawnEntity);
//
//                if (!player.isCreative())
//                    player.getHeldItemMainhand().shrink(toSpawn.size());
//
//                return EnumActionResult.SUCCESS;
//            }
//        }
//
//        return EnumActionResult.FAIL;
//    }
}