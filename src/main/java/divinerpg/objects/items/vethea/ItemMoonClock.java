package divinerpg.objects.items.vethea;

//public class ItemMoonClock extends ItemMod {
//
//    public ItemMoonClock(String name) {
//        super(name, DivineRPGTabs.spawner);
//        setMaxStackSize(1);
//    }
//    @Override
//    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
//    {
//        if (!world.isRemote) {
//            ItemStack stack = player.getHeldItem(hand);
//            Block block = world.getBlockState(pos).getBlock();
//            RayTraceResult rtr = PositionHelper.rayTrace(player,4, 1);
//            double spawnX = rtr.getBlockPos().getX() + 0.5F;
//            double spawnY = rtr.getBlockPos().getY() + 1;
//            double spawnZ = rtr.getBlockPos().getZ() + 0.5F;
//
//            if (block == ModBlocks.lunicAltar) {
//                LadyLuna ladyluna = new LadyLuna(world);
//                ladyluna.setLocationAndAngles(spawnX, spawnY, spawnZ, 0.0F, 0.0F);
//                world.spawnEntity(ladyluna);
//                if (!player.capabilities.isCreativeMode)
//                    stack.shrink(1);
//                return EnumActionResult.PASS;
//            }if(!player.capabilities.isCreativeMode)stack.shrink(1);
//                            return EnumActionResult.PASS;
//
//                    }
//
//    return EnumActionResult.FAIL;
//    }
//
//}