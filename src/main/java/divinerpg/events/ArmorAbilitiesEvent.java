package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemDivineArmor;
import divinerpg.registries.ItemRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class ArmorAbilitiesEvent
{
    private static Item boots, body = null, legs = null, helmet = null;
    @SubscribeEvent
    public static void detectArmor(LivingEquipmentChangeEvent event)
    {
        if(event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLeggings = player.inventory.armorItemInSlot(1);
            ItemStack stackChestplate = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackChestplate != null) body = stackChestplate.getItem();
            else body = null;

            if (stackLeggings != null) legs = stackLeggings.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;

            DamageSource s = event.getEntityLiving().getLastDamageSource();

            if ((boots == ItemRegistry.bedrockBoots && legs == ItemRegistry.bedrockLeggings && body == ItemRegistry.bedrockChestplate && helmet == ItemRegistry.bedrockHelmet)) {
                if (s.isExplosion()) {
                    event.setCanceled(true);
                }
            }

            //Ender
            if ((boots == ItemRegistry.enderBoots || boots == ItemRegistry.redEnderBoots || boots == ItemRegistry.yellowEnderBoots || boots == ItemRegistry.greenEnderBoots || boots == ItemRegistry.blueEnderBoots || boots == ItemRegistry.grayEnderBoots) && (legs == ItemRegistry.enderLeggings || legs == ItemRegistry.redEnderLeggings || legs == ItemRegistry.yellowEnderLeggings || legs == ItemRegistry.greenEnderLeggings || legs == ItemRegistry.blueEnderLeggings || legs == ItemRegistry.grayEnderLeggings) && (body == ItemRegistry.enderChestplate || body == ItemRegistry.redEnderChestplate || body == ItemRegistry.yellowEnderChestplate || body == ItemRegistry.greenEnderChestplate || body == ItemRegistry.blueEnderChestplate || body == ItemRegistry.grayEnderChestplate) && (helmet == ItemRegistry.enderHelmet || helmet == ItemRegistry.redEnderHelmet || helmet == ItemRegistry.yellowEnderHelmet || helmet == ItemRegistry.greenEnderHelmet || helmet == ItemRegistry.blueEnderHelmet || helmet == ItemRegistry.grayEnderHelmet)) {
                if (s.isExplosion()) {
                    event.setCanceled(true);
                }
            }


            //TODO - armour attributes
            //Arlemite
            if (boots == ItemRegistry.arlemiteBoots && legs == ItemRegistry.arlemiteLeggings && body == ItemRegistry.arlemiteChestplate && helmet == ItemRegistry.arlemiteHelmet) {
                if (s.isProjectile() || s.damageType.equals("thrown")) {
//                    evt.ammount *= 0.3;
                }
            }

            //Rupee
            if ((boots == ItemRegistry.rupeeBoots || boots == ItemRegistry.redRupeeBoots || boots == ItemRegistry.yellowRupeeBoots || boots == ItemRegistry.greenRupeeBoots || boots == ItemRegistry.blueRupeeBoots || boots == ItemRegistry.grayRupeeBoots) && (legs == ItemRegistry.rupeeLeggings || legs == ItemRegistry.redRupeeLeggings || legs == ItemRegistry.yellowRupeeLeggings || legs == ItemRegistry.greenRupeeLeggings || legs == ItemRegistry.blueRupeeLeggings || legs == ItemRegistry.grayRupeeLeggings) && (body == ItemRegistry.rupeeChestplate || body == ItemRegistry.redRupeeChestplate || body == ItemRegistry.yellowRupeeChestplate || body == ItemRegistry.greenRupeeChestplate || body == ItemRegistry.blueRupeeChestplate || body == ItemRegistry.grayRupeeChestplate) && (helmet == ItemRegistry.rupeeHelmet || helmet == ItemRegistry.redRupeeHelmet || helmet == ItemRegistry.yellowRupeeHelmet || helmet == ItemRegistry.greenRupeeHelmet || helmet == ItemRegistry.blueRupeeHelmet || helmet == ItemRegistry.grayRupeeHelmet)) {
                if ((s.damageType.equals("mob")) && !s.isProjectile()) {
//                    event.ammount *= 0.3;
                }
            }

            //Santa
            if (boots == ItemRegistry.santaBoots && legs == ItemRegistry.santaLeggings && body == ItemRegistry.santaChestplate && helmet == ItemRegistry.santaHelmet) {
//                if (evt.entityLiving.worldObj.provider.dimensionId == ConfigurationHelper.iceika) {
//                    event.ammount *= 0.2;
//                }
            }

            //Vethean

//            if(body == ItemRegistry.degradedChestplate && legs == ItemRegistry.degradedLeggings && boots == ItemRegistry.degradedBoots) {
//                if((helmet == ItemRegistry.degradedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.degradedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.degradedHood && s.isMagicDamage())) evt.ammount *= 0.82;
//            }
//
//            if(body == ItemRegistry.finishedChestplate && legs == ItemRegistry.finishedLeggings && boots == ItemRegistry.finishedBoots) {
//                if((helmet == ItemRegistry.finishedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.finishedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.finishedHood && s.isMagicDamage())) evt.ammount *= 0.773;
//            }
//
//            if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots) {
//                if((helmet == ItemRegistry.glisteningHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.glisteningMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.glisteningHood && s.isMagicDamage())) evt.ammount *= 0.7;
//            }
//
//            if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots) {
//                if((helmet == ItemRegistry.demonizedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.demonizedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.demonizedHood && s.isMagicDamage())) evt.ammount *= 0.625;
//            }
//
//            if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots) {
//                if((helmet == ItemRegistry.tormentedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.tormentedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == ItemRegistry.tormentedHood && s.isMagicDamage())) evt.ammount *= 0.348;
//            }

        }
    }


    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            ItemStack stackBody = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackBody != null) body = stackBody.getItem();
            else body = null;

            if (stackLegs != null) legs = stackLegs.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;

            //Divine
            if (boots == ItemRegistry.divineBoots && body == ItemRegistry.divineChestplate && legs == ItemRegistry.divineLeggings && helmet == ItemRegistry.divineHelmet) {
                player.addVelocity(0, 0.2D, 0);
            }

            //Skythern
            if (boots == ItemRegistry.skythernBoots && body == ItemRegistry.skythernChestplate && legs == ItemRegistry.skythernLeggings && helmet == ItemRegistry.skythernHelmet) {
                player.addVelocity(0, 0.5D, 0);
            }

            //Vethean

            if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningHood) {
                player.addVelocity(0, 0.2D, 0);
            }

            if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedHood) {
                player.addVelocity(0, 0.3D, 0);
            }

            if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedHood) {
                player.addVelocity(0, 0.4D, 0);
            }

        }
    }

        //TODO - Convert to blockdrop json
//    @SubscribeEvent
//    public void onBlockDrops(PlayerEvent.HarvestCheck event) {
//        Block block = event.getTargetBlock().getBlock();
//        if (block != null && block instanceof BlockMod && ((BlockMod)block).isTwilightOre()) {
//            if(event.getPlayer() != null && event.getPlayer() instanceof PlayerEntity) {
//                PlayerEntity player = event.getPlayer();
//                ItemStack stackBoots = player.inventory.armorItemInSlot(0);
//                ItemStack stackLegs = player.inventory.armorItemInSlot(1);
//                ItemStack stackBody = player.inventory.armorItemInSlot(2);
//                ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
//
//                if (stackBoots != null) boots = stackBoots.getItem();
//                else boots = null;
//
//                if (stackBody != null) body = stackBody.getItem();
//                else body = null;
//
//                if (stackLegs != null) legs = stackLegs.getItem();
//                else legs = null;
//
//                if (stackHelmet != null) helmet = stackHelmet.getItem();
//                else helmet = null;
//
//                //Eden
//                if (boots == ItemRegistry.edenBoots && body == ItemRegistry.edenChestplate && legs == ItemRegistry.edenLeggings && helmet == ItemRegistry.edenHelmet) {
//                    if(!event.isSilkTouching) {
//                        ItemStack fragment = event.drops.get(0);
//                        event.drops.add(fragment.copy());
//                        event.drops.add(fragment.copy());
//                        event.drops.add(fragment.copy());
//                    }
//                }
//            }
//        }
//        }


    @SubscribeEvent
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        if (e.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) e.getEntity();

            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            ItemStack stackBody = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackBody != null) body = stackBody.getItem();
            else body = null;

            if (stackLegs != null) legs = stackLegs.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;

            DamageSource s = e.getSource();

            //Kraken and Aquastrive
            if ((boots == ItemRegistry.aquastriveBoots && body == ItemRegistry.aquastriveChestplate && legs == ItemRegistry.aquastriveLeggings && helmet == ItemRegistry.aquastriveHelmet)
                    || (boots == ItemRegistry.krakenBoots && body == ItemRegistry.krakenChestplate && legs == ItemRegistry.krakenLeggings && helmet == ItemRegistry.krakenHelmet)) {
                if (s.equals(DamageSource.DROWN)) {
                    e.setCanceled(true);
                }
            }

            //Uvite
            if (boots == ItemRegistry.apalachiaBoots && legs == ItemRegistry.apalachiaLeggings && body == ItemRegistry.apalachiaChestplate && helmet == ItemRegistry.apalachiaHelmet) {
                if (s.equals(DamageSource.CACTUS) || s.equals(DamageSource.FALLING_BLOCK) || s.equals(DamageSource.ANVIL) || s.equals(DamageSource.IN_WALL) || s.equals(DamageSources.trapSource)) {
                    e.setCanceled(true);
                }
            }

            //Wither Reaper
            if (boots == ItemRegistry.witherReaperBoots && legs == ItemRegistry.witherReaperLeggings && body == ItemRegistry.witherReaperChestplate && helmet == ItemRegistry.witherReaperHelmet) {
                if (s.equals(DamageSource.WITHER)) {
                    e.setCanceled(true);
                }
            }

            //Jungle
            if (boots == ItemRegistry.jungleBoots && legs == ItemRegistry.jungleLeggings && body == ItemRegistry.jungleChestplate && helmet == ItemRegistry.jungleHelmet) {
                if (s.equals(DamageSource.MAGIC)) {
                    e.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
        if (e.getSource().getTrueSource() != null && e.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) e.getSource().getTrueSource();

            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLeggings = player.inventory.armorItemInSlot(1);
            ItemStack stackChestplate = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackChestplate != null) body = stackChestplate.getItem();
            else body = null;

            if (stackLeggings != null) legs = stackLeggings.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;
        }

        DamageSource s = e.getSource();

        //TODO - armor damage reductions
//        //Santa
//        if (boots == ItemRegistry.santaBoots && body == ItemRegistry.santaTunic && legs == ItemRegistry.santaPants && helmet == ItemRegistry.santaCap) {
//            if ((e.entityLiving.worldObj.provider.dimensionId == ConfigurationHelper.iceika) && ((s.getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagicDamage())) {
//                e.ammount += 6;
//            }
//        }
//
//        //Halite
//        if (boots == ItemRegistry.haliteBoots && body == ItemRegistry.haliteChestplate && legs == ItemRegistry.haliteLeggings && helmet == ItemRegistry.haliteHelmet) {
//            if (((s.getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagicDamage())) {
//                e.ammount += 16;
//            }
//        }
//
//        //Divine
//        if (boots == ItemRegistry.divineBoots && body == ItemRegistry.divineChestplate && legs == ItemRegistry.divineLeggings && helmet == ItemRegistry.divineHelmet) {
//            if (((s.getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagicDamage())) {
//                e.ammount += 6;
//            }
//        }
//
//        //Corrupted
//        if(body == ItemRegistry.corruptedChestplate && legs == ItemRegistry.corruptedLeggings && boots == ItemRegistry.corruptedBoots && helmet == ItemRegistry.corruptedHelmet) {
//            if (((s.getEntity() instanceof PlayerEntity) && s.isProjectile())) {
//                e.ammount *= 1.2;
//            }
//        }
//
//        //Vethean
//        if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningHelmet) {
//            if (((s.getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagicDamage())) {
//                e.ammount += 3;
//            }
//        }
//
//        if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedHelmet) {
//            if (((s.getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagicDamage())) {
//                e.ammount += 6;
//            }
//        }
//
//        if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedHelmet) {
//            if (((s.getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagicDamage())) {
//                e.ammount += 9;
//            }
        }

    private float flyTemp;

    public static final String[] isImmuneToFire = new String[] { "ae", "field_70178_ae", "isImmuneToFire" };
    public static final String[] isJumping      = new String[] { "bc", "field_70703_bu", "isJumping" };
    public static final String[] walkSpeed      = new String[] { "g", "field_75097_g", "walkSpeed" };
    private World world;

    @SubscribeEvent
    public void onTickEvent(TickEvent.PlayerTickEvent evt) {
        world = evt.player.world;
        ItemStack stackBoots = evt.player.inventory.armorItemInSlot(0);
        ItemStack stackLegs = evt.player.inventory.armorItemInSlot(1);
        ItemStack stackBody = evt.player.inventory.armorItemInSlot(2);
        ItemStack stackHelmet = evt.player.inventory.armorItemInSlot(3);

        float speedMultiplier = 1;

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;

        //TODO - Fly stuff
        if(boots != ItemRegistry.angelicBoots && body != ItemRegistry.angelicChestplate && legs != ItemRegistry.angelicLeggings && helmet != ItemRegistry.angelicHelmet) {
//            FlyingHelper.getProperties(evt.player).couldFly = evt.player.capabilities.allowFlying;
        }
//        if(evt.player.capabilities.isCreativeMode) FlyingHelper.getProperties(evt.player).couldFly = false;
//
//        if (boots == ItemRegistry.angelicBoots && body == ItemRegistry.angelicChestplate && legs == ItemRegistry.angelicLeggings && helmet == ItemRegistry.angelicHelmet && ArcanaHelper.getProperties(evt.player).getBarValue() != 0) {
//            evt.player.fallDistance = -0.5F;
//            //TODO - when pigs fly advancement
////            evt.player.triggerAchievement(DivineRPGAchievements.whenPigsFly);
//            evt.player.abilities.allowFlying = true;
//            if(evt.player.abilities.isFlying && !evt.player.abilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly) ArcanaHelper.getProperties(evt.player).useBar(0.5f);
//            if(ArcanaHelper.getProperties(evt.player).getBarValue() < 1 && !evt.player.abilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly) {
//                evt.player.abilities.isFlying = false;
//                evt.player.abilities.allowFlying = false;
//            }
//        }
//        else if(evt.player.abilities.allowFlying && !evt.player.abilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly){
//            evt.player.abilities.isFlying = false;
//            evt.player.abilities.allowFlying = false;
//        }

        //Elite Realmite
        if (boots == ItemRegistry.eliteRealmiteBoots && body == ItemRegistry.eliteRealmiteChestplate && legs == ItemRegistry.eliteRealmiteLeggings && helmet == ItemRegistry.eliteRealmiteHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Divine
        if (boots == ItemRegistry.divineBoots && body == ItemRegistry.divineChestplate && legs == ItemRegistry.divineLeggings && helmet == ItemRegistry.divineHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Wildwood
        if (boots == ItemRegistry.wildwoodBoots && body == ItemRegistry.wildwoodChestplate && legs == ItemRegistry.wildwoodLeggings && helmet == ItemRegistry.wildwoodHelmet) {
            if (evt.player.isInWater()) {
                float current = evt.player.getHealth();
                if ((current > 0.0F) && (current < 20.0F)) {
                    evt.player.heal(0.25f);
                }
            }
        }

        //Korma
        if (boots == ItemRegistry.kormaBoots && body == ItemRegistry.kormaChestplate && legs == ItemRegistry.kormaLeggings && helmet == ItemRegistry.kormaHelmet) {
            //TODO - arcana
//            ArcanaHelper.getProperties(evt.player).regen(1);
        }

        //Vemos
        if (boots == ItemRegistry.vemosBoots && body == ItemRegistry.vemosChestplate && legs == ItemRegistry.vemosLeggings && helmet == ItemRegistry.vemosHelmet) {
            float current = evt.player.getHealth();
            if ((current > 0.0F) && (current < 20.0F)) {
                evt.player.setHealth(current + 0.1F);
            }
        }

        //Mortum
        if (boots == ItemRegistry.mortumBoots && body == ItemRegistry.mortumChestplate && legs == ItemRegistry.mortumLeggings && helmet == ItemRegistry.mortumHelmet) {
            evt.player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 210, 10, true, false));
        }

        //Skythern
        if (boots == ItemRegistry.skythernBoots && body == ItemRegistry.skythernChestplate && legs == ItemRegistry.skythernLeggings && helmet == ItemRegistry.skythernHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Torridite, Inferno, and Bedrock
        if ((boots == ItemRegistry.torriditeBoots && legs == ItemRegistry.torriditeLeggings && body == ItemRegistry.torriditeChestplate && helmet == ItemRegistry.torriditeHelmet)
                || (boots == ItemRegistry.infernoBoots && legs == ItemRegistry.infernoLeggings && body == ItemRegistry.infernoChestplate && helmet == ItemRegistry.infernoHelmet)
                || (boots == ItemRegistry.bedrockBoots && legs == ItemRegistry.bedrockLeggings && body == ItemRegistry.bedrockChestplate && helmet == ItemRegistry.bedrockHelmet)) {
            evt.player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 40, 0, true, false));
        }

        //Aquastrive
        if (boots == ItemRegistry.aquastriveBoots && body == ItemRegistry.aquastriveChestplate && legs == ItemRegistry.aquastriveLeggings && helmet == ItemRegistry.aquastriveHelmet) {
            float speed = 1.1F;
            boolean isJumping = false;
//            isJumping = (Boolean) ObfuscationReflectionHelper.getPrivateValue(PlayerEntity.class, evt.player, isJumping);

            //TODO - Water Motion stuff
//            if (evt.player.isInWater()) {
//                if (!evt.player.isSneaking() && !isJumping) {
//                    if (evt.player.getMotion().x > -speed && evt.player.getMotion().x < speed) {
//                        evt.player.motionX *= speed;
//                        evt.player.motionY = 0F;
//                    }
//                    if (evt.player.motionZ > -speed && evt.player.motionZ < speed) {
//                        evt.player.motionZ *= speed;
//                        evt.player.motionY = 0F;
//                    }
//                }
//                if (isJumping || evt.player.isSneaking()) {
//                    evt.player.motionY *= speed;
//                    if (evt.player.motionX > -speed && evt.player.motionX < speed) {
//                        evt.player.motionX *= speed;
//                    }
//                    if (evt.player.motionZ > -speed && evt.player.motionZ < speed) {
//                        evt.player.motionZ *= speed;
//                    }
//                }
//            }
        }

        //Shadow
        if (boots == ItemRegistry.shadowBoots && body == ItemRegistry.shadowChestplate && legs == ItemRegistry.shadowLeggings && helmet == ItemRegistry.shadowHelmet) {
            speedMultiplier = 3;
            evt.player.stepHeight = 1;
        }
        //Frozen
        if (boots == ItemRegistry.frozenBoots && body == ItemRegistry.frozenChestplate && legs == ItemRegistry.frozenLeggings && helmet == ItemRegistry.frozenHelmet && !evt.player.world.isRemote && Ticker.tick % 10 == 0) {
            List<Entity> entities = evt.player.world.getEntitiesWithinAABB(MobEntity.class, evt.player.getBoundingBox().expand(6, 6, 6));
            for(Entity e : entities) {
                ((MobEntity)e).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 40, 1, true, false));
            }
        }

        //Terran
        if (boots == ItemRegistry.terranBoots && body == ItemRegistry.terranChestplate && legs == ItemRegistry.terranLeggings && helmet == ItemRegistry.terranHelmet) {
            evt.player.addPotionEffect(new EffectInstance(Effects.HASTE, 20, 2, true, false));
        }

        //Skeleman
        if (boots == ItemRegistry.skelemanBoots && body == ItemRegistry.skelemanChestplate && legs == ItemRegistry.skelemanLeggings && helmet == ItemRegistry.skelemanHelmet) {
            if (evt.player.getFoodStats().needFood()) {
                evt.player.getFoodStats().addStats(1, 0);
            }
        }

        //Santa
        //TODO - Change to iceika
        if (boots == ItemRegistry.santaBoots && body == ItemRegistry.santaChestplate && legs == ItemRegistry.santaLeggings && helmet == ItemRegistry.santaHelmet) {
            if (evt.player.world.getDimensionKey() == World.OVERWORLD) {
                if (evt.player.getFoodStats().needFood()) {
                    evt.player.getFoodStats().addStats(1, 0);
                }
                speedMultiplier = 2;
            }
        }

        //Vethean

        if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningMask) {
            speedMultiplier = 1.4f;
        }

        if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedMask) {
            speedMultiplier = 1.8f;
        }

        if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedMask) {
            speedMultiplier = 2.2f;
        }

        evt.player.abilities.setWalkSpeed(0.1f*speedMultiplier);

        if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningHood) {
            evt.player.fallDistance = -0.5F;
        }

        if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedHood) {
            evt.player.fallDistance = -0.5F;
        }

        if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedHood) {
            evt.player.fallDistance = -0.5F;
        }

        if(evt.player.inventory.hasItemStack(new ItemStack(ItemRegistry.minersAmulet))) evt.player.addPotionEffect(new EffectInstance(Effects.HASTE, 1, 2, true, false));
    }
}
