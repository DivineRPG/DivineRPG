package naturix.divinerpg.events;

import naturix.divinerpg.Config;
import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventArmorSet {
    private Item boots = null, body = null, legs = null, helmet = null;

    @SubscribeEvent
    public void onBlockDrops(HarvestDropsEvent event) {
        if (event.getState().getBlock() != null && event.getState().getBlock() instanceof BlockMod
                && ((BlockMod) event.getState().getBlock()).isTwilightOre()) {
            if (event.getHarvester() != null && event.getHarvester() instanceof EntityPlayer) {
                EntityPlayer player = event.getHarvester();

                ItemStack stackBoots = player.inventory.armorInventory.get(0);
                ItemStack stackLegs = player.inventory.armorInventory.get(1);
                ItemStack stackBody = player.inventory.armorInventory.get(2);
                ItemStack stackHelmet = player.inventory.armorInventory.get(3);

                if (stackBoots != null) {
                    boots = stackBoots.getItem();
                } else {
                    boots = null;
                }

                if (stackBody != null) {
                    body = stackBody.getItem();
                } else {
                    body = null;
                }

                if (stackLegs != null) {
                    legs = stackLegs.getItem();
                } else {
                    legs = null;
                }

                if (stackHelmet != null) {
                    helmet = stackHelmet.getItem();
                } else {
                    helmet = null;
                }

                // Eden
                if (boots == ModItems.edenBoots && body == ModItems.edenChestplate && legs == ModItems.edenLeggings
                        && helmet == ModItems.edenHelmet) {
                    if (!event.isSilkTouching()) {
                        ItemStack fragment = event.getDrops().get(0);
                        event.getDrops().add(fragment.copy());
                        event.getDrops().add(fragment.copy());
                        event.getDrops().add(fragment.copy());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onJump(LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();

            ItemStack stackBoots = player.inventory.armorInventory.get(0);
            ItemStack stackLegs = player.inventory.armorInventory.get(1);
            ItemStack stackBody = player.inventory.armorInventory.get(2);
            ItemStack stackHelmet = player.inventory.armorInventory.get(3);
            if (stackBoots != null) {
                boots = stackBoots.getItem();
            } else {
                boots = null;
            }
            if (stackBody != null) {
                body = stackBody.getItem();
            } else {
                body = null;
            }
            if (stackLegs != null) {
                legs = stackLegs.getItem();
            } else {
                legs = null;
            }
            if (stackHelmet != null) {
                helmet = stackHelmet.getItem();
            } else {
                helmet = null;
            }
            // Divine
            if (boots == ModItems.divineBoots && body == ModItems.divineBody && legs == ModItems.divineLegs
                    && helmet == ModItems.divineHelmet) {
                player.addVelocity(0, 0.2D, 0);
            }

            // Skythern
            if (boots == ModItems.skythernBoots && body == ModItems.skythernChestplate
                    && legs == ModItems.skythernLeggings && helmet == ModItems.skythernHelmet) {
                player.addVelocity(0, 0.5D, 0);
            }

            // Vethean

            if (body == ModItems.glisteningBody && legs == ModItems.glisteningLegs && boots == ModItems.glisteningBoots
                    && helmet == ModItems.glisteningHood) {
                player.addVelocity(0, 0.2D, 0);
            }

            if (body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots
                    && helmet == ModItems.demonizedHood) {
                player.addVelocity(0, 0.3D, 0);
            }

            if (body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots
                    && helmet == ModItems.tormentedHood) {
                player.addVelocity(0, 0.4D, 0);
            }

        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
        if (e.getSource().getTrueSource() != null && e.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getSource().getTrueSource();

            ItemStack stackBoots = player.inventory.armorInventory.get(0);
            ItemStack stackLegs = player.inventory.armorInventory.get(1);
            ItemStack stackBody = player.inventory.armorInventory.get(2);
            ItemStack stackHelmet = player.inventory.armorInventory.get(3);

            if (stackBoots != null) {
                boots = stackBoots.getItem();
            } else {
                boots = null;
            }

            if (stackBody != null) {
                body = stackBody.getItem();
            } else {
                body = null;
            }

            if (stackLegs != null) {
                legs = stackLegs.getItem();
            } else {
                legs = null;
            }

            if (stackHelmet != null) {
                helmet = stackHelmet.getItem();
            } else {
                helmet = null;
            }
        }

        DamageSource s = e.getSource();

        // Santa
        if (boots == ModItems.santaBoots && body == ModItems.santaTunic && legs == ModItems.santaPants
                && helmet == ModItems.santaCap) {
            if ((e.getEntityLiving().world.provider.getDimensionType().getId() == Config.iceikaDimensionId)
                    && ((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.setAmount(e.getAmount() + 6);
            }
        }

        // Halite
        if (boots == ModItems.haliteBoots && body == ModItems.haliteChestplate && legs == ModItems.haliteLeggings
                && helmet == ModItems.haliteHelmet) {
            if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.setAmount(e.getAmount() + 16);
            }
        }

        // Divine
        if (boots == ModItems.divineBoots && body == ModItems.divineBody && legs == ModItems.divineLegs
                && helmet == ModItems.divineHelmet) {
            if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.setAmount(e.getAmount() + 6);
            }
        }

        // Corrupted
        if (body == ModItems.corruptedBody && legs == ModItems.corruptedLegs && boots == ModItems.corruptedBoots
                && helmet == ModItems.corruptedHelmet) {
            if (((s.getTrueSource() instanceof EntityPlayer) && s.isProjectile())) {
                e.setAmount(e.getAmount() * 1.2F);
            }
        }

        // Vethean
        if (body == ModItems.glisteningBody && legs == ModItems.glisteningLegs && boots == ModItems.glisteningBoots
                && helmet == ModItems.glisteningHelmet) {
            if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.setAmount(e.getAmount() + 3);
            }
        }

        if (body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots
                && helmet == ModItems.demonizedHelmet) {
            if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.setAmount(e.getAmount() + 6);
            }
        }

        if (body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots
                && helmet == ModItems.tormentedHelmet) {
            if (((s.getTrueSource() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.setAmount(e.getAmount() + 9);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        // if(e.getEntityLiving().world.isRemote) {
        if (e.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.getEntityLiving();

            ItemStack stackBoots = player.inventory.armorInventory.get(0);
            ItemStack stackLegs = player.inventory.armorInventory.get(1);
            ItemStack stackBody = player.inventory.armorInventory.get(2);
            ItemStack stackHelmet = player.inventory.armorInventory.get(3);

            if (stackBoots != null) {
                boots = stackBoots.getItem();
            } else {
                boots = null;
            }

            if (stackBody != null) {
                body = stackBody.getItem();
            } else {
                body = null;
            }

            if (stackLegs != null) {
                legs = stackLegs.getItem();
            } else {
                legs = null;
            }

            if (stackHelmet != null) {
                helmet = stackHelmet.getItem();
            } else {
                helmet = null;
            }

            DamageSource s = e.getSource();

            // Kraken and Aquastrive
            if ((boots == ModItems.aquastriveBoots && body == ModItems.aquastriveBody && legs == ModItems.aquastriveLegs
                    && helmet == ModItems.aquastriveHelmet)
                    || (boots == ModItems.krakenBoots && body == ModItems.krakenBody && legs == ModItems.krakenLegs
                            && helmet == ModItems.krakenHelmet)) {
                if (s.equals(DamageSource.DROWN)) {
                    e.setCanceled(true);
                }
            }

            // Uvite
            if (boots == ModItems.apalachiaBoots && legs == ModItems.apalachiaLeggings
                    && body == ModItems.apalachiaChestplate && helmet == ModItems.apalachiaHelmet) {
                if (s.equals(DamageSource.CACTUS) || s.equals(DamageSource.FALLING_BLOCK)
                        || s.equals(DamageSource.ANVIL) || s.equals(DamageSource.IN_WALL)
                        || s.equals(Utils.trapSource)) {
                    e.setCanceled(true);
                }
            }

            // Wither Reaper
            if (boots == ModItems.witherReaperBoots && legs == ModItems.witherReaperLegs
                    && body == ModItems.witherReaperBody && helmet == ModItems.witherReaperHelmet) {
                if (s.equals(DamageSource.WITHER)) {
                    e.setCanceled(true);
                }
            }

            // Jungle
            if (boots == ModItems.jungleBoots && legs == ModItems.jungleLegs && body == ModItems.jungleBody
                    && helmet == ModItems.jungleHelmet) {
                if (s.equals(DamageSource.MAGIC)) {
                    e.setCanceled(true);
                }
            }
        }
    }
}