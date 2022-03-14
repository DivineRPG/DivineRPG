package divinerpg.events;

import divinerpg.capability.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.*;

import java.util.*;

public class ArmorAbilitiesEvent
{
    private static Item boots, body = null, legs = null, helmet = null;

    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            ItemStack stackBoots = player.inventory.armor.get(0);
            ItemStack stackLegs = player.inventory.armor.get(1);
            ItemStack stackBody = player.inventory.armor.get(2);
            ItemStack stackHelmet = player.inventory.armor.get(3);

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
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.2D, 0));
            }

            //Skythern
            if (boots == ItemRegistry.skythernBoots && body == ItemRegistry.skythernChestplate && legs == ItemRegistry.skythernLeggings && helmet == ItemRegistry.skythernHelmet) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.5D, 0));
            }

            //Vethean

            if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningHood) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.2D, 0));
            }

            if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedHood) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.3D, 0));
            }

            if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedHood) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.4D, 0));
            }

        }
    }

    @SubscribeEvent
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        if (e.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) e.getEntity();

            ItemStack stackBoots = player.inventory.armor.get(0);
            ItemStack stackLegs = player.inventory.armor.get(1);
            ItemStack stackBody = player.inventory.armor.get(2);
            ItemStack stackHelmet = player.inventory.armor.get(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackBody != null) body = stackBody.getItem();
            else body = null;

            if (stackLegs != null) legs = stackLegs.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;

            DamageSource s = e.getSource();

            if ((boots == ItemRegistry.aquastriveBoots && body == ItemRegistry.aquastriveChestplate && legs == ItemRegistry.aquastriveLeggings && helmet == ItemRegistry.aquastriveHelmet)
                    || (boots == ItemRegistry.krakenBoots && body == ItemRegistry.krakenChestplate && legs == ItemRegistry.krakenLeggings && helmet == ItemRegistry.krakenHelmet)) {
                if (s.equals(DamageSource.DROWN)) {
                    e.setCanceled(true);
                }
            }

            if (boots == ItemRegistry.apalachiaBoots && legs == ItemRegistry.apalachiaLeggings && body == ItemRegistry.apalachiaChestplate && helmet == ItemRegistry.apalachiaHelmet) {
                if (s.equals(DamageSource.CACTUS) || s.equals(DamageSource.FALLING_BLOCK) || s.equals(DamageSource.ANVIL) || s.equals(DamageSource.IN_WALL) || s.equals(DamageSources.trapSource)) {
                    e.setCanceled(true);
                }
            }

            if (boots == ItemRegistry.witherReaperBoots && legs == ItemRegistry.witherReaperLeggings && body == ItemRegistry.witherReaperChestplate && helmet == ItemRegistry.witherReaperHelmet) {
                if (s.equals(DamageSource.WITHER)) {
                    e.setCanceled(true);
                }
            }

            if (boots == ItemRegistry.jungleBoots && legs == ItemRegistry.jungleLeggings && body == ItemRegistry.jungleChestplate && helmet == ItemRegistry.jungleHelmet) {
                if (s.equals(DamageSource.MAGIC)) {
                    e.setCanceled(true);
                }
            }
            if ((boots == ItemRegistry.bedrockBoots && legs == ItemRegistry.bedrockLeggings && body == ItemRegistry.bedrockChestplate && helmet == ItemRegistry.bedrockHelmet)) {
                if (s.isExplosion()) {
                    e.setCanceled(true);
                }
            }

            //Ender
            if ((boots == ItemRegistry.enderBoots || boots == ItemRegistry.redEnderBoots || boots == ItemRegistry.yellowEnderBoots || boots == ItemRegistry.greenEnderBoots || boots == ItemRegistry.blueEnderBoots || boots == ItemRegistry.grayEnderBoots) && (legs == ItemRegistry.enderLeggings || legs == ItemRegistry.redEnderLeggings || legs == ItemRegistry.yellowEnderLeggings || legs == ItemRegistry.greenEnderLeggings || legs == ItemRegistry.blueEnderLeggings || legs == ItemRegistry.grayEnderLeggings) && (body == ItemRegistry.enderChestplate || body == ItemRegistry.redEnderChestplate || body == ItemRegistry.yellowEnderChestplate || body == ItemRegistry.greenEnderChestplate || body == ItemRegistry.blueEnderChestplate || body == ItemRegistry.grayEnderChestplate) && (helmet == ItemRegistry.enderHelmet || helmet == ItemRegistry.redEnderHelmet || helmet == ItemRegistry.yellowEnderHelmet || helmet == ItemRegistry.greenEnderHelmet || helmet == ItemRegistry.blueEnderHelmet || helmet == ItemRegistry.grayEnderHelmet)) {
                if (s.isExplosion()) {
                    e.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
        if (e.getSource().getDirectEntity() != null && e.getSource().getDirectEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) e.getSource().getDirectEntity();

            ItemStack stackBoots = player.inventory.armor.get(0);
            ItemStack stackLeggings = player.inventory.armor.get(1);
            ItemStack stackChestplate = player.inventory.armor.get(2);
            ItemStack stackHelmet = player.inventory.armor.get(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackChestplate != null) body = stackChestplate.getItem();
            else body = null;

            if (stackLeggings != null) legs = stackLeggings.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;


            DamageSource s = e.getSource();

            if (boots == ItemRegistry.santaBoots && body == ItemRegistry.santaChestplate && legs == ItemRegistry.santaLeggings && helmet == ItemRegistry.santaHelmet) {
            if ((e.getEntity().level.dimension() == KeyRegistry.ICEIKA_WORLD) && ((s.getDirectEntity().getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagic())) {
                e.setAmount(e.getAmount() + 6);
            }
            }

            //Halite
            if (boots == ItemRegistry.haliteBoots && body == ItemRegistry.haliteChestplate && legs == ItemRegistry.haliteLeggings && helmet == ItemRegistry.haliteHelmet) {
                if (((s.getDirectEntity().getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagic())) {
                    e.setAmount(e.getAmount() + 16);
                }
            }

            //Divine
            if (boots == ItemRegistry.divineBoots && body == ItemRegistry.divineChestplate && legs == ItemRegistry.divineLeggings && helmet == ItemRegistry.divineHelmet) {
                if (((s.getDirectEntity().getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagic())) {
                    e.setAmount(e.getAmount() + 6);
                }
            }

            //Corrupted
            if (body == ItemRegistry.corruptedChestplate && legs == ItemRegistry.corruptedLeggings && boots == ItemRegistry.corruptedBoots && helmet == ItemRegistry.corruptedHelmet) {
                if (((s.getDirectEntity().getEntity() instanceof PlayerEntity) && s.isProjectile())) {
                    e.setAmount(e.getAmount() * 1.2F);
                }
            }

            //Vethean
            if (body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningHelmet) {
                if (((s.getDirectEntity().getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagic())) {
                    e.setAmount(e.getAmount() + 3);
                }
            }

            if (body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedHelmet) {
                if (((s.getDirectEntity().getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagic())) {
                    e.setAmount(e.getAmount() + 6);
                }
            }

            if (body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedHelmet) {
                if (((s.getDirectEntity().getEntity() instanceof PlayerEntity) && !s.isProjectile() && !s.isMagic())) {
                    e.setAmount(e.getAmount() + 9);
                }
                //Arlemite
                if (boots == ItemRegistry.arlemiteBoots && legs == ItemRegistry.arlemiteLeggings && body == ItemRegistry.arlemiteChestplate && helmet == ItemRegistry.arlemiteHelmet) {
                    if (s.isProjectile() || s.msgId.equals("thrown")) {
                        e.setAmount(e.getAmount() * 0.3F);
                    }
                }

                //Rupee
                if ((boots == ItemRegistry.rupeeBoots || boots == ItemRegistry.redRupeeBoots || boots == ItemRegistry.yellowRupeeBoots || boots == ItemRegistry.greenRupeeBoots || boots == ItemRegistry.blueRupeeBoots || boots == ItemRegistry.grayRupeeBoots) && (legs == ItemRegistry.rupeeLeggings || legs == ItemRegistry.redRupeeLeggings || legs == ItemRegistry.yellowRupeeLeggings || legs == ItemRegistry.greenRupeeLeggings || legs == ItemRegistry.blueRupeeLeggings || legs == ItemRegistry.grayRupeeLeggings) && (body == ItemRegistry.rupeeChestplate || body == ItemRegistry.redRupeeChestplate || body == ItemRegistry.yellowRupeeChestplate || body == ItemRegistry.greenRupeeChestplate || body == ItemRegistry.blueRupeeChestplate || body == ItemRegistry.grayRupeeChestplate) && (helmet == ItemRegistry.rupeeHelmet || helmet == ItemRegistry.redRupeeHelmet || helmet == ItemRegistry.yellowRupeeHelmet || helmet == ItemRegistry.greenRupeeHelmet || helmet == ItemRegistry.blueRupeeHelmet || helmet == ItemRegistry.grayRupeeHelmet)) {
                    if ((s.msgId.equals("mob")) && !s.isProjectile()) {
                        e.setAmount(e.getAmount() * 0.3F);
                    }
                }

                //Santa
                if (boots == ItemRegistry.santaBoots && legs == ItemRegistry.santaLeggings && body == ItemRegistry.santaChestplate && helmet == ItemRegistry.santaHelmet) {
                if (e.getEntity().level.dimension() == KeyRegistry.ICEIKA_WORLD) {
                    e.setAmount(e.getAmount() * 0.2F);
                }
                }

                //Vethean

                if (body == ItemRegistry.degradedChestplate && legs == ItemRegistry.degradedLeggings && boots == ItemRegistry.degradedBoots) {
                    if ((helmet == ItemRegistry.degradedHelmet && !s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.degradedMask && s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.degradedHood && s.isMagic()))
                        e.setAmount(e.getAmount() * 0.82F);
                    ;
                }

                if (body == ItemRegistry.finishedChestplate && legs == ItemRegistry.finishedLeggings && boots == ItemRegistry.finishedBoots) {
                    if ((helmet == ItemRegistry.finishedHelmet && !s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.finishedMask && s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.finishedHood && s.isMagic()))
                        e.setAmount(e.getAmount() * 0.773F);
                    ;
                }

                if (body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots) {
                    if ((helmet == ItemRegistry.glisteningHelmet && !s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.glisteningMask && s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.glisteningHood && s.isMagic()))
                        e.setAmount(e.getAmount() * 0.7F);
                    ;
                }

                if (body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots) {
                    if ((helmet == ItemRegistry.demonizedHelmet && !s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.demonizedMask && s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.demonizedHood && s.isMagic()))
                        e.setAmount(e.getAmount() * 0.625F);
                    ;
                }

                if (body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots) {
                    if ((helmet == ItemRegistry.tormentedHelmet && !s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.tormentedMask && s.isProjectile() && !s.isMagic()) || (helmet == ItemRegistry.tormentedHood && s.isMagic()))
                        e.setAmount(e.getAmount() * 0.348F);
                    ;
                }
            }
        }
    }

    private static final String SWIM_MOD_STRING = "c7b490d7-2bfc-400f-b7bb-e89670daea62";
    public static final AttributeModifier SWIM_MOD = new AttributeModifier(SWIM_MOD_STRING, 2.0D, AttributeModifier.Operation.ADDITION);
    private boolean flightFlag = false, swimFlag, shadow = true;
    @SubscribeEvent
    public void onTickEvent(TickEvent.PlayerTickEvent evt) {
        PlayerEntity player = evt.player;
        ModifiableAttributeInstance swim = player.getAttribute(ForgeMod.SWIM_SPEED.get());


            NonNullList<ItemStack> armour = player.inventory.armor;
            DamageSource damageSource = player.getLastDamageSource();
            Item helmet = armour.get(3).getItem();
            Item body = armour.get(2).getItem();
            Item legs = armour.get(1).getItem();
            Item boots = armour.get(0).getItem();

        if(boots == ItemRegistry.angelicBoots && legs == ItemRegistry.angelicLeggings && body == ItemRegistry.angelicChestplate && helmet == ItemRegistry.angelicHelmet){
            flightFlag = true;
        }
        if (flightFlag) {
            player.abilities.mayfly = true;
            player.fallDistance = 0;
            flightFlag = false;
        }else {
            if (!player.isCreative() && !player.isSpectator()) {
                player.abilities.mayfly = false;
                player.abilities.flying = false;
            }
        }


        if(boots == ItemRegistry.aquastriveBoots && legs == ItemRegistry.aquastriveLeggings && body == ItemRegistry.aquastriveChestplate && helmet == ItemRegistry.aquastriveHelmet && swimFlag) {
            swim.addTransientModifier(SWIM_MOD);
            swimFlag = false;
        }

        if(boots != ItemRegistry.aquastriveBoots && legs != ItemRegistry.aquastriveLeggings && body != ItemRegistry.aquastriveChestplate && helmet != ItemRegistry.aquastriveHelmet && !swimFlag){
            swim.removeModifier(SWIM_MOD);
            swimFlag = true;
        }


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
            evt.player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null).fill(evt.player, 1);
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
            evt.player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 210, 10, true, false));
        }

        //Skythern
        if (boots == ItemRegistry.skythernBoots && body == ItemRegistry.skythernChestplate && legs == ItemRegistry.skythernLeggings && helmet == ItemRegistry.skythernHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Torridite, Inferno, and Bedrock
        if ((boots == ItemRegistry.torriditeBoots && legs == ItemRegistry.torriditeLeggings && body == ItemRegistry.torriditeChestplate && helmet == ItemRegistry.torriditeHelmet)
                || (boots == ItemRegistry.infernoBoots && legs == ItemRegistry.infernoLeggings && body == ItemRegistry.infernoChestplate && helmet == ItemRegistry.infernoHelmet)
                || (boots == ItemRegistry.bedrockBoots && legs == ItemRegistry.bedrockLeggings && body == ItemRegistry.bedrockChestplate && helmet == ItemRegistry.bedrockHelmet)) {
            evt.player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 40, 0, true, false));
        }

        //Shadow
        if (boots == ItemRegistry.shadowBoots && body == ItemRegistry.shadowChestplate && legs == ItemRegistry.shadowLeggings && helmet == ItemRegistry.shadowHelmet) {
            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 3, 2, false, false));
            if (shadow) {
                evt.player.maxUpStep = 1;
                shadow = false;
            }
        }
        if (boots != ItemRegistry.shadowBoots || legs != ItemRegistry.shadowLeggings || body != ItemRegistry.shadowChestplate || helmet != ItemRegistry.shadowHelmet) {
            if(!shadow) {
                evt.player.maxUpStep = 0.6F;
            }
            shadow = true;
        }

        //Frozen
        if (boots == ItemRegistry.frozenBoots && body == ItemRegistry.frozenChestplate && legs == ItemRegistry.frozenLeggings && helmet == ItemRegistry.frozenHelmet && !evt.player.getCommandSenderWorld().isClientSide) {
            List<Entity> entities = evt.player.getCommandSenderWorld().getEntitiesOfClass(MobEntity.class, evt.player.getBoundingBox().expandTowards(6, 6, 6));
            for(Entity e : entities) {
                ((MobEntity)e).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 40, 1, true, false));
            }
        }

        //Terran
        if (boots == ItemRegistry.terranBoots && body == ItemRegistry.terranChestplate && legs == ItemRegistry.terranLeggings && helmet == ItemRegistry.terranHelmet) {
            evt.player.addEffect(new EffectInstance(Effects.DIG_SPEED, 20, 2, true, false));
        }

        //Skeleman
        if (boots == ItemRegistry.skelemanBoots && body == ItemRegistry.skelemanChestplate && legs == ItemRegistry.skelemanLeggings && helmet == ItemRegistry.skelemanHelmet) {
            if (evt.player.getFoodData().needsFood()) {
                evt.player.getFoodData().eat(1, 0);
            }
        }

        //Santa
        if (boots == ItemRegistry.santaBoots && body == ItemRegistry.santaChestplate && legs == ItemRegistry.santaLeggings && helmet == ItemRegistry.santaHelmet) {
            if (evt.player.level.dimension() == KeyRegistry.ICEIKA_WORLD) {
                if (evt.player.getFoodData().needsFood()) {
                    evt.player.getFoodData().eat(1, 0);
                }
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 3, 1, false, false));
            }
        }
        //Vethean

        if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningMask) {

            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 3, 0, false, false));
        }

        if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedMask) {

            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 3, 1, false, false));
        }

        if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedMask) {
            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 3, 2, false, false));
        }

        if(body == ItemRegistry.glisteningChestplate && legs == ItemRegistry.glisteningLeggings && boots == ItemRegistry.glisteningBoots && helmet == ItemRegistry.glisteningHood) {
            evt.player.fallDistance = -0.5F;
        }

        if(body == ItemRegistry.demonizedChestplate && legs == ItemRegistry.demonizedLeggings && boots == ItemRegistry.demonizedBoots && helmet == ItemRegistry.demonizedHood) {
            evt.player.fallDistance = -0.5F;
        }

        if(body == ItemRegistry.tormentedChestplate && legs == ItemRegistry.tormentedLeggings && boots == ItemRegistry.tormentedBoots && helmet == ItemRegistry.tormentedHood) {
            evt.player.fallDistance = -0.5F;
        }

        if(evt.player.inventory.contains(new ItemStack(ItemRegistry.minersAmulet))) evt.player.addEffect(new EffectInstance(Effects.DIG_SPEED, 1, 2, true, false));
    }
}
