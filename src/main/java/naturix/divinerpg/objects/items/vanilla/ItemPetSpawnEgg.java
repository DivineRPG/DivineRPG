package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.entities.entity.vanilla.Ehu;
import naturix.divinerpg.objects.entities.entity.vanilla.Husk;
import naturix.divinerpg.objects.entities.entity.vanilla.Smelter;
import naturix.divinerpg.objects.entities.entity.vanilla.Snapper;
import naturix.divinerpg.objects.entities.entity.vanilla.StoneGolem;
import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;

public class ItemPetSpawnEgg extends ItemMod {

    private Class petClass;
    private String petName;
    private Class[] mobs = { Ehu.class, Husk.class, StoneGolem.class, Smelter.class, Snapper.class };

    public ItemPetSpawnEgg(String name) {
        super(name, DRPGCreativeTabs.spawner);
        setMaxStackSize(1);
    }

    public ItemPetSpawnEgg(String name, Class petClass, String petName) {
        super(name, DRPGCreativeTabs.spawner);
        this.petClass = petClass;
        this.petName = petName;
        setMaxStackSize(1);
    }
    /*
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
    
        if (world.isRemote) {
            return EnumActionResult.SUCCESS;
        } else if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
            return EnumActionResult.FAIL;
        } else {
            BlockPos blockpos = pos.offset(facing);
            double d0 = this.getYOffset(world, blockpos);
    
            Entity entity = spawnCreature(world, petClass, (double) blockpos.getX() + 0.5D,
                    (double) blockpos.getY() + d0, (double) blockpos.getZ() + 0.5D);
    
            if (entity != null) {
                if (entity instanceof EntityLivingBase && itemstack.hasDisplayName()) {
                    entity.setCustomNameTag(itemstack.getDisplayName());
                }
    
                applyItemEntityDataToEntity(worldIn, player, itemstack, entity);
    
                if (!player.capabilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
            }
    
            return EnumActionResult.SUCCESS;
        }
        try {
            Entity e = (Entity) petClass.getConstructor(World.class, EntityPlayer.class).newInstance(world, player);
            e.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
            world.spawnEntityInWorld(e);
            player.triggerAchievement(DivineRPGAchievements.petCollector);
            stack.stackSize--;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EnumActionResult.SUCCESS;
    }
    
    protected double getYOffset(World p_190909_1_, BlockPos p_190909_2_) {
        AxisAlignedBB axisalignedbb = (new AxisAlignedBB(p_190909_2_)).expand(0.0D, -1.0D, 0.0D);
        List<AxisAlignedBB> list = p_190909_1_.getCollisionBoxes((Entity) null, axisalignedbb);
    
        if (list.isEmpty()) {
            return 0.0D;
        } else {
            double d0 = axisalignedbb.minY;
    
            for (AxisAlignedBB axisalignedbb1 : list) {
                d0 = Math.max(axisalignedbb1.maxY, d0);
            }
    
            return d0 - (double) p_190909_2_.getY();
        }
    }
    
    public static Entity spawnCreature(World world, Class petClass, double x, double y, double z) {
        Entity entity = (Entity) petClass.getConstructor(World.class, EntityPlayer.class).newInstance(world, player);
        if (entity instanceof EntityLiving) {
            EntityLiving entityliving = (EntityLiving) entity;
            entity.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
            entityliving.rotationYawHead = entityliving.rotationYaw;
            entityliving.renderYawOffset = entityliving.rotationYaw;
            entityliving.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(entityliving)),
                    (IEntityLivingData) null);
            world.spawnEntity(entity);
            entityliving.playLivingSound();
            return entityliving;
        } else {
            return null;
        }
    }
    
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
            float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            try {
                Entity e = (Entity) mobs[stack.getMetadata()].getConstructor(World.class, EntityPlayer.class)
                        .newInstance(world, player);
                e.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
                world.spawnEntityInWorld(e);
                player.triggerAchievement(DivineRPGAchievements.petCollector);
                stack.stackSize--;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        String str = (String) EntityList.classToStringMapping.get(mobs[stack.getMetadata()]);
        return "item." + str.substring(4) + "Egg";
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < mobs.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> infoList, ITooltipFlag flagIn) {
        // if (this == ModItems.eggGrizzle || this == ModItems.eggGrizzleWhite) {
        // infoList.add("Spawns a pet grizzle");
        // }
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        Item item = stack.getItem();
        list.add("Spawns a pet "
                + ((String) EntityList.classToStringMapping.get(mobs[stack.getMetadata()])).substring(4));
    }
    
    @Override
    public void addNames() {
        for (int i = 0; i < mobs.length; i++) {
            LangRegistry.instance.localizeName("item", this.getUnlocalizedName(new ItemStack(this, 1, i)));
        }
    }*/
}
